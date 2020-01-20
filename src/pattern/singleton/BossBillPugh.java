package pattern.singleton;

// Lazily Initialized Inner Class Singleton (Bill Pugh singleton)
public class BossBillPugh {
    private static String name;

    // private constructor to prevent others from instantiating this class
    private BossBillPugh() {
        name = "Alex Smith";
    }

    // this inner class is loaded only after getInstance() is called for the first time
    private static class Helper {
        private static final BossBillPugh INSTANCE = new BossBillPugh();
    }

    public static BossBillPugh getInstance() {
        return Helper.INSTANCE;
    }

    public static String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Boss{name=" + name + '}';
    }

    public static void main(String[] args) {
        BossBillPugh boss = BossBillPugh.getInstance();
        System.out.println(boss);
        BossBillPugh newBoss = new BossBillPugh();
        System.out.println(newBoss);
    }
}