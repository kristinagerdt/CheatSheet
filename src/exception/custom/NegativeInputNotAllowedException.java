package exception.custom;

public class NegativeInputNotAllowedException extends Exception {
    private int negativeIntIndex;

    public NegativeInputNotAllowedException(String message, int index) {
        super(message);
        negativeIntIndex = index;
    }

    public int getNegativeIntIndex() {
        return negativeIntIndex;
    }
}