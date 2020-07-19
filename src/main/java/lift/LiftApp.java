package lift;

public class LiftApp {
    public static void main(String[] args) {

     Building building = new Building();

     Lift lift = new Lift(building.getBuilding());

     lift.liftStart();
    }
}
