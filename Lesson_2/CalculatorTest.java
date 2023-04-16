import java.util.Scanner;

public class CalculatorTest {
    final static String YES = "yes";
    final static String NO = "no";
    private static Scanner console;
    
    public static void main(String[] args) {
        char sign;
        int number1 = 0;
        int number2 = 0;
        Calculator calculator = new Calculator();
        String answer;

        do {
            number1 = getNextNumber("Введите первое число");
            sign = getSign("Введите знак математической операции :");
            number2 = getNextNumber("Введите второе число");
            calculator.calculate(number1, number2, 'd');

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                answer = console.nextLine();
            } while (!answer.trim().equals(YES) && !answer.trim().equals(NO));
        } while(!answer.trim().equals(NO));
    }
    private static int getNextNumber(String info) {
        int number;
        getConsole();
        while (true) {
            System.out.println(info);
            String line = console.nextLine();
            try {
                number = Integer.parseInt(line);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод");
            }
         }
    }
    private static char getSign(String info) {
        char sign;
        getConsole();
        do {
            System.out.println(info);
            sign = console.nextLine().charAt(0); 
            if (sign == '+' || sign == '-' || sign == '*'|| sign == '/'|| sign == '^'|| sign == '%') {
                return sign;
            } else {
                System.out.println("Неправильный ввод");
            }
        } while (true);
    }
    private static void getConsole() {
        if (console == null) {
            console = new Scanner(System.in);
        }
    }
}