package abstraction.plant;

public class Tree extends Plant {

    private static int TREE_GROW_PER_SEASON = 2;

    public Tree(String displayName, int height) {
        super(displayName, height);
    }

    @Override
    public int getGrowPerSeason() {
        return TREE_GROW_PER_SEASON;
    }

    @Override
    public void doSummer() {
        setHeight(getHeight() + getGrowPerSeason());
        System.out.println("Summer: +" + getGrowPerSeason() + "cm, height=" + getHeight() + "cm");
    }

    @Override
    public void doAutumn() {
        System.out.println("Autumn: +" + 0 + "cm, height=" + getHeight() + "cm");
    }

    @Override
    public void doWinter() {
        System.out.println("Winter: +" + 0 + "cm, height=" + getHeight() + "cm");
    }
}