package functionalInterface.myFI;

public class Main {
    public static void main(String[] args) {
        //long classic way with new Class
        MyFunction myFunction = new MyFunctionClass();
        String result = myFunction.transform("Hi!");
        System.out.println(result);

        //lambda-function
        MyFunction myFunction1 = (s) -> {
            return "{ " + s + " }";
        };
        System.out.println(myFunction1.transform("Hi!"));

        MyFunction myFunction2 = s -> "++++ " + s + " ++++";
        System.out.println(myFunction2.transform("Hi!"));

        MyFunction myFunction3 = String::toUpperCase;
        System.out.println(myFunction3.transform("hi!"));

        //anonymous class
        MyFunction myFunction4 = new MyFunction() {
            @Override
            public String transform(String input) {
                return "---> " + input + " <---";
            }

            public void test() {
                System.out.println("It's possible to write another methods here");
            }
        };
        System.out.println(myFunction4.transform("Hi!"));

        //new method for creating MyFunction
        MyFunction myFunction5 = createMyFunction();
        System.out.println(myFunction5.transform("Hi!"));
    }

    private static MyFunction createMyFunction() {
        return new MyFunction() {
            @Override
            public String transform(String input) {
                return "[ " + input + " ]";
            }
        };
    }
}