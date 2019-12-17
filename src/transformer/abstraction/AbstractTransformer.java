package transformer.abstraction;

public abstract class AbstractTransformer {
    public abstract boolean checkLength(String str);

    public abstract String transformString(String str);
}