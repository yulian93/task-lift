package liftTest;

import lift.Building;
import org.junit.Before;
import org.junit.Test;

import static  org.junit.Assert.*;

public class BuildingTest {

    Building building;
    int [][] result;

    @Before
    public void setUp(){

        building = new Building();
        result = building.getBuilding();
    }
    @Test
     public void testBuilding(){

     assertTrue("Количество этажей за пределами допустимого диапазона",(result.length<=20 && result.length>=5));

    }

    @Test
    public void testNumberOfPeople(){
        for (int i = 0; i <result.length ; i++) {
            assertTrue("Количество людей на этаже больше допустимого максимума",result[i].length<=10);
        }
    }
}
