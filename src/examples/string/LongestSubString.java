package examples.string;

public class LongestSubString {
    public static void main(String[] args) {
        String str = "qqwcddddeknn";
        System.out.println(getLengthLongestSubString(str));
    }

    private static int getLengthLongestSubString(String input) {
        int maxLength = 1;
        int temp = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                temp++;
            } else {
                if (temp > maxLength) {
                    maxLength = temp;
                }
                temp = 1;
            }
        }
        return maxLength;
    }

    private static int longestSubString2(String input) {
        Character[] chars = input
                .chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);
        int maxLength = 1;
        int temp = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                temp++;
            } else {
                temp = 1;
            }
            if (temp > maxLength) {
                maxLength = temp;
            }
        }
        return maxLength;
    }
}