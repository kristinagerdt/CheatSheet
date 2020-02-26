package pattern.state;

public class Main {
    public static void main(String[] args) {
        State open = new Open();
        Door door = new Door();
        door.setState(open);

        for (int i = 0; i < 6; i++) {
            door.move();
            door.changeState();
        }
    }
}