package ch.dso.affilie.api.web;

import ch.dso.affilie.domaine.Affilie;
import ch.dso.affilie.domaine.AffilieDomaineService;
import ch.dso.affilie.infrastructure.AffilieDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AffilieController {

    @GetMapping("/affilie")
    public ResponseEntity<List<Affilie>> listAffilies(){
        log.info("/affilie rest endpoint - GET");

        return ResponseEntity.ok(AffilieDataSource.AFFILIEDATASOURCE.values().stream().collect(Collectors.toList()));
    }

    @GetMapping("/affilie/{noAffilie}")
    public ResponseEntity getAffilieByNoAffilie(@PathVariable("noAffilie") String noAffilie){
        log.info("/affilie/{} rest endpoint - GET", noAffilie);

        Optional<Affilie> affiie = AffilieDataSource.getByNoAffilie(noAffilie);

        if(!affiie.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(affiie.get());

    }

    @PostMapping("/affilie")
    public ResponseEntity createAffilie(@RequestBody Affilie affilie){
        log.info("/affilie rest endpoint - POST, dto:{}", affilie);

        affilie = new AffilieDomaineService().newAffilie(affilie);

        Long idPersist = AffilieDataSource.addAffilie(affilie);

        return ResponseEntity.created(URI.create("/affilie/" + affilie.getNoAffilie())).build();
    }
}
