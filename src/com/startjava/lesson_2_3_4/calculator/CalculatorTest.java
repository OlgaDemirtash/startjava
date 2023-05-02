package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class CalculatorTest {
    final static String YES = "yes";
    final static String NO = "no";

    public static void main(String[] args) {
        calc();
    }

    private static void calc() {
        String[] elementsStr = checkExpression();
        int[] elementsInt = convertStrArrayToInt(elementsStr);
        double result = Calculator.calculate(elementsInt[0], elementsInt[1], elementsStr[1]);
        DecimalFormat dF = new DecimalFormat("#####.###");
        System.out.println(elementsInt[0] + " " + elementsStr[1] + " " + elementsInt[1] + " = " + dF.format(result));
        if (checkAnswer()) {
            calc();
        }
    }

    private static boolean checkAnswer() {
        Scanner console = new Scanner(System.in);
        System.out.println("Хотите продолжить вычисления? [yes/no]:");
        String answer = console.nextLine();
        if (!answer.trim().equals(YES) && !answer.trim().equals(NO)) {
            checkAnswer();
        }
        return (answer.trim().equals(YES));
    }

    private static String[] checkExpression() {
        String[] elementsStr = Arrays.copyOf(expressionInput().trim().split(" "), 3);
        if (!isSign(elementsStr[1])) {
            System.out.printf("Вы ввели недопустимый знак %s, повторите ввод \n", elementsStr[1]);
            return checkExpression();
        } else {
            if (!isNumber(elementsStr[0], 1) || !isNumber(elementsStr[2], 2)) {
                return checkExpression();
            }
        }
        return elementsStr;
    }

    private static String expressionInput() {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");
        String expression = console.nextLine();
        expression = expression.replaceAll("\\s", "");
        if (expression.contains(".") || expression.contains(",")) {
            System.out.print("Допускаются только целые числа и операции  /*-+=%^ \n");
            return expressionInput();
        }
        expression = expression.replaceAll("[^ 0-9/*%^+-]", "");
        if (expression.length() < 3) {
            System.out.print("Недопустимое выражение \n");
            return expressionInput();
        }
        expression = expression.replaceAll("[/*%^+-]", " $0 ");
        expression = expression.replaceAll("\\s+", " ");
        expression = expression.replaceAll("[/*%^+-](?=-\\d)", " $0 ");
        expression = expression.replaceAll("(?<=[/*%^+-] )- ", "-");
        return expression;
    }

    private static boolean isSign(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*")
                || str.equals("/") || str.equals("^") || str.equals("%");
    }

    private static boolean isNumber(String str, int position) {
        try {
            int number = Integer.parseInt(str);
            if (number >= 0) {
                return true;
            } else {
                System.out.printf("Вы ввели отрицательное число в позицию %d, "
                        + "повторите ввод\n", position);
            }
        } catch (NumberFormatException e) {
            System.out.printf("Вы ввели не целое число в позицию %d, "
                    + "повторите ввод\n", position);
        }
        return false;
    }

    private static int[] convertStrArrayToInt(String[] strArr) {
        int lengthIntArr = 0;
        for (String s : strArr) {
            if (isSign(s)) {
                continue;
            }
            lengthIntArr++;
        }
        int[] intArr = new int[lengthIntArr];
        int j = 0;
        for (String s : strArr) {
            if (isSign(s)) {
                continue;
            }
            intArr[j] = Integer.parseInt(s);
            j++;
        }
        return intArr;
    }
}
