package com.startjava.lesson_2_3_4.calculator;

import java.util.Arrays;

public class Calculator {
    public static double calculate(String expression) {
        String[] elements;
        try {
            elements = checkExpression(parseExpression(expression));

        } catch (NumberFormatException | UnsupportedOperationException | IndexOutOfBoundsException e) {
            throw new IllegalCallerException(e.getMessage());
        }
        int number1 = Integer.parseInt(elements[0]);
        String sign = elements[1];
        int number2 = Integer.parseInt(elements[2]);
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

    public static String[] checkExpression(String expression) {
        String[] exprElements = Arrays.copyOf(expression.trim().split(" "), 3);
        char pos = '1';
        if (!isSign(exprElements[1])) {
            throw new UnsupportedOperationException("Вы ввели недопустимый знак " + exprElements[1]);
        } else {
            try {
                isNumber(exprElements[0]);
                pos = '2';
                isNumber(exprElements[2]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException((e.getMessage() + "в позицию " + pos));
            }
        }
        return exprElements;
    }

    public static String parseExpression(String expression) {
        expression = expression.replaceAll("\\s", "");
        if (expression.contains(".") || expression.contains(",")) {
            throw new NumberFormatException("Допускаются только целые числа и операции  /*-+=%^");
        }
        expression = expression.replaceAll("[^ 0-9/*%^+-]", "");
        if (expression.length() < 3) {
            throw new IndexOutOfBoundsException("Недопустимая длинна выражения" + expression.length());
        }
        expression = expression.replaceAll("[/*%^+-]", " $0 ");
        expression = expression.replaceAll("\\s+", " ");
        expression = expression.replaceAll("[/*%^+-](?=-\\d)", " $0 ");
        expression = expression.replaceAll("(?<=[/*%^+-] )- ", "-");
        expression = expression.replaceAll("^\s*-\s*(?=\\d)", "-");
        return expression;
    }

    private static boolean isSign(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*")
                || str.equals("/") || str.equals("^") || str.equals("%");
    }

    private static void isNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            if (number < 0) {
                throw new NumberFormatException("Вы ввели отрицательное число ");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Вы ввели не целое число ");
        }
    }


}
