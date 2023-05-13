package com.startjava.lesson_2_3_4.guess;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class GuessNumber {

    private final Player[] players;
    private final int min;
    private final int max;
    private final int maxAttempts;
    private int hiddenNumber;

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
        int countOffPlayers = 0;
        while (true) {
            for (Player currentPlayer : players) {
                int nextNumber = inputNextNumber(currentPlayer);
                if (isGuessed(nextNumber, currentPlayer)) {
                    return;
                }
                if (!hasAttempt(currentPlayer)) {
                    countOffPlayers++;
                }
                if (countOffPlayers >= players.length) {
                    return;
                }
            }
        }
    }

    private int inputNextNumber(Player player) {
        Scanner console = new Scanner(System.in);
        System.out.println(player.getName() + " введите целое число в диапазоне ["
                + min + ", " + max + "]: ");
        try {
            int number = console.nextInt();
            if (player.addNumber(number, min, max)) {
                return number;
            }
            System.out.println("Число за пределами диапазона");
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Неправильный ввод");
        }
        return inputNextNumber(player);
    }

    private boolean isGuessed(int nextNumber, Player player) {
        if (nextNumber == hiddenNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + nextNumber
                    + " с " + player.getCountAttempts() + " попытки!\n");
            return true;
        }
        System.out.printf("Число %d" + ((nextNumber > hiddenNumber) ? " больше " : " меньше ")
                + "того, что загадал компьютер\n\n", nextNumber);
        return false;
    }

    private boolean hasAttempt(Player player) {
        if (player.getCountAttempts() == maxAttempts) {
            System.out.println("У " + player.getName() + " закончились попытки");
            return false;
        }
        return true;
    }

    private void printPlayersNumbers() {
        for (Player player : players) {
            System.out.println("Игрок " + player.getName() + " ввёл следующие числа: ");
            int[] inputNumbers = player.getInputNumbers();
            int len = inputNumbers.length;
            for (int i = 0; i < len; i++) {
                System.out.print(inputNumbers[i] + ((i == len / 2 - 1) && len > 5 ? "\n" : " "));
            }
            System.out.println();
        }
    }

    private void clearPlayersNumbers() {
        for (Player player : players) {
            player.clearInputNumbers();
        }
    }
}