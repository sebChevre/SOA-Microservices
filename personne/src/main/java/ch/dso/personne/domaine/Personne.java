package ch.dso.personne.domaine;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class Personne {

    private String nom;
    private String prenom;
    private String adresse;
    private String localite;
    private LocalDate dateNaissance;

    private Personne(String nom, String prenom, String adresse, String localite, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.localite = localite;
        this.dateNaissance = dateNaissance;
    }

    public static Personne newPersonne(String nom, String prenom, String adresse, String localite, LocalDate dateNaissance){
        Personne p = new Personne(nom, prenom, adresse, localite, dateNaissance);
        return p;
    }
}
