package ch.dso.affilie.infrastructure;

import ch.dso.affilie.domaine.Affilie;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AffilieDataSource {

    public static Map<Long, Affilie> AFFILIEDATASOURCE = new HashMap<>();

    static {
        AFFILIEDATASOURCE.put(1l, Affilie.newAffilie("1","WaltDisney", LocalDate.of(2001,11,11)));
        AFFILIEDATASOURCE.put(2l, Affilie.newAffilie("2","WaltDisney", LocalDate.of(2012,3,2)));
    }

    public static Long addAffilie(Affilie affilie){
        Long nextId = AFFILIEDATASOURCE.keySet().stream().max(Comparator.comparing(Long::intValue)).get() + 1;
        AFFILIEDATASOURCE.put(nextId, affilie);
        return nextId;

    }
}
