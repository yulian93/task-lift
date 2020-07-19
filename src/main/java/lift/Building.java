package lift;

public class Building {

    private int[][] building;

    public Building() {

        building = buildingGenerator();

    }

    public int[][] getBuilding() {
        return building;
    }

    private int[][] buildingGenerator() {
        int numberOfFloors = getNumberOfFloors();
        int[][] result = new int[numberOfFloors][];

        for (int i = 0; i < result.length; i++) {
            result[i] = new int[getNumberOfPeople()];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = getRandomFloor(i, numberOfFloors);
            }
        }
        return result;
    }

    private int getNumberOfFloors() {

        int min = 5;
        int max = 20;
        max -= min;

        return (int) (Math.random() * ++max) + min;

    }

    private int getNumberOfPeople() {

        int min = 0;
        int max = 10;
        max -= min;

        return (int) (Math.random() * ++max) + min;

    }

    private int getRandomFloor(int floor, int numberOfFloors) {

        int result;
        do {
            result = (int) (Math.random() * numberOfFloors);
        } while (result == floor || result > numberOfFloors);

        return result;
    }
}
