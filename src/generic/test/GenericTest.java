package generic.test;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenericTest {
    private List<Integer> intList = new LinkedList<>();
    private List<Double> doubleList = new LinkedList<>();
    private Integer[] intArray;
    private Double[] doubleArray;
    private String[] stringArray;

    @Before
    public void setInputData() {
        intList = Arrays.asList(3, 4, 7, 14);
        doubleList = Arrays.asList(3.1, 4.2, 7.5, 14.0);
        intArray = new Integer[]{3, 5, 8, 0, 10, 11};
        doubleArray = new Double[]{3.1, 5.4, 8.7, 0.2, 10.4, 11.3};
        stringArray = new String[]{"bb", "ff", "cc", "pp", "dd"};
    }

    @Test
    public void testIntegerSumOfList() {
        Double extend = 28.0;
        Double actual = Generic.sumOfList(intList);
        assertEquals(extend, actual);
    }

    @Test
    public void testDoubleSumOfList() {
        Double extend = 28.8;
        Double actual = Generic.sumOfList(doubleList);
        assertEquals(extend, actual);
    }

    @Test
    public void testEmptySumOfList() {
        Double extend = 0.0;
        Double actual = Generic.sumOfList(new LinkedList<>());
        assertEquals(extend, actual);
    }

    @Test
    public void testNullSumOfList() {
        Double extend = 0.0;
        Double actual = Generic.sumOfList(null);
        assertEquals(extend, actual);
    }

    @Test
    public void testIntegerCountGreaterThan() {
        long extend = 3;
        long actual = Generic.countGreaterThan(intArray, 5);
        assertEquals(extend, actual);
    }

    @Test
    public void testDoubleCountGreaterThan() {
        long extend = 4;
        long actual = Generic.countGreaterThan(doubleArray, 5.2);
        assertEquals(extend, actual);
    }

    @Test
    public void testStringCountGreaterThan() {
        long extend = 3;
        long actual = Generic.countGreaterThan(stringArray, "cc");
        assertEquals(extend, actual);
    }

    @Test
    public void testEmptyCountGreaterThan() {
        long extend = 0;
        long actual = Generic.countGreaterThan(new Integer[]{}, 0);
        assertEquals(extend, actual);
    }
}