package ch.dso.affilie.infrastructure;

import ch.dso.affilie.api.web.command.JobCommand;
import ch.dso.affilie.domaine.Affilie;

import java.time.temporal.TemporalField;
import java.util.*;
import java.util.stream.Collectors;

public class SchedulJobDataSource {

    private static Map<String, JobCommand> SCHEDULEDJOB = new HashMap<>();

    public static void addJob(JobCommand command){
        SCHEDULEDJOB.put(command.getId(),command);
    }


    public static List<JobCommand> getAllScheduledJobs() {
        return SCHEDULEDJOB.values().stream().collect(Collectors.toList());
    }

    public static void removeJob(String id){
        SCHEDULEDJOB.remove(id);
    }
}
