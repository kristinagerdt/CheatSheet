package pattern.factoryMethod;

// the user class does not need to know which implementation of the interface it creates,
// this is determined by the state of other objects or by input
public abstract class Factory {
    private int flag;

    public int getFlag() {
        return flag;
    }

    public Factory(int flag) {
        this.flag = flag;
    }

    public abstract Chocolate create();
}