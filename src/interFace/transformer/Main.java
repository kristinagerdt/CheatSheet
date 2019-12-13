package interFace.transformer;

public class Main {
    public static void main(String[] args) {
        String str = "abCd aad BBEF bef abb Fg";
        System.out.println(str);

        InterfaceTransformer transformerUp = new ToUpperCaseTransformer();
        System.out.println(transform(str, transformerUp));

        InterfaceTransformer transformerLow = new ToLowerCaseTransformer();
        System.out.println(transform(str, transformerLow));
    }

    private static String transform(String str, InterfaceTransformer transformer) {
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