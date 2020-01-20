package pattern.singleton;

// Eagerly Initialized Singleton
public class BossEager {
    private static String name;
    // create an instance of the class at the time of class loading
    private static final BossEager INSTANCE = new BossEager();

    // private constructor to prevent others from instantiating this class
    private BossEager() {
        name = "Alex Smith";
    }

    // provide a global point of access to the instance
    public static BossEager getInstance() {
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
        BossEager boss = BossEager.getInstance();
        System.out.println(boss);
        BossEager newBoss = new BossEager();
        System.out.println(newBoss);
    }
}