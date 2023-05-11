package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    final static String YES = "yes";
    final static String NO = "no";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer = YES;
        do {
            if (answer.trim().equals(YES)) {
                System.out.print("Введите математическое выражение: ");
                String expression = console.nextLine();
                try {
                    printResult(expression, Calculator.calculate(expression));
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage() + "\n");
                    continue;
                }
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            answer = console.nextLine();
        } while (!answer.trim().equals(NO));
    }

    private static void printResult(String expression, double result) {
        DecimalFormat dF = new DecimalFormat("#####.###");
        System.out.println(expression + " = " + dF.format(result));
    }
}