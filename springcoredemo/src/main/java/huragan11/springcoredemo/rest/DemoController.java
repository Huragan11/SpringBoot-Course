package huragan11.springcoredemo.rest;

import huragan11.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getWorkout() {
        return myCoach.getDailyWorkout();
    }


}



