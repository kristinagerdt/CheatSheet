package thread.waitNotify.store;

public class Store {
    private int product = 0;

    public synchronized void get() { // 1
        while (product < 1) {
            try {
                wait(); // 2
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
        product--;
        System.out.println("Consumer bought 1 item");
        System.out.println("There are items in Store: " + product);
        notify(); // 3
    }

    public synchronized void put() { // 1
        while (product >= 3) {
            try {
                wait(); // 2
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
        product++;
        System.out.println("Producer adds 1 item");
        System.out.println("There are items in Store: " + product);
        notify(); // 3
    }
}