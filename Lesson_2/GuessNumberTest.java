import java.util.Scanner;

public class GuessNumberTest {
    final static String ANSWER_YES = "yes";
    final static String ANSWER_NO = "no";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Угадай число:");
        System.out.println("Введите имя игрока 1: ");
        Player player1 = new Player(s.nextLine());
        System.out.println("Введите имя игрока 2: ");
        Player player2 = new Player(s.nextLine());

        int min = 1;
        int max = 100;
        boolean isNext = false;
        GuessNumber myGame = new GuessNumber(min, max, player1, player2);
        do {
            String answer;
            myGame.play();
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                answer = s.nextLine();
            } while(!answer.trim().equals(ANSWER_YES) && !answer.trim().equals(ANSWER_NO));
            isNext = false;
            if (answer.trim().equals(ANSWER_YES)) {
                isNext = true;
                myGame.setHiddenNumber(min,max);
            }
        } while(isNext);
    }
}