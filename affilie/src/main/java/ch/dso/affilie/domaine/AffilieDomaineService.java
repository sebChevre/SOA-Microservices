package ch.dso.affilie.domaine;

import ch.dso.affilie.infrastructure.AffilieDataSource;

import java.time.LocalDate;
import java.util.Random;

public class AffilieDomaineService {

    public  Affilie newAffilie(Affilie affilie){

        String noAffilie = "10000";
        while(AffilieDataSource.numeroAffilieExist(noAffilie)){
            noAffilie = generateNumeroAffilie();
        }

        affilie.setNoAffilie(noAffilie);

        return affilie;
    }


    private String generateNumeroAffilie(){

        int min = 10000;
        int max = 99999;

        Random r = new Random();
        return String.valueOf(r.nextInt((max - min) + 1) + min);
    }
}
