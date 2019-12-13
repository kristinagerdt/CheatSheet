package functionalInterface.comparable.myNumber;

public class MyNumber implements Comparable<MyNumber> {
    private int number;
    private String displayName;

    public MyNumber(int number, String displayName) {
        this.number = number;
        this.displayName = displayName;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public int compareTo(MyNumber o) {
        if (number > o.getNumber()) {
            return 1;
        } else if (number < o.getNumber()) {
            return -1;
        }
        return 0;
    }

//    @Override
//    public int compareTo(MyNumber o) {
//        return displayName.compareTo(o.getDisplayName());
//    }

    @Override
    public String toString() {
        return "MyNumber{" +
                "number=" + number +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}