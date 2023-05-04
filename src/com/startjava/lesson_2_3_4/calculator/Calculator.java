package com.startjava.lesson_2_3_4.calculator;

import java.util.Arrays;

public class Calculator {
    public static String[] getExpressionElements(String expression) throws Exception {
        try {
            return checkExpression(parseExpression(expression));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static String parseExpression(String expression) throws Exception {
        expression = expression.replaceAll("\\s", "");
        if (expression.contains(".") || expression.contains(",")) {
            throw new Exception("Допускаются только целые числа и операции  /*-+=%^");
        }
        expression = expression.replaceAll("[^ 0-9/*%^+-]", "");
        if (expression.length() < 3) {
            throw new Exception("Недопустимая длинна выражения" + expression.length());
        }
        expression = expression.replaceAll("[/*%^+-]", " $0 ");
        expression = expression.replaceAll("\\s+", " ");
        expression = expression.replaceAll("[/*%^+-](?=-\\d)", " $0 ");
        expression = expression.replaceAll("(?<=[/*%^+-] )- ", "-");
        expression = expression.replaceAll("^\s*-\s*(?=\\d)", "-");
        return expression;
    }

    public static String[] checkExpression(String expression) throws Exception {
        String[] exprElements = Arrays.copyOf(expression.trim().split(" "), 3);
        char pos = '1';
        if (!isSign(exprElements[1])) {
            throw new Exception("Вы ввели недопустимый знак " + exprElements[1]);
        } else {
            try {
                isNumber(exprElements[0]);
                pos = '2';
                isNumber(exprElements[2]);
            } catch (Exception e) {
                throw new Exception((e.getMessage() + "в позицию " + pos));
            }
        }
        return exprElements;
    }

    private static boolean isSign(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*")
                || str.equals("/") || str.equals("^") || str.equals("%");
    }

    private static void isNumber(String str) throws Exception {
        try {
            int number = Integer.parseInt(str);
            if (number < 0) {
                throw new Exception("Вы ввели отрицательное число ");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Вы ввели не целое число ");
        }
    }

    public static double calculate(String[] Elements) {
        int number1 = Integer.parseInt(Elements[0]);
        String sign = Elements[1];
        int number2 = Integer.parseInt(Elements[2]);
        return switch (sign) {
            case "+" -> Math.addExact(number1, number2);
            case "-" -> Math.subtractExact(number1, number2);
            case "*" -> Math.multiplyExact(number1, number2);
            case "/" -> (double) number1 / (double) number2;
            case "^" -> Math.pow(number1, number2);
            case "%" -> number1 % number2;
            default -> 0;
        };
    }
}
