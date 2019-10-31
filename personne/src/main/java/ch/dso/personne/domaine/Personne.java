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
    private String nss;
    private String localite;
    private LocalDate dateNaissance;

    private Personne(String nom, String prenom, String adresse, String nss, String localite,  LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.localite = localite;
        this.dateNaissance = dateNaissance;
        this.nss = nss;
    }

    public static Personne newPersonne(String nom, String prenom, String adresse, String nss,String localite, LocalDate dateNaissance){
        Personne p = new Personne(nom, prenom, adresse, nss, localite, dateNaissance);
        return p;
    }
}
