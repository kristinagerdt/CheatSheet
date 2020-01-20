package pattern.singleton;

// Lazily Initialized Singleton (without synchronized)
public class BossLazyUnsafe {
    private static String name;
    private static BossLazyUnsafe INSTANCE;

    // private constructor to prevent others from instantiating this class
    private BossLazyUnsafe() {
        name = "Alex Smith";
    }

    // lazy initialisation - an object is created only when it is needed
    // problem with if - no multithreading protection, with synchronized - the problem is solved
    public static BossLazyUnsafe getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BossLazyUnsafe();
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
        BossLazyUnsafe boss = BossLazyUnsafe.getInstance();
        System.out.println(boss);
        BossLazyUnsafe newBoss = new BossLazyUnsafe();
        System.out.println(newBoss);
    }
}