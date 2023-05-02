package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public static double calculate(int number1, int number2, String sign) {
        double result = number1;
        switch (sign) {
            case "+" -> result = Math.addExact(number1, number2);
            case "-" -> result = Math.subtractExact(number1, number2);
            case "*" -> result = Math.multiplyExact(number1, number2);
            case "/" -> result /= number2;
            case "^" -> result = Math.pow((double) number1, (double) number2);
            case "%" -> result %= number2;
        }
        return result;
    }
}
