import java.util.Scanner;

public class GuessNumberTest {
    final static String YES = "yes";
    final static String NO = "no";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Угадай число:");
        System.out.println("Введите имя игрока 1: ");
        Player player1 = new Player(console.nextLine());
        System.out.println("Введите имя игрока 2: ");
        Player player2 = new Player(console.nextLine());

        int min = 1;
        int max = 100;
        GuessNumber myGame = new GuessNumber(min, max, player1, player2);
        do {
            String answer;
            myGame.play();
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                answer = console.nextLine();
            } while (!answer.trim().equals(YES) && !answer.trim().equals(NO));
            if (answer.trim().equals(YES)) {
                myGame.setHiddenNumber(min,max);
            } else {
                break;
            }
        } while (true);
    }
}