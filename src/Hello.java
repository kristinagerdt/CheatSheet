import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Hello {
    public static void main(String[] args) throws IOException {
        hello();

        variables();

        conditionalIf(1, 2);
        conditionalIf(2, 1);
        conditionalIf(2, 2);

        conditionalSwitch(1);
        conditionalSwitch(2);
        conditionalSwitch(3);

        loopFor(args);

        loopWhile();

        loopDoWhile();

        consoleRead();

        random();

        array();

        string();

        bitwiseOperations();

        shearOperations();

        ternaryOperator();

        varargs(1, 2, 3);
        varargs(4, 5);
        varargs(6, 7, 8);
    }

    private static void hello() {
        System.out.println("Hello world!");
        Supplier<String> supplier = () -> "Supplier: Hello world!";
        System.out.println(supplier.get());
    }

    private static void variables() {
        int var1;
        int var2;

        var1 = 1024;
        System.out.println("Variable var1=" + var1);
        var2 = var1 / 2;
        System.out.println("Variable var2=" + var2);

        double x = 10.2;
        System.out.println("Variable x=" + x / 2.5);

        long y = 10L;
    }

    private static void conditionalIf(int a, int b) {
        if (a > b) {
            System.out.println("A=" + a + " > B=" + b);
            //!=
        } else if (b > a) {
            System.out.println("B=" + b + " > A=" + a);
        } else {
            System.out.println("A=" + b + " = B=" + b);
            //==
        }
    }

    private static void conditionalSwitch(int a) {
        switch (a) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("It prints in other cases");
        }
    }

    private static void loopFor(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
        }

        System.out.println();

        for (String arg : args) {
            System.out.print(arg);
        }

        Arrays
                .stream(args)
                .forEach(System.out::println);

        int i, j;
        for (i = 0, j = 10; i < j; i++, j--)
            System.out.println("i и j: " + i + " " + j);

        int sum = 0;
        for (int k = 0; k < 5; sum += k++) ;
        System.out.println(sum);
    }

    private static void loopWhile() {
        int sum = 0, k = 0;
        while (k < 5) {
            sum += k++;
        }
        System.out.println(sum);

        char ch = 'a';
        while (ch <= 'z') {
            System.out.print(ch + " ");
            ch++;
        }
    }

    private static void loopDoWhile() {
        int i = 5;
        do {
            i--;
            System.out.print(i + " ");
        } while (i > 0);
    }

    private static void consoleRead() throws IOException {
        System.out.println("Input String and Number");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int num = input.nextInt();

        System.out.println(str + " " + num);

        //char choice = (char) System.in.read();
        //it needs to add throws IOException to signature
    }

    private static void random() {
        //(int)(Math.random() * ((max - min) + 1)) + min
        int size;
        size = (int) (Math.random() * 4) + 2; // 2-5
        System.out.println("Size " + size);
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 10) + 1; // 1-10
        }
        Arrays
                .stream(numbers)
                .forEach(s -> System.out.print(s + " "));

        Random random = new Random();
        int randomNumber = random.nextInt(10); //0-9
        System.out.println("randomNumber " + randomNumber);
    }

    private static void array() {
        int[] arr0;
        arr0 = new int[3];
        int[] arr1 = new int[5];
        int[] arr2 = {1, 2, 3};
        int[] arr3 = new int[]{1, 2, 3};

        int[][] arr4 = new int[2][3]; // 2 strings 3 rows
        int[][] table = new int[3][];
        table[0] = new int[]{2, 3};
        table[1] = new int[]{1, 2, 3};
        table[2] = new int[]{4, 5};

        for (int[] a : table) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();

        Arrays
                .stream(table)
                .flatMapToInt(p -> Arrays.stream(p))
                .forEach(System.out::println);

        //! normal print 2d array, two dimensional array
        System.out.println(Arrays.deepToString(table));
    }

    private static void string() {
        String str1 = "Hello world!";
        String str2 = "Hello this cruel world";

        System.out.println("equals " + str1.equals(str2));
        System.out.println("length " + str1.length());
        System.out.println("charAt " + str1.charAt(2));
        //-1 str1<str2, 0 str1=str2, 1 str1>str2
        System.out.println("compareTo " + str1.compareTo(str2)); //!
        System.out.println("indexOf " + str1.indexOf("H"));
        System.out.println("lastIndexOf " + str2.lastIndexOf('l'));
        System.out.println("subString " + str2.substring(6, 10));

        //StringBuffer with guarantee of synchronization
        //StringBuilder no guarantee of synchronization
        StringBuilder sb = new StringBuilder();
        sb.append("Hello! StringBuilder");
        System.out.println(sb);

        String a = "examples.string a";
        String b = new String("examples.string a");
        String c = b.intern();

        System.out.println(a == b); //false
        System.out.println(b == c); //false
        System.out.println(a == c); //true
    }

    // | & ^
    private static void bitwiseOperations() {
        char ch;
        for (int i = 0; i < 10; i++) {
            ch = (char) ('a' + i);
            System.out.print(ch);

            ch = (char) ((int) ch & 65503); //1111111111011111
            System.out.print(ch + " ");
        }
    }

    // << >> >>>
    private static void shearOperations() {
        int val = 1;
        for (int i = 0; i < 8; i++) {
            for (int t = 128; t > 0; t = t / 2) {
                if ((val & t) != 0) System.out.print("l ");
                else System.out.print("0 ");
            }
            System.out.println();
            val = val << 1;
        }
        System.out.println();
    }

    private static void ternaryOperator() {
        int a = 2;
        int b = 4;
        String result;
        result = a > b ? "a>b" : "a<b";
        System.out.println(result);
    }

    private static void varargs(int... v) {
        int sum = 0;
        for (int n : v) {
            sum += n;
        }
        System.out.println("Sum=" + sum);
    }
}