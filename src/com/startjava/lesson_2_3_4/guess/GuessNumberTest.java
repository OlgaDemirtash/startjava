package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    final static String YES = "yes";
    final static String NO = "no";
    final static int MAX_ATTEMPTS = 10;
    final static int MAX_PLAYERS = 2;
    final static int MIN = 1;
    final static int MAX = 100;
    static Player[] players;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer = YES;
        do {
            if (answer.trim().equals(YES)) {
                System.out.println("Угадай число:");
                System.out.printf("У каждого игрока по %d попыток\n", MAX_ATTEMPTS);
                createPlayers();
                GuessNumber game = new GuessNumber(players, MAX_ATTEMPTS, MIN, MAX);
                game.play();
            }
            System.out.println("Хотите продолжить игру? [yes/no]:");
            answer = console.nextLine();
        } while (!answer.trim().equals(NO));
    }

    private static void createPlayers() {
        Scanner console = new Scanner(System.in);
        if (players == null) {
            players = new Player[MAX_PLAYERS];
            for (int i = 0; i < MAX_PLAYERS; i++) {
                System.out.printf("Введите имя игрока %d:\n", (i + 1));
                players[i] = new Player(console.nextLine(), MAX_ATTEMPTS);
            }
        }
    }
}