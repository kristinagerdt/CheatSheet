package thread.waitNotify;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();

        // it is possible to use only inside a synchronized block
        // wait(): frees up the monitor and puts the calling thread into a wait state
        // until another thread calls the notify() method
        // notify(): continues the work of the thread that previously had the wait() method called
        // notifyAll(): resumes all threads for which the wait() method was previously called
    }
}