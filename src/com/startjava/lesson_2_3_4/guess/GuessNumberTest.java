package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    final static String YES = "yes";
    final static String NO = "no";
    final static int MAX_ATTEMPTS = 10;
    final static int MAX_PLAYERS = 2;
    final static int MIN = 1;
    final static int MAX = 100;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Player[] players = new Player[MAX_PLAYERS];
        System.out.println("Угадай число:");
        for (int i = 0; i < MAX_PLAYERS; i++) {
            System.out.printf("Введите имя игрока %d:\n", (i + 1));
            players[i] = new Player(console.nextLine(), MAX_ATTEMPTS);
        }
        play(players);
    }

    private static void play(Player[] players) {
        GuessNumber game = new GuessNumber(players, MAX_ATTEMPTS, MIN, MAX);
        game.play();
        if (checkAnswer()) {
            play(players);
        }
    }

    private static boolean checkAnswer() {
        String answer;
        Scanner console = new Scanner(System.in);
        System.out.println("Хотите продолжить игру? [yes/no]:");
        answer = console.nextLine();
        if (!answer.trim().equals(YES) && !answer.trim().equals(NO)) {
            checkAnswer();
        }

        return (answer.trim().equals(YES));
    }
}