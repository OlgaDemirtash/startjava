public class MyFirstGame {
    public static void main(String[] args) {
        //2. Угадай число
        System.out.println("Угадай число:");
        int hiddenNumber = 88;
        int answer = 100;
        int min = 0;
        int max = 100;
        while (answer != hiddenNumber) {
            if (answer > hiddenNumber) {
                System.out.printf("Число %d больше того, что загадал компьютер\n", answer);
                max = answer;
            } else if (answer < hiddenNumber) {
                System.out.printf("Число %d меньше того, что загадал компьютер\n", answer);
                min = answer;
            }
            answer = (min + max) / 2;
        }
        System.out.println("Вы победили!");
    }
}