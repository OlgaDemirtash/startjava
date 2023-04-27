package com.startjava.lesson_2_3_4.guess;

public class Player {

    private String name;
    private String[] numbers;
    private int attemptsCounter = 0;
    private int[] inputNumbers;


    public Player(String name, int attempts, int maxAttempts) {
        this.name = name;
        this.maxAttempts = maxAttempts;
        inputNumbers = new int[maxAttempts];
    }

    public int getAttemptsCounter() {
        return attemptsCounter;
    }

    public void setAttemptsCounter(int attemptsCounter) {
        this.attemptsCounter = attemptsCounter;
    }
    
    public String getName() {
        return name;
    }

    public void increaseAttemptsCounter() {
        attemptsCounter++;
    }

    public void addInputNumber(int number) {
        inputNumbers[attemptsCounter] = number;
        increaseAttemptsCounter();
    }

}

