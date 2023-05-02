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
import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    final static String YES = "yes";
    final static String NO = "no";


    
    public static void main(String[] args) {


        String answer;
        String expression;
        Scanner console = new Scanner(System.in);
        String[] elementsStr = new String[3];
        int elementsInt[];

        do {
            while (true) {
                expression = expressionInput(console);
                elementsStr = expression.trim().split(" ",3);
                String sign = elementsStr[1];
                if (isSign(elementsStr[1])) {
                    if (isNumber(elementsStr[0],1)
                            && isNumber(elementsStr[2],2)) {
                        break;
                    }
                } else {
                    System.out.println("Вы ввели недопустимый знак, повторите ввод ");
                }
            }
            elementsInt = convertArray(elementsStr);
            double result = Calculator.calculate(elementsInt[0],elementsInt[1], elementsStr[1]);
            DecimalFormat dF = new DecimalFormat("#####.###");
            System.out.println(elementsInt[0] + " " + elementsStr[1] + " " + elementsInt[1] + " = " + dF.format(result));
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                answer = console.nextLine();
            } while (!answer.trim().equals(YES) && !answer.trim().equals(NO));
        } while(!answer.trim().equals(NO));
    }

    private static boolean isNumber(String str, int position) {
        try {
                int number = Integer.parseInt(str);
                if (number > 0) {
                    return true;
                } else {
                    System.out.printf("Вы ввели отрицательное число в позицию %d, повторите ввод\n", position);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Вы ввели не целое число в позицию %d, повторите ввод\n", position);
            }
        return false;
    }

    private static int[] convertArray(String[] strArr) {
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
        return  intArr;
    }

    private static boolean isSign(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*")
                || str.equals("/") || str.equals("^") || str.equals("%");
    }

    private static String expressionInput(Scanner console) {
        String expression;
        System.out.print("Введите математическое выражение: ");
        expression = console.nextLine();
        expression = expression.replaceAll("\\s","").trim();
        expression = expression.replaceAll("[/*%^+-](?=-\\d)]", " $0 ");
        expression = expression.replaceAll("[/*%^+]", " $0 ");
        return expression;
    }
}
