package pattern.state;

public class Door {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void changeState() {
        if (state instanceof Open) {
            setState(new Close());
        } else if (state instanceof Close) {
            setState(new Open());
        }
    }

    public void move() {
        state.openClose();
    }
}