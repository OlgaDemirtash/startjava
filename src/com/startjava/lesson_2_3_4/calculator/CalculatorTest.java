package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    final static String YES = "yes";
    final static String NO = "no";

    public static void main(String[] args) {
        calc();
    }

    private static void calc() {
        String[] exprElements = inputExpression();
        double result = Calculator.calculate(exprElements);
        outputExpression(exprElements, result);
        if (checkAnswer()) {
            calc();
        }
    }

    private static String[] inputExpression() {
        Scanner console = new Scanner(System.in);
        String[] exprElements;
        System.out.print("Введите математическое выражение: ");
        String expression = console.nextLine();
        try {
            exprElements = Calculator.getExpressionElements(expression);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            return inputExpression();
        }
        return exprElements;
    }

    private static void outputExpression(String[] exprElements, double result) {
        DecimalFormat dF = new DecimalFormat("#####.###");
        System.out.println(exprElements[0] + " " + exprElements[1] + " " + exprElements[2] + " = " + dF.format(result));
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
