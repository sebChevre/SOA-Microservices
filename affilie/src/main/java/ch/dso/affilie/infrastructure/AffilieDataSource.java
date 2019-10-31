package ch.dso.affilie.infrastructure;

import ch.dso.affilie.domaine.Affilie;
import ch.dso.affilie.domaine.AffilieDomaineService;
import ch.dso.affilie.domaine.NoAffilieNotExistException;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AffilieDataSource {

    public static Map<Long, Affilie> AFFILIEDATASOURCE = new HashMap<>();

    static {

        AffilieDomaineService service = new AffilieDomaineService();

        AFFILIEDATASOURCE.put(1l, service.newAffilie(
                Affilie.newAffilie("756.1234.5678.90","WaltDisney", LocalDate.of(2001,11,11)))
        );
        AFFILIEDATASOURCE.put(2l, service.newAffilie(
                Affilie.newAffilie("756.1235.8765.01","WaltDisney", LocalDate.of(2012,3,2)))
        );
    }

    public static Optional<Affilie> getByNoAffilie(String noAffilie){
        return AFFILIEDATASOURCE.values().stream().filter(affilie -> {
            return affilie.getNoAffilie().equals(noAffilie);
        }).findFirst();
    }

    public static Long addAffilie(Affilie affilie){
        Long nextId = AFFILIEDATASOURCE.keySet().stream().max(Comparator.comparing(Long::intValue)).get() + 1;
        AFFILIEDATASOURCE.put(nextId, affilie);
        return nextId;
    }

    public static boolean numeroAffilieExist(String noAffilie){
        Optional<Affilie> affilieWithSameNoAffilie = AFFILIEDATASOURCE.values().stream().filter(affilie -> {
            return affilie.getNoAffilie().equals(noAffilie);
        }).findFirst();

        return affilieWithSameNoAffilie.isPresent();
    }
}
