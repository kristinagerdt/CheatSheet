package enumType;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        sizeEnum();
        genderEnum();
    }

    private static void sizeEnum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size: SMALL, MEDIUM, LARGE, EXTRA_LARGE");
        String input = scanner.nextLine().toUpperCase();

        Size size = Enum.valueOf(Size.class, input);
        System.out.println("Size: " + size);
        System.out.println("Abbreviation: " + size.getAbbreviation());

        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job! You paid attention to the _.");
        }

        Size[] values = Size.values();
        System.out.println("All values from enum Size: " + Arrays.toString(values));
    }

    private static void genderEnum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a gender: FEMALE, MALE");
        String input = scanner.nextLine().toUpperCase();

        Gender gender = Enum.valueOf(Gender.class, input);
        System.out.println("Gender: " + gender);

        Gender[] genders = Gender.values();
        System.out.println("All values from enum Gender: " + Arrays.toString(genders));
    }
}