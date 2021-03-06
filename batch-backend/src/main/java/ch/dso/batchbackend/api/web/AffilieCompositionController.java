package ch.dso.batchbackend.api.web;

import ch.dso.batchbackend.infrastructure.affilie.Affilie;
import ch.dso.batchbackend.infrastructure.personne.Personne;
import ch.dso.batchbackend.domaine.AffilieComplet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AffilieCompositionController {

    @Autowired
    RestTemplate apiClient;

    @GetMapping("/affilieComplet")
    public ResponseEntity<List<AffilieComplet>> listAffilieComplet(){
        log.info("BFF /personne rest endpoint - GET");

        //iterations liste des affilies
        ResponseEntity<List<Affilie>> response = apiClient.exchange(
                "http://affilie/affilie",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Affilie>>() {});
        List<Affilie> affilies = response.getBody();

        //pour chaque affilie
        List<AffilieComplet> affilieComplets = affilies.stream().map(affilie -> {
            ResponseEntity<Personne> personneResponse = apiClient.getForEntity("http://personne/personne/" + affilie.getPersRef(),Personne.class);

            Personne personne = personneResponse.getBody();

            return new AffilieComplet(affilie,personne);
        }).collect(Collectors.toList());


        return ResponseEntity.ok(affilieComplets);
    }

    @PostMapping("/affilieComplet")
    public ResponseEntity createAffilieWithTiers(){
        return null;
    }

    @PostMapping("/affilie")
    public ResponseEntity createAffilieWithRefTiers(){
        return null;
    }


}
