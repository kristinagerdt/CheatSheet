package thread.semaphore;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private Semaphore semaphore; // semaphore limiting the number of philosophers
    private int num = 0; // number of meals
    int id; // conditional id of the philosopher

    public Philosopher(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (num < 3) // until the number of meals reaches 3
            {
                semaphore.acquire();
                System.out.println("Philosopher " + id + " he sits at the table");
                sleep(500); // philosopher is eating
                num++;
                System.out.println("Philosopher " + id + " leaves the table");
                semaphore.release();
                sleep(500); // philosopher is walking
            }
        } catch (InterruptedException e) {
            System.out.println("Philosopher  " + id + " has health problems");
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        for (int i = 1; i <= 3; i++) {
            new Philosopher(semaphore, i).start();
        }
    }
}