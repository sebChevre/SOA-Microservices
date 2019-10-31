package ch.dso.bff.infrastructure.affilie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
public class Affilie {

    private String noAffilie;
    private String persRef;
    private String affilieA;
    private LocalDate affilieDepuis;

    private Affilie(String noAffilie, String persRef, String affilieA, LocalDate affilieDepuis) {
        this.persRef = persRef;
        this.affilieA = affilieA;
        this.affilieDepuis = affilieDepuis;
        this.noAffilie = noAffilie;
    }



    public void setPersRef(String persRef) {
        this.persRef = persRef;
    }
}
