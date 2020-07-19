package lift;

import java.util.ArrayList;
import java.util.List;

public class Lift {

    private int [][]building;
    private List<Integer> inLift = new ArrayList<>();
    private int numberOfPeople = 0;
    private int floor;
    private boolean waiting= true;
    private int stepsCount = 0;
    private int outCount=0;
    private int inCount=0;

    public Lift(int[][] building) {
        this.building = building;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public void liftStart() {

        while (waiting){
            waiting = false;
            liftUp();
            liftDown();
        }
    }
    private void liftUp(){
        for (floor=0; floor < building.length; floor++) {
            outCount = 0;
            inCount = 0;

            goOut();

            for (int j = 0; j < building[floor].length; j++) {

                if (building[floor][j] > floor && numberOfPeople < 5 &&  building[floor][j]!=-1) {
                    inLift.add(building[floor][j]);
                    inCount++;
                    building[floor][j] = -1;
                    numberOfPeople++;
                    waiting = true;
                }
            }
            if(inCount!=0||outCount!=0){
                stepInfo();
            }
        }
    }
    private void liftDown(){
        for (floor = building.length-1; floor >=0; floor--) {
            inCount=0;
            outCount=0;

            goOut();

            for (int j = 0; j < building[floor].length; j++) {

                if (building[floor][j] < floor && numberOfPeople < 5 &&building[floor][j]!=-1) {
                    inLift.add(building[floor][j]);
                    building[floor][j] = -1;
                    numberOfPeople++;
                    inCount++;
                    waiting = true;
                }
            }
            if(inCount!=0||outCount!=0){
                stepInfo();
            }
        }
    }
    private void goOut(){
        for (int x = 0; x < inLift.size(); x++) {
            if (inLift.get(x) == floor) {
                inLift.remove(x);
                outCount++;
                numberOfPeople--;
                waiting = true;
                x--;
            }
        }
    }
    private void stepInfo(){
        System.out.printf("*** Step№%d ***",++stepsCount);
        System.out.println();
        System.out.printf("Floor№ %d\n",floor);
        System.out.printf("People quit: %d\n",outCount);
        System.out.printf("People entered: %d\n",inCount);
        System.out.printf("Free places: %d\n",5-numberOfPeople);
        System.out.println();
    }
}
