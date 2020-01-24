package thread.semaphore;

import java.util.concurrent.Semaphore;

// java.util.concurrent
// acquire() getting permission from the semaphore
// release() resource release

class CountThread implements Runnable {
    private Resource resource;
    private Semaphore semaphore;
    private String name;

    public CountThread(Resource resource, Semaphore semaphore, String name) {
        this.resource = resource;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is awaiting permission");
            // to get permission from the semaphore, you need to call the acquire() method
            semaphore.acquire();
            resource.setX(1);
            for (int i = 1; i < 5; i++) {
                int x = resource.getX();
                System.out.println(this.name + ": " + x);
                resource.setX(++x);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " frees permission");
        // after you finish working with the resource,
        // the previously obtained permission must be released using the release() method
        semaphore.release();
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1); // 1 permission
        Resource resource = new Resource();
        new Thread(new CountThread(resource, semaphore, "CountThread 1")).start();
        new Thread(new CountThread(resource, semaphore, "CountThread 2")).start();
        new Thread(new CountThread(resource, semaphore, "CountThread 3")).start();
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