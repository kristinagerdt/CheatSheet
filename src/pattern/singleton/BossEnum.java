package pattern.singleton;

public enum BossEnum {
    INSTANCE("Alex Smith");
    private String name;

    private BossEnum(String name) {
        this.name = name;
    }

    public BossEnum getInstance() {
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        BossEnum boss = BossEnum.INSTANCE.getInstance();
        System.out.println(boss.getName());

        BossEnum newBoss = BossEnum.INSTANCE.getInstance();
        newBoss.setName("New Alex Smith");

        System.out.println(boss.getName());
        System.out.println(newBoss.getName());
    }
}