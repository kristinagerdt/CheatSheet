package thread;

public class Demo {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("Name of current thread: " + mainThread.getName());
        mainThread.setName("newThread");
        System.out.println("New name of current thread: " + mainThread.getName());
        System.out.println("Summary: " + mainThread);
        // Thread[NewThread,5,main] - Name, Priority and its group Name
        System.out.println("isAlive? " + mainThread.isAlive());
        System.out.println("isInterrupted? " + mainThread.isInterrupted());

        // join(): awaits thread completion, join to Main thread
        // run(): defines the entry point to the thread
        // sleep(): pauses the thread for the specified number of milliseconds
        // start(): starts a thread by calling its run() method

        // getName (): returns the name of the thread
        // setName (String name): sets the name of the thread
        // getPriority (): returns thread priority
        // setPriority (int priority): sets the priority of the thread
        // Priority is one of the key factors for a system to select a thread from the heap of threads to execute
        // In this method, a numerical value of priority is passed as a parameter - from 1 to 10
        // By default, the main thread is set to medium priority - 5
        // isAlive (): returns true if the thread is active
        // isInterrupted (): returns true if the thread was interrupted
    }
}