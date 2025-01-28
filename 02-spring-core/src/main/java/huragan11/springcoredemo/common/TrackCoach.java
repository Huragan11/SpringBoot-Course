package huragan11.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    public TrackCoach() {
        System.out.println("TrackCoach Constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a 5k now!";
    }
}
