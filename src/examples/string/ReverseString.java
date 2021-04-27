package examples.string;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(getReversedStringStringBuilder("Hello"));
        System.out.println(getReversedStringReverseOrder("Hello World!"));
        System.out.println(getReversedStringReverseOrderChars("Hello this World!"));
        System.out.println(getReversedStringReplace("Hello this cruel World!"));
    }

    public static String getReversedStringStringBuilder(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String getReversedStringReverseOrder(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(input.charAt(i));
        }
        return output.toString();
    }

    public static String getReversedStringReverseOrderChars(String input) {
        StringBuilder output = new StringBuilder();
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            output.append(chars[i]);
        }
        return output.toString();
    }

    public static String getReversedStringReplace(String input) {
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < input.length() / 2; i++) {
            int length = input.length();
            String first = output.substring(i, i + 1);
            String second = output.substring(length - i - 1, length - i);

            output.replace(i, i + 1, second);
            output.replace((length - i - 1), (length - i), first);
        }
        return output.toString();
    }
}