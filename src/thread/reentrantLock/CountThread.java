package thread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {
    private Resource resource;
    private ReentrantLock locker;

    public CountThread(Resource resource, ReentrantLock locker) {
        this.resource = resource;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock(); // set the lock
        try {
            resource.setX(1);
            for (int i = 1; i < 5; i++) {
                int x = resource.getX();
                System.out.println(Thread.currentThread().getName() + " " + x);
                resource.setX(++x);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock(); // unlock
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            Thread thread = new Thread(new CountThread(resource, locker));
            thread.setName("Thread " + i);
            thread.start();
        }

        // lock(): waits until a lock is received
        // lockInterruptibly() throws InterruptedException: waits until a lock is received if the thread isn't interrupted
        // tryLock(): tries to get a lock; if a lock is received, it returns true
        // If the lock is not received, then returns false
        // Unlike the lock() method, it does not expect to receive a lock if it is not available
        // unlock(): unlocks
        // Condition newCondition(): returns a Condition object that is associated with the current lock
    }
}

class Resource {
    private int x = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}