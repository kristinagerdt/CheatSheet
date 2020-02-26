package pattern.state;

public class Open implements State {
    @Override
    public void openClose() {
        System.out.println("The door is open");
    }
}