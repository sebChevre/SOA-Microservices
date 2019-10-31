package ch.dso.personne.api.web;

import ch.dso.personne.domaine.Personne;
import ch.dso.personne.domaine.PersonneDomaineService;
import ch.dso.personne.infrastructure.PersonneDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class PersonneController {

    @GetMapping("/personne")
    public ResponseEntity<List<Personne>> listPersonne(){
        log.info("/personne rest endpoint - GET");

        return ResponseEntity.ok(PersonneDataSource.DATASOURCE.values().stream().collect(Collectors.toList()));
    }

   /** @GetMapping("/personne/{id}")
    public ResponseEntity getPersonneById(@PathVariable("id") String id){
        log.info("/personne/{} rest endpoint - GET",id);

        Personne p = PersonneDataSource.DATASOURCE.get(Long.valueOf(id));

        if(p == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(p);
    }
*/
    @GetMapping("/personne/{nss}")
    public ResponseEntity getPersonneByNss(@PathVariable("nss") String nss){
        log.info("/personne/{} rest endpoint - GET",nss);

        Optional<Personne> personneByNss = PersonneDataSource.getByNss(nss);

        if(!personneByNss.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(personneByNss.get());
    }



    @PostMapping("/personne")
    public ResponseEntity<List<Personne>> listPersonne(@RequestBody Personne personne){
        log.info("/personne rest endpoint - POST, dto:{}", personne);

        personne = new PersonneDomaineService().newPersonne(personne);
        Long idPersist = PersonneDataSource.addPersonne(personne);

        return ResponseEntity.created(URI.create("/personne/" + personne.getNss())).build();
    }



}
