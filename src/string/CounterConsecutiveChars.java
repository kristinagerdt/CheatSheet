package string;

public class CounterConsecutiveChars {
    public static void main(String[] args) {
//        String str = "aaaabbaacccb";
        String str = "cccb";
        System.out.println(str);
        String result = counter(str);
        System.out.println(result);
    }

    public static String counter(String input) {
        int count = 1;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                output.append(count).append(input.charAt(i));
                count = 1;
            }
        }
        output.append(count).append(input.charAt(input.length() - 1));
        return output.toString();
    }
}
