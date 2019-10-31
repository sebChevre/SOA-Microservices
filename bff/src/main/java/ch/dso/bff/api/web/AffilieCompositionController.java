package ch.dso.bff.api.web;

import ch.dso.bff.api.command.CreerAffilieWithPersonneCommand;
import ch.dso.bff.domaine.AffilieComplet;
import ch.dso.bff.infrastructure.affilie.Affilie;
import ch.dso.bff.infrastructure.personne.Personne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AffilieCompositionController {

    @Autowired
    RestTemplate apiClient;

    @GetMapping("/affilieComplet")
    public ResponseEntity<List<AffilieComplet>> listAffilieComplet(){
        log.info("BFF /affilieComplet rest endpoint - GET");

        //iterations liste des affilies
        ResponseEntity<List<Affilie>> response = apiClient.exchange(
                "http://affilie/affilie",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Affilie>>() {});
        List<Affilie> affilies = response.getBody();

        //pour chaques affilies
        List<AffilieComplet> affilieComplets = affilies.stream().map(affilie -> {

            log.info("BFF /affilieComplet fnid personne with ref: " + affilie.getPersRef());

            ResponseEntity<Personne> personneResponse = apiClient.getForEntity("http://personne/personne/" + affilie.getPersRef(),Personne.class);

            Personne personne = personneResponse.getBody();

            return new AffilieComplet(affilie,personne);
        }).collect(Collectors.toList());


        return ResponseEntity.ok(affilieComplets);
    }

    @PostMapping("/affilieComplet")
    public ResponseEntity createAffilieWithTiers(@RequestBody CreerAffilieWithPersonneCommand command){
        log.info("BFF /affilieComplet rest endpoint - POST, commande: {}", command);

        HttpEntity<Personne> postPersonneRequest =
                new HttpEntity<Personne>(command.getPersonne());

        //Creation personne
        ResponseEntity<Personne> postPersonneResponse = apiClient.postForEntity("http://personne/personne",postPersonneRequest, Personne.class);
        log.info("BFF /affilieComplet POST personne response: {}-{}", postPersonneResponse.getStatusCode(),postPersonneResponse.getStatusCodeValue());
        Personne personneCree = postPersonneResponse.getBody();
        log.info("BFF /affilieComplet created personne: {}", personneCree);

        //recup id de la personne créé
        String personneId = postPersonneResponse.getHeaders().get("Location").get(0).split("/")[2];

        Affilie affilie = command.getAffilie();
        affilie.setPersRef(personneId);

        HttpEntity<Affilie> postAffilieRequest =
                new HttpEntity<Affilie>(affilie);

        ResponseEntity<Affilie> postAffilieResponse = apiClient.postForEntity("http://affilie/affilie",postAffilieRequest, Affilie.class);
        log.info("BFF /affilieComplet POST affilie response: {}-{}", postAffilieResponse.getStatusCode(),postAffilieResponse.getStatusCodeValue());


        String noAffilie = postAffilieResponse.getHeaders().get("Location").get(0).split("/")[2];

        return ResponseEntity.created(URI.create("/affilicomplet/" + noAffilie)).build();
    }

    @PostMapping("/affilie")
    public ResponseEntity createAffilieWithRefTiers(){
        return null;
    }

}
