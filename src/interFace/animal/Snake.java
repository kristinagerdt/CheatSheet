package interFace.animal;

public class Snake implements Voice, Move {
    @Override
    public void move() {
        System.out.println("Crawl");
    }

    @Override
    public void say() {
        System.out.println("Shhhhhhhhh!");
    }
}