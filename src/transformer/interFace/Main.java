package transformer.interFace;

public class Main {
    public static void main(String[] args) {
        String str = "abCd aad BBEF bef abb Fg";
        System.out.println(str);

        TransformerInterface transformerUp = new ToUpperCaseTransformer();
        System.out.println(transform(str, transformerUp));

        TransformerInterface transformerLow = new ToLowerCaseTransformer();
        System.out.println(transform(str, transformerLow));
    }

    private static String transform(String str, TransformerInterface transformer) {
        String[] words = str.split(" ");
        StringBuilder output = new StringBuilder();
        for (String item : words) {
            if (transformer.checkLength(item)) {
                item = transformer.transform(item);
            }
            output.append(item).append(" ");
        }
        return output.toString().trim();
    }
}