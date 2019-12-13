package functionalInterface.comparator.myNumber_mix;

import java.util.Comparator;

public class DisplayNameComparator implements Comparator<MyNumber> {
    @Override
    public int compare(MyNumber o1, MyNumber o2) {
        return o1.getDisplayName().compareTo(o2.getDisplayName());
    }
}