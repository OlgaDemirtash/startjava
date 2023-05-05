package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private String name;
    private int attemptsCount = 0;
    private int[] inputNumbers;

    public Player(String name, int maxAttempts) {
        this.name = name;
        inputNumbers = new int[maxAttempts];
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

    public String getName() {
        return name;
    }

    public int[] getInputNumbers() {
        return Arrays.copyOf(inputNumbers, attemptsCount);
    }

    public boolean addInputNumber(int number, int min, int max) {
        if (number >= min && number <= max) {
            inputNumbers[attemptsCount] = number;
            increaseAttemptsCount();
            return true;
        }
        return false;
    }

    public void increaseAttemptsCount() {
        attemptsCount++;
    }

    public void clearInputNumbers() {
        Arrays.fill(inputNumbers, 0, attemptsCount, 0);
        attemptsCount = 0;
    }
}

