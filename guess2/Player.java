package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private String name;
    private String[] numbers;
    private int attemptsCount = 0;
    private int[] inputNumbers;
    private int maxAttempts;

    public Player(String name, int maxAttempts) {
        this.name = name;
        this.maxAttempts = maxAttempts;
        inputNumbers = new int[maxAttempts];
    }

    public int getAttemptsCounter() {
        return attemptsCount;
    }

    public void setAttemptsCount(int attemptsCount) {
        this.attemptsCount = attemptsCount;
    }
    
    public String getName() {
        return name;
    }

    public int[] getInputNumbers() {
        return Arrays.copyOf(inputNumbers, attemptsCount);
    }

    public void increaseAttemptsCount() {
        attemptsCount++;
    }

    public boolean addInputNumber(int number, int min, int max) {
        if (number >= min && number <= max) {
            inputNumbers[attemptsCount] = number;
            increaseAttemptsCount();
            return true;
        }
        System.out.println("Число за пределами диапазона");
        return false;
    }
    public void clearInputNumbers() {
        Arrays.fill(inputNumbers, 0, attemptsCount, 0);
        attemptsCount = 0;
    }
    public void printPlayerNumbers() {
        System.out.println("Игрок " + getName() + " ввёл следующие числа: ");
        int[] inputNumbers = getInputNumbers();
        int len = inputNumbers.length;
        for (int i = 0; i < len; i++) {
            System.out.print(inputNumbers[i] + ((i == len/2) ? "\n" : " " ));
        }
        System.out.println();
    }
}

