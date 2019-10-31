package ch.dso.bff.api.command;

import ch.dso.bff.infrastructure.affilie.Affilie;
import ch.dso.bff.infrastructure.personne.Personne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class CreerAffilieWithPersonneCommand {

    Affilie affilie;
    Personne personne;

}
