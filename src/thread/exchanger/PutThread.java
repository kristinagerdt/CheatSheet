package thread.exchanger;

import java.util.concurrent.Exchanger;

public class PutThread implements Runnable {
    private Exchanger<String> exchanger;
    private String message;

    public PutThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        message = "Message from PutThread class";
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.println("PutThread has received: " + message);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}