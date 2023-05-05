package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    final static String YES = "yes";
    final static String NO = "no";

    public static void main(String[] args) {
        double result;
        Scanner console = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");
        String expression = console.nextLine();
        try {
            result = Calculator.calculate(expression);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + "\n");
            main(args);
            return;
        }
        DecimalFormat dF = new DecimalFormat("#####.###");
        System.out.println(expression + " = " + dF.format(result));
        if (checkAnswer()) {
            main(args);
        }
    }

    private static boolean checkAnswer() {
        Scanner console = new Scanner(System.in);
        System.out.println("Хотите продолжить вычисления? [yes/no]:");
        String answer = console.nextLine();
        if (!answer.trim().equals(YES) && !answer.trim().equals(NO)) {
            return checkAnswer();
        }
        return (answer.trim().equals(YES));
    }
}
