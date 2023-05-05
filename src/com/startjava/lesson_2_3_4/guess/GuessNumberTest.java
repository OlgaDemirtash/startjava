package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    final static String YES = "yes";
    final static String NO = "no";
    final static int MAX_ATTEMPTS = 10;
    final static int MAX_PLAYERS = 2;
    final static int MIN = 1;
    final static int MAX = 100;
    static Player[] players = null;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Угадай число:");
        System.out.printf("У каждого игрога по %d попыток\n", MAX_ATTEMPTS);
        if (players == null) {
            players = new Player[MAX_PLAYERS];
            for (int i = 0; i < MAX_PLAYERS; i++) {
                System.out.printf("Введите имя игрока %d:\n", (i + 1));
                players[i] = new Player(console.nextLine(), MAX_ATTEMPTS);
            }
        } else {
            clearPlayersNumbers(players);
        }

        GuessNumber game = new GuessNumber(players, MAX_ATTEMPTS, MIN, MAX);
        players = game.play();

        printPlayersNumbers(players);
        if (checkAnswer()) {
            main(args);
        }
    }
    private static void clearPlayersNumbers(Player[] players) {
        for (Player player : players) {
            player.clearInputNumbers();
        }
    }
    private static void printPlayersNumbers(Player[] players) {
        for (Player player : players) {
            printPlayerNumbers(player);
        }
    }

    public static void printPlayerNumbers(Player player) {
        System.out.println("Игрок " + player.getName() + " ввёл следующие числа: ");
        int[] inputNumbers = player.getInputNumbers();
        int len = inputNumbers.length;
        for (int i = 0; i < len; i++) {
            System.out.print(inputNumbers[i] + ((i == len / 2 - 1) && len > 5 ? "\n" : " "));
        }
        System.out.println();
    }

    private static boolean checkAnswer() {
        String answer;
        Scanner console = new Scanner(System.in);
        System.out.println("Хотите продолжить игру? [yes/no]:");
        answer = console.nextLine();
        if (!answer.trim().equals(YES) && !answer.trim().equals(NO)) {
            return checkAnswer();
        }
        return (answer.trim().equals(YES));
    }
}