package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    private final static String YES = "yes";
    private final static String NO = "no";
    private final static int MAX_ATTEMPTS = 10;
    private final static int MAX_PLAYERS = 2;
    private final static int MIN = 1;
    private final static int MAX = 100;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer = YES;
        Player[] players = null;
        GuessNumber game = null;
        do {
            if (answer.trim().equals(YES)) {
                System.out.println("Угадай число:");
                System.out.printf("У каждого игрока по %d попыток\n", MAX_ATTEMPTS);
                if (players == null) {
                    players = createPlayers();
                    game = new GuessNumber(players, MAX_ATTEMPTS, MIN, MAX);
                }
                game.play();
            }
            System.out.println("Хотите продолжить игру? [yes/no]:");
            answer = console.nextLine();
        } while (!answer.trim().equals(NO));
    }

    private static Player[] createPlayers() {
        Scanner console = new Scanner(System.in);
        Player[] players = new Player[MAX_PLAYERS];
        for (int i = 0; i < MAX_PLAYERS; i++) {
            System.out.printf("Введите имя игрока %d:\n", (i + 1));
            players[i] = new Player(console.nextLine(), MAX_ATTEMPTS);
        }
        return players;
    }
}