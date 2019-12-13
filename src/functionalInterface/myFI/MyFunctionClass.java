package functionalInterface.myFI;

public class MyFunctionClass implements MyFunction {

    @Override
    public String transform(String input) {
        String asterisk = "**********";
        return asterisk + "\n\t" + input + "\n" + asterisk;
    }
}