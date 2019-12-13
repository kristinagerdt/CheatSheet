package functionalInterface.comparable.myNumber;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyNumber[] myNumbers = {new MyNumber(3, "aaa"),
                new MyNumber(2, "ddd"),
                new MyNumber(5, "bbb"),
                new MyNumber(1, "ccc")};
        System.out.println(Arrays.toString(myNumbers));

        Arrays.sort(myNumbers); //default sorting by Number, overridden method compareTo()
        Arrays
                .stream(myNumbers)
                .forEach(s -> System.out.println(s.getDisplayName() + " " + s.getNumber()));
    }
}