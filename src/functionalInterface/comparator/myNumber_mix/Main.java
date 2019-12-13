package functionalInterface.comparator.myNumber_mix;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyNumber[] myNumbers = {new MyNumber(3, "aaa"),
                new MyNumber(2, "ddd"),
                new MyNumber(5, "bbb"),
                new MyNumber(1, "ccc")};

        System.out.println("Before:");
        print(myNumbers);

        Arrays.sort(myNumbers, new DisplayNameComparator());
        System.out.println("\nAfter sort by DisplayName:");
        print(myNumbers);

        DisplayNameComparator displayNameComparator1 = new DisplayNameComparator();
        Arrays.sort(myNumbers, displayNameComparator1);

        //anonymous class
        Comparator<MyNumber> displayNameComparator2 = new Comparator<MyNumber>() {
            @Override
            public int compare(MyNumber o1, MyNumber o2) {
                return o1.getDisplayName().compareTo(o2.getDisplayName());
            }
        };
        Arrays.sort(myNumbers, displayNameComparator2);

        //lambda-function
        Comparator<MyNumber> displayNameComparator3 = (o1, o2) -> {
            String name1 = o1.getDisplayName();
            String name2 = o2.getDisplayName();
            return name1.compareTo(name2);
        };

        Comparator<MyNumber> displayNameComparator4 = (o1, o2) -> o1.getDisplayName().compareTo(o2.getDisplayName());
        Arrays.sort(myNumbers, displayNameComparator4);

        Comparator<MyNumber> displayNameComparator5 = Comparator.comparing(MyNumber::getDisplayName);
        Arrays.sort(myNumbers, displayNameComparator5);
    }

    private static void print(MyNumber[] myNumbers) {
        Arrays
                .stream(myNumbers)
                .forEach(s -> System.out.println(s.getDisplayName() + " " + s.getNumber()));
    }
}