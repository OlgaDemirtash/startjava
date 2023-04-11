public class Calculator {
    public static void main(String[] args) {
        //1. Калькулятор
        System.out.println("Калькулятор:");
        char sign = '^';
        int number1 = 2;
        int number2 = 4;
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
