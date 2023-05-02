package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {

    private int hiddenNumber;
    private Player[] players;
    private int min;
    private int max;
    private int maxAttempts;

    public GuessNumber(Player[] players, int maxAttempts, int min, int max) {
        this.min = 1;
        this.max = 100;
        this.players = players;
        this.maxAttempts = maxAttempts;
    }

    private void setHiddenNumber() {
        hiddenNumber = (int) (Math.random() * max + min);
    }

    public void play() {
        System.out.printf("У каждого игрога по %d попыток\n", maxAttempts);
        setHiddenNumber();
        checkNumber();
    }

    private void checkNumber() {
        while (true) {
            for (Player currentPlayer : players) {
                if (currentPlayer.getAttemptsCounter() == maxAttempts) {
                    System.out.println("У " + currentPlayer.getName() + "закончились попытки");
                    printPlayersNumbers();
                    return;
                }
                int nextNumber = inputNumber(currentPlayer);
                if (nextNumber == hiddenNumber) {
                    System.out.println("Игрок " + currentPlayer.getName() + " угадал число " + nextNumber
                            + " с " + currentPlayer.getAttemptsCounter() + " попытки!\n");
                    printPlayersNumbers();
                    return;
                }
                System.out.printf("Число %d" + ((nextNumber > hiddenNumber) ? " больше " : " меньше ") + "того, что загадал компьютер\n\n", nextNumber);
            }
        }
    }

    private int inputNumber(Player player) {
        Scanner console = new Scanner(System.in);
        System.out.println(player.getName() + " введите целое число в диапазоне ["
                + min + ", " + max + "]: ");
        String line = console.nextLine();
        try {
            int number = Integer.parseInt(line);
            if (player.addInputNumber(number, min, max)) {
                return number;
            }
        } catch (NumberFormatException e) {
            System.out.println("Неправильный ввод");
        }
        return inputNumber(player);
    }

    private void printPlayersNumbers() {
        for (Player player : players) {
            player.printPlayerNumbers();
        }
    }

}