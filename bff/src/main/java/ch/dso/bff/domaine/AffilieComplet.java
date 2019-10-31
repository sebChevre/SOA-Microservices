package ch.dso.bff.domaine;

import ch.dso.bff.infrastructure.affilie.Affilie;
import ch.dso.bff.infrastructure.personne.Personne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class AffilieComplet {

    private String affilieA;
    private String noAffilie;
    private String nss;
    private LocalDate affilieDepuis;
    private String nom;
    private String prenom;
    private String adresse;
    private String localite;
    private LocalDate dateNaissance;

    public AffilieComplet(String noAffilie,String affilieA, LocalDate affilieDepuis, String nom, String prenom, String adresse, String nss,String localite, LocalDate dateNaissance) {
        this.noAffilie = noAffilie;
        this.affilieA = affilieA;
        this.affilieDepuis = affilieDepuis;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.nss = nss;
        this.localite = localite;
        this.dateNaissance = dateNaissance;
    }

    public AffilieComplet(Affilie affilie, Personne personne){
        this(affilie.getNoAffilie(),affilie.getAffilieA(), affilie.getAffilieDepuis(), personne.getNom(), personne.getPrenom(), personne.getAdresse(), personne.getNss(), personne.getLocalite(), personne.getDateNaissance());
    }
}
