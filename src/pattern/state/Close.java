package pattern.state;

public class Close implements State {
    @Override
    public void openClose() {
        System.out.println("The door is closed");
    }
}