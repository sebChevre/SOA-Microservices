package ch.dso.personne.domaine;

import ch.dso.personne.domaine.exception.NSSExistantException;
import ch.dso.personne.infrastructure.PersonneDataSource;

public class PersonneDomaineService {

    public  Personne newPersonne(Personne personne){

        if(PersonneDataSource.nssPersonneExist(personne.getNss())){
            throw new NSSExistantException("Le NSS [" + personne.getNss() + "] existe déjà.");
        }

        return personne;
    }
}
