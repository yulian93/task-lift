package liftTest;

import lift.Lift;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class StepsCountTest {

     Lift lift;
     int [][] building1 = {{2,2,2,2,2},{5,4,5,5},{1,0,1,2},{},{0,0,0,0,0},{4,3,2,1}};


    @Before
    public void setBuilding1(){
        lift = new Lift(building1);
    }

    @Test
    public void testSteps1(){
        lift.liftStart();

        assertEquals("Не верное количество шагов",15,lift.getStepsCount());
    }



}
