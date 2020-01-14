package generic.box;

public class Letter {
    private String text;

    public Letter(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Letter{text=" + text + '}';
    }
}