package ch.dso.bff.infrastructure.personne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
public class Personne {

    private String nss;
    private String nom;
    private String prenom;
    private String adresse;
    private String localite;
    private LocalDate dateNaissance;



    private Personne(String nom, String prenom, String adresse, String nss,String localite, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.localite = localite;
        this.dateNaissance = dateNaissance;
        this.nss = nss;
    }


}
