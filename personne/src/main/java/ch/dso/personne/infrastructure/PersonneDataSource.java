package ch.dso.personne.infrastructure;

import ch.dso.personne.domaine.Personne;
import ch.dso.personne.domaine.PersonneDomaineService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonneDataSource {

    public static Map<Long, Personne> DATASOURCE = new HashMap<>();

    static{

        PersonneDomaineService service = new PersonneDomaineService();

        DATASOURCE.put(1l, service.newPersonne(
                Personne.newPersonne("Mouse", "Mickey", "DisneyLand", "756.1234.5678.90","Paris", LocalDate.of(1920, 1, 1)))
        );
        DATASOURCE.put(2l, service.newPersonne(
                Personne.newPersonne("Picsou", "Balthasar", "DisneyLand", "756.1235.8765.01","Paris", LocalDate.of(1931, 2, 12)))
        );
    }

    public static Long addPersonne(Personne personne){
        Long nextId = DATASOURCE.keySet().stream().max(Comparator.comparing(Long::intValue)).get() + 1;
        DATASOURCE.put(nextId, personne);
        return nextId;
    }

    public static boolean nssPersonneExist(String nss){
        Optional<Personne> personneWithSameNss = DATASOURCE.values().stream().filter(personne -> {
            return personne.getNss().equals(nss);
        }).findFirst();

        return personneWithSameNss.isPresent();
    }

    public static Optional<Personne> getByNss(String nss){
        return DATASOURCE.values().stream().filter(personne -> {
            return personne.getNss().equals(nss);
        }).findFirst();
    }
}
