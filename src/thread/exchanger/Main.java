package thread.exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        // it works only for an even number of threads
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new PutThread(exchanger)).start();
        new Thread(new GetThread(exchanger)).start();
    }
}