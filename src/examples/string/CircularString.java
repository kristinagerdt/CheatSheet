package examples.string;

public class CircularString {
    public static void main(String[] args) {
        String s1 = "aabbaa";
        String s2 = "aaabba";

        System.out.println(isCircular(s1, s2));
    }

    private static boolean isCircular(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            s1 = s1.charAt(s1.length() - 1) + s1.substring(0, s1.length() - 1);
            if (s1.equals(s2)) {
                return true;
            }
        }
        return false;
    }
}