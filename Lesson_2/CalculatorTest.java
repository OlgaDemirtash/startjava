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
        Scanner console;
        console = new Scanner(System.in);
        do {
            number1 = inputNumber("первое", console);
            sign = inputSign("Введите знак математической операции: ", console);
            number2 = inputNumber("второе", console);
            calculator.calculate(number1, number2, sign);

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                answer = console.nextLine();
            } while (!answer.trim().equals(YES) && !answer.trim().equals(NO));
        } while(!answer.trim().equals(NO));
    }

    private static int  inputNumber(String info, Scanner console) {
        int number;
        while (true) {
            System.out.printf("Введите %s число: ", info);
            String line = console.nextLine();
            try {
                number = Integer.parseInt(line);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод");
            }
         }
    }

    private static char inputSign(String info, Scanner console) {
        do {
            System.out.print(info);
            char sign = console.nextLine().charAt(0); 
            if (sign == '+' || sign == '-' || sign == '*'|| sign == '/'|| sign == '^'|| sign == '%') {
                return sign;
            } 
            System.out.println("Неправильный ввод");
        } while (true);
    }
}
