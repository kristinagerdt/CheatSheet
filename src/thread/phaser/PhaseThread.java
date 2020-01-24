package thread.phaser;

import java.util.concurrent.Phaser;

class PhaseThread implements Runnable {
    private Phaser phaser;
    private String name;

    public PhaseThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        this.phaser.register();
    }

    @Override
    public void run() {
        System.out.println(name + " is performing the phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // inform that the first phase has been reached
        try{
            Thread.sleep(200);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(name + " is performing the phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // inform that the second phase has been reached
        try{
            Thread.sleep(200);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(name + " is performing the phase " + phaser.getPhase());
        phaser.arriveAndDeregister(); // inform about the completion of phases and delete objects from registration
    }
}