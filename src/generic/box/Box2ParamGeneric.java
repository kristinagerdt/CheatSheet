package generic.box;

//T, R - any type
//E - element of collection
//N - numbers
//K - key, V - value

// extends - <N extends Number> N: Number and << (Integer, Double, Float)
// super - <T super Integer> T: Integer and >> (Number, Object)

public class Box2ParamGeneric<T, R> {
    private T value1;
    private R value2;

    public String getValue1() {
        return value1.toString();
    }

    public R getValue2() {
        return value2;
    }

    public void setValue(T value1, R value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public static void main(String[] args) {
        Box2ParamGeneric<String, Integer> box = new Box2ParamGeneric<>();
        box.setValue("Hello!", 3);
        String value1 = box.getValue1();
        Integer value2 = box.getValue2();
        System.out.println("value1=" + value1 + " value2=" + value2);
    }
}