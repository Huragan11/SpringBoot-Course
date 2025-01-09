package huragan11.springcoredemo.rest;

import huragan11.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach coach,
            @Qualifier("cricketCoach") Coach anotherCoach
            ){
        System.out.println("DemoController Constructor" + getClass().getSimpleName());
        myCoach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return ("is first coach the same as another coach: " + (myCoach == anotherCoach));
    }


}



