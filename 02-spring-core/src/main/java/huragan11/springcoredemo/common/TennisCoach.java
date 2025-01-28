package huragan11.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("TennisCoach Constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley for 45 minutes";
    }
}
