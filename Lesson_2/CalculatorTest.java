import java.util.Scanner;

public class CalculatorTest {
    final static String ANSWER_YES = "yes";
    final static String ANSWER_NO = "no";
    
    public static void main(String[] args) {
        char sign;
        int number1 = 0;
        int number2 = 0;
        boolean isNext = false;
        Scanner s = new Scanner(System.in);
        Calculator calculator = new Calculator();
        do {
            boolean isNumError = true;
            while (isNumError) {
                System.out.println("Введите первое число: ");
                String line = s.nextLine();
                try {
                    number1 = Integer.parseInt(line);
                        isNumError = false;
                } catch (NumberFormatException e) {
                    System.out.println("Неправильный ввод");
                    continue;
                }
            }

            boolean isSignError = false;
            do { 
                System.out.println("Введите знак математической операции: ");
                sign = s.nextLine().charAt(0); 
                if (sign == '+' || sign == '-' || sign == '*'|| sign == '/'|| sign == '^'|| sign == '%') {
                    isSignError = false;
                } else {
                    isSignError = true;
                }
            } while (isSignError);

            isNumError = true;
            while (isNumError) {
                System.out.println("Введите второе число: ");
                String line = s.nextLine();
                try {
                    number2 = Integer.parseInt(line);
                    isNumError = false;
                } catch (NumberFormatException e) {
                    System.out.println("Неправильный ввод");
                    continue;
                }
            }

            System.out.println("");
            int result = calculator.run(number1, number2, sign);
            System.out.println(number1 + " " + sign + " " + number2 + " = " + result);

            String answer;
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                answer = s.nextLine();
            } while(!answer.trim().equals(ANSWER_YES) && !answer.trim().equals(ANSWER_NO));
            isNext = false;
            if (answer.trim().equals(ANSWER_YES)) {
                isNext = true;
            }
        } while(isNext);
    }
}

