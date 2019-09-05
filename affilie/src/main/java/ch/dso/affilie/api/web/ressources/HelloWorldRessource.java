package ch.dso.affilie.api.web.ressources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class HelloWorldRessource {
    private String hello;
    private int port;
}
