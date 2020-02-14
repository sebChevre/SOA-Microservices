package ch.dso.affilie.scheduler;

import ch.dso.affilie.api.web.command.JobCommand;
import ch.dso.affilie.infrastructure.SchedulJobDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.stream.IntStream;

@Slf4j
@Component
public class SimpleScheduler {

    TaskScheduler scheduler;

    public SimpleScheduler(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void scheduleJob(JobCommand jobCommand){

        SchedulJobDataSource.addJob(jobCommand);

        scheduler.schedule(() -> {

            log.info("************ Starting Job:[{} at {}], wainting to simulate job.....",jobCommand.getId(),jobCommand.getStartTime());
            IntStream.range(1,10).forEach(it->{
                try {
                    Thread.sleep(1000);
                    log.info("Iteration n°:{}, DONE",it);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            log.info("************Job Done");
            SchedulJobDataSource.removeJob(jobCommand.getId());

        }, convertLocalDateTimeToLocaldate(jobCommand.getStartTime()));
    }

    private Date convertLocalDateTimeToLocaldate(LocalDateTime localDateTime){

        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
