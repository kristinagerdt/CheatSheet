package generic;

//T - any type
//E - element of collection
//N - numbers
//K - key, V - value

// extends - <N extends Number> N: Integer, Double, Float
// super - <T super Integer> T: Number, Object

public class Box<T> {
    private T object;

    public Box(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Box{" +
                "object=" + object +
                '}';
    }
}