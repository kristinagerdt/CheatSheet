package abstraction.plant;

public class Main {
    public static void main(String[] args) {
        Plant flower = new Flower("Tulip", 2);
        Plant birch = new Tree("Birch", 15);

        printYears(flower);
        printYears(birch);
    }

    private static void printYears(Plant plant) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Year " + (i + 1));
            System.out.println(plant.getDisplayName() + " height " + plant.getHeight() + "cm");
            plant.doSpring();
            plant.doSummer();
            plant.doAutumn();
            plant.doWinter();
            System.out.println("------------------");
        }
    }
}