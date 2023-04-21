package com.startjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumberTest {
    final static String YES = "yes";
    final static String NO = "no";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Угадай число:");
        System.out.println("Введите имя игрока 1: ");
        Player player1 = new Player(console.nextLine());
        System.out.println("Введите имя игрока 2: ");
        Player player2 = new Player(console.nextLine());

        String answer;
        GuessNumber game = new GuessNumber(player1, player2);
        do {
            game.play();
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                answer = console.nextLine();
            } while (!answer.trim().equals(YES) && !answer.trim().equals(NO));
        } while (!answer.trim().equals(NO));
    }
}