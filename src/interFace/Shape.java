package interFace;

public interface Shape {

    public static final String temp = "";

    public abstract void print();

    public abstract int getSmth();

    public default void  temp(){
        System.out.println("Hello!");
    }
}
