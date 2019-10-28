package ch.dso.affilie.api.web;

import ch.dso.affilie.domaine.Affilie;
import ch.dso.affilie.infrastructure.AffilieDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AffilieController {

    @GetMapping("/affilie")
    public ResponseEntity<List<Affilie>> listAffilies(){
        log.info("/affilie rest endpoint - GET");

        return ResponseEntity.ok(AffilieDataSource.AFFILIEDATASOURCE.values().stream().collect(Collectors.toList()));
    }

    @GetMapping("/affilie/{id}")
    public ResponseEntity getAffilieById(@PathVariable("id") String id){
        log.info("/affilie/{} rest endpoint - GET",id);

        Affilie a = AffilieDataSource.AFFILIEDATASOURCE.get(Long.valueOf(id));

        if(a == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(a);

    }

    @PostMapping("/affilie")
    public ResponseEntity createAffilie(@RequestBody Affilie affilie){
        log.info("/affilie rest endpoint - POST, dto:{}", affilie);

        Long idPersist = AffilieDataSource.addAffilie(affilie);

        return ResponseEntity.created(URI.create("/affilie/" + idPersist)).build();
    }
}
