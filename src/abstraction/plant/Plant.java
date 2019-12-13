package abstraction.plant;

public abstract class Plant {

    private String displayName;
    private int height;

    public Plant(String displayName, int height) {
        this.displayName = displayName;
        this.height = height;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract int getGrowPerSeason();

    public void doSpring() {
        setHeight(getHeight() + getGrowPerSeason());
        System.out.println("Spring: +" + getGrowPerSeason() + "cm, height=" + getHeight() + "cm");
    }

    public abstract void doSummer();

    public abstract void doAutumn();

    public abstract void doWinter();
}