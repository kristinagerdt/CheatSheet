package functionalInterface.comparator.myNumber_mix;

public class MyNumber {
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
    public String toString() {
        return "MyNumber{" +
                "number=" + number +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}