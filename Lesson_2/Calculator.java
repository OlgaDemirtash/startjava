public class Calculator {
    public int run (int number1, int number2, char sign) {
        int result = number1;
        switch (sign) {
            case '+':
                return result += number2;
            case '-':
                return result -= number2;
            case '*':
                return result *= number2;
            case '/':
                return result /= number2;
            case '^':
                for (int i = 1; i < number2; i++) {
                    result *= number1;
                }
                return result;
            case '%':
                return result %= number2;
            default:
                System.out.println("Оператор не поддерживается");
        }
        return result;
    }
}
