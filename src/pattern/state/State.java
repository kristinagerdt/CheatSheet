package pattern.state;

// when you need to change the state of an object depending on its current state
public interface State {
    public abstract void openClose();
}