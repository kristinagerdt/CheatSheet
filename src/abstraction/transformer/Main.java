package abstraction.transformer;

public class Main {
    public static void main(String[] args) {
        String str = "abCd aad BBEF bef abb Fg";
        System.out.println(str);

        AbstractTransformer transformerUp = new ToUpperCaseTransformer();
        System.out.println(transform(str, transformerUp));

        AbstractTransformer transformerLow = new ToLowerCaseTransformer();
        System.out.println(transform(str, transformerLow));
    }

    private static String transform(String input, AbstractTransformer transformer) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String item : words) {
            if (transformer.checkLength(item)) {
                item = transformer.transformString(item);
            }
            result.append(item).append(" ");
        }
        return result.toString().trim();
    }
}