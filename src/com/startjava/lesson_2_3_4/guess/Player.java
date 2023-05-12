package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private int countAttempts;
    private final int[] inputNumbers;

    public Player(String name, int maxAttempts) {
        this.name = name;
        inputNumbers = new int[maxAttempts];
    }

    public String getName() {
        return name;
    }

    public int getCountAttempts() {
        return countAttempts;
    }

    public int[] getInputNumbers() {
        return Arrays.copyOf(inputNumbers, countAttempts);
    }

    public boolean addInputNumber(int number, int min, int max) {
        if (number >= min && number <= max) {
            inputNumbers[countAttempts] = number;
            countAttempts++;
            return true;
        }
        return false;
    }

    public void clearInputNumbers() {
        Arrays.fill(inputNumbers, 0, countAttempts, 0);
        countAttempts = 0;
    }
}

