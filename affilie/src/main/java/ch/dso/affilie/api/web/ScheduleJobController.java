package ch.dso.affilie.api.web;

import ch.dso.affilie.api.web.command.JobCommand;
import ch.dso.affilie.api.web.response.ScheduleResponse;
import ch.dso.affilie.infrastructure.SchedulJobDataSource;
import ch.dso.affilie.scheduler.SimpleScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/job")
@RestController
public class ScheduleJobController {

    @Autowired
    SimpleScheduler simpleScheduler;

    @PostMapping
    public ResponseEntity<ScheduleResponse> submitScheduleJob(@RequestBody JobCommand jobCommand){
        log.info("Job Scheduled submited at : {}", jobCommand.getStartTime().toString());
        simpleScheduler.scheduleJob(jobCommand);
        return ResponseEntity.ok(new ScheduleResponse(jobCommand.getStartTime()));
    }

    @GetMapping
    public ResponseEntity<List<JobCommand>> findSubmittedJobs(){
        return ResponseEntity.ok(SchedulJobDataSource.getAllScheduledJobs());
    }
}
