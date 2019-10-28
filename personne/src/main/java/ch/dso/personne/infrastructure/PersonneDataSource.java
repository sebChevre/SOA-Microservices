package ch.dso.personne.infrastructure;

import ch.dso.personne.domaine.Personne;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PersonneDataSource {

    public static Map<Long, Personne> DATASOURCE = new HashMap<>();

    static{
        DATASOURCE.put(1l, Personne.newPersonne("Mouse", "Mickey", "DisneyLand", "Paris", LocalDate.of(1920, 1, 1)));
        DATASOURCE.put(2l, Personne.newPersonne("Picsou", "Balthasar", "DisneyLand", "Paris", LocalDate.of(1931, 2, 12)));
    }

    public static Long addPersonne(Personne personne){
        Long nextId = DATASOURCE.keySet().stream().max(Comparator.comparing(Long::intValue)).get() + 1;
        DATASOURCE.put(nextId, personne);
        return nextId;

    }
}
