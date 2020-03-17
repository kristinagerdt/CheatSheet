package serialization.serializable;

import java.io.Serializable;

public class Home implements Serializable {
    private String address;

    public Home(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

//    @Override
//    public String toString() {
//        return "Home{address=" + address + '}';
//    }
}