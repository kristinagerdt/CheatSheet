package pattern.singleton;

// Lazily Initialized Double-Checked Locking Singleton
public class Boss2Checked {
    private static String name;
    // this is necessary to prevent compilers from doing their own optimizations and handle the singleton correctly
    private static volatile Boss2Checked INSTANCE;

    // private constructor to prevent others from instantiating this class
    private Boss2Checked() {
        name = "Alex Smith";
    }

    // lazily initialize the singleton in a synchronized block
    public static Boss2Checked getInstance() {
        if (INSTANCE == null) {
            synchronized (Boss2Checked.class) {
                // double-check
                if (INSTANCE == null)
                    INSTANCE = new Boss2Checked();
            }
        }
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
        Boss2Checked boss = Boss2Checked.getInstance();
        System.out.println(boss);
        Boss2Checked newBoss = new Boss2Checked();
        System.out.println(newBoss);
    }
}