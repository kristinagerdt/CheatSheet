package pattern.adapter;

// first Adapter
public class Adapter extends Printer implements PrintInterface {
    @Override
    public void consolePrint() {
        this.print();
    }
}