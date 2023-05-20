package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private final int[] inputNumbers;
    private int countAttempts;
    private final int maxAttempts;
    private int score;

    public Player(Player otherPlayer) {
        this(otherPlayer.getName(), otherPlayer.getMaxAttempts());
    }

    public Player(String name, int maxAttempts) {
        this.name = name;
        this.maxAttempts = maxAttempts;
        inputNumbers = new int[maxAttempts];
    }

    public String getName() {
        return name;
    }

    public int[] getInputNumbers() {
        return Arrays.copyOf(inputNumbers, countAttempts);
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public boolean addNumber(int number, int min, int max) {
        if (number >= min && number <= max) {
            inputNumbers[countAttempts] = number;
            countAttempts++;
            return true;
        }
        return false;
    }

    public int getCountAttempts() {
        return countAttempts;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public void clear() {
        Arrays.fill(inputNumbers, 0, countAttempts, 0);
        countAttempts = 0;
    }

    public void clearScore() {
        score = 0;
    }
}

