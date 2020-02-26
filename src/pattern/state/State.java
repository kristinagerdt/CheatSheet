package pattern.state;

public interface State {
    public abstract void openClose();
}

// When you need to change the state of an object depending on its current state