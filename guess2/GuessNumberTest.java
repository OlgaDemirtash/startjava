package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    final static String YES = "yes";
    final static String NO = "no"
    final static int MAX_ATTEMPTS = 10;
    final static int MAX_PLAYERS = 3;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Player[] players = new Player[MAX_PLAYERS];
        System.out.println("Угадай число:");
        for (int i = 0; i < MAX_PLAYERS; i++) {
            System.out.println("Введите имя игрока " + i + 1 + ": ");
            players[i] = new Player(console.nextLine(), MAX_ATTEMPTS);
        }

        String answer;
        GuessNumber game = new GuessNumber(players, MAX_ATTEMPTS);
        do {
            game.play();
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                answer = console.nextLine();
            } while (!answer.trim().equals(YES) && !answer.trim().equals(NO));
        } while (!answer.trim().equals(NO));
    }
}