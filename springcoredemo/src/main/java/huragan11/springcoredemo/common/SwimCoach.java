package huragan11.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("SwimCoach Constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters!";
    }
}
