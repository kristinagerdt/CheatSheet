package transformer.interFace;

public class ToLowerCaseTransformer implements InterfaceTransformer {
    @Override
    public boolean checkLength(String str) {
        return str.length() == 4;
    }

    @Override
    public String transform(String str) {
        return str.toLowerCase();
    }
}