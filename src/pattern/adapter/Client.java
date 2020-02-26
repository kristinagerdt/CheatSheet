package pattern.adapter;

public class Client {
    public static void main(String[] args) {
        // get method print() from class Printer through class Adapter
        PrintInterface printer = new Adapter();
        printer.consolePrint();

        // get method print() from class Printer through class AdapterComposition
        PrintInterface printInterface = new AdapterComposition(new Printer());
        printInterface.consolePrint();
    }
}