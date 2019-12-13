package abstraction.plant;

public class Flower extends Plant {

    private static int FLOWER_GROW_PER_SEASON = 10;


    public Flower(String displayName, int height) {
        super(displayName, height);
    }

    @Override
    public int getGrowPerSeason() {
        return FLOWER_GROW_PER_SEASON;
    }

    @Override
    public void doSummer() {
        System.out.println("Summer: +" + 0 + "cm, height=" + getHeight() + "cm");
    }

    @Override
    public void doAutumn() {
        setHeight(0);
        System.out.println("Autumn, height=" + getHeight() + "cm");
    }

    @Override
    public void doWinter() {
        System.out.println("Winter, height=" + getHeight() + "cm");
        setHeight(2);
    }
}