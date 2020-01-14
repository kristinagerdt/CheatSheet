package generic.box;

public class BoxObject {
    private Object value;

    public BoxObject(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Printer{value=" + value + '}';
    }

    public static void main(String[] args) {
        BoxObject printer = new BoxObject(10);
        Object value = printer.getValue();
        if (value instanceof Integer) {
            System.out.println(value);
        }
    }
}