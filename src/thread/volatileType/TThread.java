package thread.volatileType;

import java.util.Scanner;

public class TThread extends Thread {
    // access to real memory, not to a copy in the cache
    // not atomic operation
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Running!");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        running = false;
    }

    public static void main(String[] args) {
        TThread tThread = new TThread();
        tThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        tThread.shutDown();
    }
}