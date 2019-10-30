package ch.dso.batchbackend.infrastructure.affilie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
public class Affilie {

    private String persRef;
    private String affilieA;
    private LocalDate affilieDepuis;

    private Affilie(String persRef, String affilieA, LocalDate affilieDepuis) {
        this.persRef = persRef;
        this.affilieA = affilieA;
        this.affilieDepuis = affilieDepuis;
    }

    public static Affilie newAffilie(String persRef, String affilieA, LocalDate affilieDepuis){
        Affilie a = new Affilie(persRef,affilieA,affilieDepuis);
        return a;
    }
}
