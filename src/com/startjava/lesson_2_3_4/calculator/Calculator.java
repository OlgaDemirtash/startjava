package com.startjava.lesson_2_3_4.calculator;

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

    private static String parseExpression(String expression) {
        expression = expression.replaceAll("\\s", "");
        expression = expression.replaceAll("[^ 0-9/*%^+-.,]", "");
        expression = expression.replaceAll("[/*%^+-]", " $0 ");
        expression = expression.replaceAll("\\s+", " ");
        expression = expression.replaceAll("[/*%^+-](?=-\\d)", " $0 ");
        expression = expression.replaceAll("(?<=[/*%^+-] )- ", "-");
        expression = expression.replaceAll("^\s*-\s*(?=\\d)", "-");
        return expression;
    }

    private static String[] checkExpression(String expression) {
        if (expression.length() < 5) {
            throw new IndexOutOfBoundsException("Недопустимая длинна выражения ");
        }
        String[] exprElements = expression.trim().split(" ");
        if (!isSign(exprElements[1])) {
            throw new UnsupportedOperationException("Вы ввели недопустимый знак " + exprElements[1]);
        }
        char pos = '1';
        try {
            isStrPositiveIntNumber(exprElements[0]);
            pos = '2';
            isStrPositiveIntNumber(exprElements[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException((e.getMessage() + "в позицию " + pos));
        }
        return exprElements;
    }

    private static boolean isSign(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*")
                || str.equals("/") || str.equals("^") || str.equals("%");
    }

    private static void isStrPositiveIntNumber(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Вы ввели не целое число ");
        }
        if (number < 0) {
            throw new NumberFormatException("Вы ввели отрицательное число ");
        }
    }
}