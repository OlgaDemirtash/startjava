package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public void calculate(int number1, int number2, char sign) {
        int result = number1;
        switch (sign) {
            case '+':
                result += number2;
                break;
            case '-':
                result -= number2;
                break;
            case '*':
                result *= number2;
                break;
            case '/':
                result /= number2;
                break;
            case '^':
                for (int i = 1; i < number2; i++) {
                    result *= number1;
                }
                break;
            case '%':
                result %= number2;
                break;
            default:
                System.out.println("Оператор не поддерживается");
                return;
        }
        System.out.println(number1 + " " + sign + " " + number2 + " = " + result);
    }
}
