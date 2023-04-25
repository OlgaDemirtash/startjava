package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {

    private int hiddenNumber;
    private Player player1;
    private Player player2;
    private int min;
    private int max;

    public GuessNumber(Player player1, Player player2) {
        min = 1;
        max = 100;
        this.player1 = player1;
        this.player2 = player2;
    }

    private void setHiddenNumber() {
        hiddenNumber = (int) (Math.random() * max + min);
    }

    public void play() {
        setHiddenNumber();
        checkNumber();

    }

    private void checkNumber() {
        Player currentPlayer = player1;
        while (true) {
            int nextNumber = inputNumber(currentPlayer.getName());
            if (nextNumber == hiddenNumber) {
                System.out.println("Игрок с именем " + currentPlayer.getName() + " победил!");
                return;
            }
            if (nextNumber > hiddenNumber) {
                System.out.printf("Число %d больше того, что загадал компьютер\n\n", nextNumber);
            } else if (nextNumber < hiddenNumber) {
                System.out.printf("Число %d меньше того, что загадал компьютер\n\n", nextNumber);
            }
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }
    
    private int inputNumber(String name) {
        Scanner console = new Scanner(System.in);
        int number = 0;
        while (true) {
            System.out.println(name + " введите целое число в диапазоне [" 
                    + min + ", " + max +"]: " );
            String line = console.nextLine();
            try {
                number = Integer.parseInt(line);
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println("Число за пределами диапазона");
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод");
            }
        }
    }
}
