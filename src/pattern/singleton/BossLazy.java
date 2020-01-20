package pattern.singleton;

// Lazily Initialized Singleton
public class BossLazy {
    private static String name;
    private static BossLazy INSTANCE;

    // private constructor to prevent others from instantiating this class
    private BossLazy() {
        name = "Alex Smith";
    }

    // lazily create the instance when it is accessed for the first time
    public static synchronized BossLazy getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BossLazy();
        return INSTANCE;
    }

    public static String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Boss{name=" + name + '}';
    }

    public static void main(String[] args) {
        BossLazy boss = BossLazy.getInstance();
        System.out.println(boss);
        BossLazy newBoss = new BossLazy();
        System.out.println(newBoss);
    }
}