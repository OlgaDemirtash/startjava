public class Calculator {
    public int run (int number1, int number2, char sign) {
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
            }
            return result;
    }
}
