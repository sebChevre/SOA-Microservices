package ch.dso.affilie.api.web.command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class JobCommand {

    private LocalDateTime startTime;

    private final String id = UUID.randomUUID().toString();

}
