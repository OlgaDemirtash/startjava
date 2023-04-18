import java.util.Scanner;

public class GuessNumber {

    private int hiddenNumber;
    private Player player1;
    private Player player2;
    private int min;
    private int max;

    public GuessNumber(Player player1, Player player2) {
        min = 1;
        max = 100;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setHiddenNumber(int min, int max) {
        this.hiddenNumber = (int) ((Math.random() * (max - min + 1) + min));
    }

    public void play() {
        Player currentPlayer = player1;
        setHiddenNumber(min, max);
        while (true) {
            int answer = nextNumber(min, max, currentPlayer.getName());
            if (answer > hiddenNumber) {
                System.out.printf("Число %d больше того, что загадал компьютер\n\n", answer);
            } else if (answer < hiddenNumber) {
                System.out.printf("Число %d меньше того, что загадал компьютер\n\n", answer);
            } else {
                break;
            }
            if (currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
        System.out.println("Игрок с именем " + currentPlayer.getName() + " победил!");
    }

    public int nextNumber(int min, int max, String name) {
        Scanner console = new Scanner(System.in);
        int num = 0;
        while (true) {
            System.out.println(name + " введите целое число в диапазоне [" 
                    + min + ", " + max +"]: " );
            String line = console.nextLine();
            try {
                num = Integer.parseInt(line);
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println("Число за пределами диапазона");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод");
            }
        }
    }
}
