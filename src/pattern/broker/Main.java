package pattern.broker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Game> broker = new HashMap<>();
        broker.put(1, new Monopoly());
        broker.put(2, new Munchkin());
        broker.put(3, new Mafia());

        System.out.println("Choose a game: 1, 2 or 3");
        Scanner scanner = new Scanner(System.in);
        int game = scanner.nextInt();
        broker.get(game).printName();
    }
}