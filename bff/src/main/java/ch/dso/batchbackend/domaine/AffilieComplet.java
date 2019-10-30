package ch.dso.batchbackend.domaine;

import ch.dso.batchbackend.infrastructure.affilie.Affilie;
import ch.dso.batchbackend.infrastructure.personne.Personne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class AffilieComplet {

    private String affilieA;
    private LocalDate affilieDepuis;
    private String nom;
    private String prenom;
    private String adresse;
    private String localite;
    private LocalDate dateNaissance;

    public AffilieComplet(String affilieA, LocalDate affilieDepuis, String nom, String prenom, String adresse, String localite, LocalDate dateNaissance) {
        this.affilieA = affilieA;
        this.affilieDepuis = affilieDepuis;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.localite = localite;
        this.dateNaissance = dateNaissance;
    }

    public AffilieComplet(Affilie affilie, Personne personne){
        this(affilie.getAffilieA(), affilie.getAffilieDepuis(), personne.getNom(), personne.getPrenom(), personne.getAdresse(), personne.getLocalite(), personne.getDateNaissance());
    }
}
