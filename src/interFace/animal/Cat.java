package interFace.animal;

public class Cat implements Voice, Move {
    @Override
    public void move() {
        System.out.println("Jump, Walking, Run");
    }

    @Override
    public void say() {
        System.out.println("May!");
    }
}