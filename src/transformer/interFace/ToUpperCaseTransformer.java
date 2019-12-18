package transformer.interFace;

public class ToUpperCaseTransformer implements TransformerInterface {
    @Override
    public boolean checkLength(String str) {
        return str.length() == 3;
    }

    @Override
    public String transform(String str) {
        return str.toUpperCase();
    }
}