package huragan11.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("CricketCoach Constructor " + getClass().getSimpleName());
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("CricketCoach PostConstruct " + getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("CricketCoach PreDestroy " + getClass().getSimpleName());
    }



    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
