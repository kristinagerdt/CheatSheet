package generic;

//T - any type
//E - element of collection
//N - numbers
//K - key, V - value

// extends - <N extends Number> N: Integer, Double, Float
// super - <T super Integer> T: Number, Object

public class NumberBox<N extends Number> {
    private N[] numbers;

    public NumberBox(N[] numbers) {
        this.numbers = numbers;
    }

    public double average() {
        double sum = 0.0;
        for (N item : numbers) {
            sum += item.doubleValue();
        }
        return Math.round(sum / numbers.length * 100.00) / 100.00;
    }

    // NumberBox<N>, compare Integer-Integer, Double-Double
    // NumberBox<?>, compare Integer-Double, Double-Float
    public boolean compare(NumberBox<?> anotherBox) {
        return Math.abs(average() - anotherBox.average()) < 0.001f;
    }
}