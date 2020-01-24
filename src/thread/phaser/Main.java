package thread.phaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // waiting for the completion of phase 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("The phase " + phase + " completed");

        // waiting for the completion of phase 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("The phase " + phase + " completed");

        // waiting for the completion of phase 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("The phase " + phase + " completed");

        phaser.arriveAndDeregister();

        // register(): registers the side that is executing the stage
        // and returns the number of the current phase - usually phase 0
        // arrive(): reports that the party has completed the stage
        // receiveAndAwaitAdvance(): similar to the method arrive(), only this will cause the phaser
        // receiveAndDeregister(): reports the completion of all stages of the party and deregisters it.
        // Phaser completed his work
        // getPhase(): returns the current phase number
    }
}