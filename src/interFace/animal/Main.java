package interFace.animal;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.say();
        cat.move();

        Snake snake = new Snake();
        snake.say();
        snake.move();
    }
}