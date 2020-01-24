package thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int product = 0;
    private ReentrantLock locker;
    private Condition condition;

    public Store() {
        locker = new ReentrantLock(); // create the lock
        condition = locker.newCondition(); // get the condition associated with the lock
    }

    public void get() {
        locker.lock(); // 1
        try {
            while (product < 1)
                condition.await(); // 2
            product--;
            System.out.println("Consumer bought 1 item");
            System.out.println("There are items in Store: " + product);

            condition.signalAll(); // 3
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        } finally {
            locker.unlock(); // 4
        }
    }

    public void put() {
        locker.lock(); // 1
        try {
            while (product >= 3)
                condition.await(); // 2
            product++;
            System.out.println("Producer adds 1 item");
            System.out.println("There are items in Store: " + product);
            condition.signalAll(); // 3
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        } finally {
            locker.unlock(); // 4
        }
    }
}