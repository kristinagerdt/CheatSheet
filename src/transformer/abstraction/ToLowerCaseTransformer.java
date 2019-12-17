package transformer.abstraction;

public class ToLowerCaseTransformer extends AbstractTransformer {
    @Override
    public boolean checkLength(String str) {
        return str.length() == 4;
    }

    @Override
    public String transformString(String str) {
        return str.toLowerCase();
    }
}