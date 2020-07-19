package liftTest;

import lift.Building;
import lift.Lift;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LiftTest {

     Building building;
     Lift lift;

    @Before
    public void setUp(){

        building = new Building();
        lift = new Lift(building.getBuilding());
    }

    @Test
    public void resultTest(){
         lift.liftStart();

         assertTrue("В лифте остались люди",lift.getNumberOfPeople()==0);
    }
}
