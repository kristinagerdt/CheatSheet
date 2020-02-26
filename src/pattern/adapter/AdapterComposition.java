package pattern.adapter;

// second Adapter with composition
public class AdapterComposition implements PrintInterface {
    private final Printer printer;

    public AdapterComposition(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void consolePrint() {
        printer.print();
    }
}