package transformer.abstraction;

public class ToUpperCaseTransformer extends TransformerAbstract {
    @Override
    public boolean checkLength(String str) {
        return str.length() == 3;
    }

    @Override
    public String transformString(String str) {
        return str.toUpperCase();
    }
}