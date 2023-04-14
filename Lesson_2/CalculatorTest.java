import java.util.Scanner;

public class CalculatorTest {
    final static String YES = "yes";
    final static String NO = "no";
    
    public static void main(String[] args) {
        char sign;
        int number1 = 0;
        int number2 = 0;
        Scanner console = new Scanner(System.in);
        Calculator calculator = new Calculator();
        do {
            while (true) {
                System.out.println("Введите первое число: ");
                String line = console.nextLine();
                try {
                    number1 = Integer.parseInt(line);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неправильный ввод");
                    continue;
                }
            }

            do { 
                System.out.println("Введите знак математической операции : ");
                sign = console.nextLine().charAt(0); 
                if (sign == '+' || sign == '-' || sign == '*'|| sign == '/'|| sign == '^'|| sign == '%') {
                    break;
                }
            } while (true);

            while (true) {
                System.out.println("Введите второе число: ");
                String line = console.nextLine();
                try {
                    number2 = Integer.parseInt(line);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неправильный ввод");
                    continue;
                }
            }

            System.out.println();
            int result = calculator.run(number1, number2, sign);
            System.out.println(number1 + " " + sign + " " + number2 + " = " + result);

            String answer;
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                answer = console.nextLine();
            } while (!answer.trim().equals(YES) && !answer.trim().equals(NO));
            if (answer.trim().equals(NO)) {
                break;
            }
        } while(true);
    }
}

