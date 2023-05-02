/*Модифицируйте программу "Калькулятор":
используйте следующий формат ввода (пример):
Введите математическое выражение: 2 ^ 10

введенное выражение храните в массиве, применив метод String.split()
для преобразования чисел из String в int используйте Integer.parseInt()
замените методами класса Math, какие сможете найти, ваши реализации вычислений
метод calculate() должен возвращать результат вычисления (double). Выводите его в CalculatorTest
выводите результат без дробной части, если она равна 0, и с дробной, если она имеет значимые цифры (три знака после запятой)
вместо вложенного цикла в CalculatorTest используйте if

Задание со *:
реализуйте вывод результата через тернарный оператор
сделайте метод calculate() — статическим. При этом создавать экземпляр Calculator уже не нужно
используйте новый switch expression (1, 2)
делайте проверку, что вводимые числа — целые и положительные
программа не должна падать (закрываться), если введены не удовлетворяющие условиям данные (используйте try-catch). В качестве классов исключений используйте наследники RuntimeException (являются непроверяемыми исключениями)
в подобной ситуации — просите пользователя ввести корректные значения */

package com.startjava.lesson_2_3_4.calculator;
public class Calculator {
    public static double calculate(int number1, int number2, String sign) {
        double  result = number1;
        System.out.println(sign);
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
