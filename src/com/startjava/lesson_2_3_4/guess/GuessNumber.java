package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {

    private int hiddenNumber;
    private final Player[] players;
    private final int min;
    private final int max;
    private final int maxAttempts;

    public GuessNumber(Player[] players, int maxAttempts, int min, int max) {
        this.min = min;
        this.max = max;
        this.players = players;
        this.maxAttempts = maxAttempts;
    }

    private void setHiddenNumber() {
        hiddenNumber = (int) (Math.random() * max + min);
    }

    public void play() {
        setHiddenNumber();
        startGame();
        printPlayersNumbers();
        clearPlayersNumbers();
    }

    private void startGame() {
        while (true) {
            for (Player currentPlayer : players) {
                if (isPlayerAttemptsEnd(currentPlayer)) {
                    return;
                }
                int nextNumber = inputNextNumber(currentPlayer);
                if (isPlayerGuessNumber(nextNumber, currentPlayer)) {
                    return;
                }
                System.out.printf("Число %d" + ((nextNumber > hiddenNumber) ? " больше " : " меньше ")
                        + "того, что загадал компьютер\n\n", nextNumber);
            }
        }
    }

    private boolean isPlayerAttemptsEnd(Player player) {
        if (player.getCountAttempts() == maxAttempts) {
            System.out.println("У " + player.getName() + "закончились попытки");
            return true;
        }
        return false;
    }

    private int inputNextNumber(Player player) {
        Scanner console = new Scanner(System.in);
        System.out.println(player.getName() + " введите целое число в диапазоне ["
                + min + ", " + max + "]: ");
        String playerInput = console.nextLine();
        try {
            int number = Integer.parseInt(playerInput);
            if (player.addInputNumber(number, min, max)) {
                return number;
            }
            System.out.println("Число за пределами диапазона");
        } catch (NumberFormatException e) {
            System.out.println("Неправильный ввод");
        }
        return inputNextNumber(player);
    }

    private boolean isPlayerGuessNumber(int nextNumber, Player player) {
        if (nextNumber == hiddenNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + nextNumber
                    + " с " + player.getCountAttempts() + " попытки!\n");
            return true;
        }
        return false;
    }

    private void printPlayersNumbers() {
        for (Player player : players) {
            printPlayerNumbers(player);
        }
    }

    private static void printPlayerNumbers(Player player) {
        System.out.println("Игрок " + player.getName() + " ввёл следующие числа: ");
        int[] inputNumbers = player.getInputNumbers();
        int len = inputNumbers.length;
        for (int i = 0; i < len; i++) {
            System.out.print(inputNumbers[i] + ((i == len / 2 - 1) && len > 5 ? "\n" : " "));
        }
        System.out.println();
    }

    private void clearPlayersNumbers() {
        for (Player player : players) {
            player.clearInputNumbers();
        }
    }
}