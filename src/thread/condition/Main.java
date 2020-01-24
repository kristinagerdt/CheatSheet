package thread.condition;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();

        // await(): the thread waits until some condition is met and
        // until another thread calls the signal/signalAll methods
        // In many ways similar to the wait method of the Object class

        // signal(): signals that a thread that has previously been called with the await() method can continue
        // The application is similar to using the notify method of the Object class

        // signalAll(): signals all threads that have previously been called with the await() method to continue.
        // Similar to the notifyAll() method of the Object class
    }
}