package ch.dso.affilie.api.web.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class ScheduleResponse {

    private String status = "ok";
    private LocalDateTime startTime;

    public ScheduleResponse(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
