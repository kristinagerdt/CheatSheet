package thread.waitNotify.message;

public class Main {
    public static void main(String[] args) {
        Message message = new Message("Influence");
        Waiter waiter = new Waiter(message);
        new Thread(waiter, "Waiter").start();

        Notifier notifier = new Notifier(message);
        new Thread(notifier, "Notifier").start();
    }
}