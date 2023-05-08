package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    final static String YES = "yes";
    final static String NO = "no";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer = YES;
        while (true) {
            if (!answer.trim().equals(YES) && !answer.trim().equals(NO)) {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                answer = console.nextLine();
                continue;
            }
            if (answer.trim().equals(NO)) {
                break;
            }
            System.out.print("Введите математическое выражение: ");
            String expression = console.nextLine();
            try {
                printResult(expression, Calculator.calculate(expression));
                answer = "";
            } catch (RuntimeException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    private static void printResult(String expression, double result) {
        DecimalFormat dF = new DecimalFormat("#####.###");
        System.out.println(expression + " = " + dF.format(result));
    }
}