package thread.startThread;

public class ThreadClass extends Thread {
    public ThreadClass(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("method run(), " + getName());
    }

    public static void main(String[] args) {
        ThreadClass[] threads = new ThreadClass[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadClass("ThreadClass " + i);
            threads[i].start();
        }
    }
}