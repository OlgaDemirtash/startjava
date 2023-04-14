public class GuessNumber {

    private int hiddenNumber;
    private Player player1;
    private Player player2;
    private int min;
    private int max;

    public GuessNumber(int min, int max, Player player1, Player player2) {
        this.min = min;
        this.max = max;
        this.player1 = player1;
        this.player2 = player2;
        setHiddenNumber(min, max);
    }

    public void setHiddenNumber(int min, int max) {
        this.hiddenNumber = (int) ((Math.random() * (max - min + 1) + min));
    }

    public void play() {
        Player currentPlayer = player1;
        boolean isWin = false;
        while (true) {
            int answer = currentPlayer.nextNumber(min, max);
            if (answer > hiddenNumber) {
                System.out.printf("Число %d больше того, что загадал компьютер\n", answer);
            } else if (answer < hiddenNumber) {
                System.out.printf("Число %d меньше того, что загадал компьютер\n", answer);
            } else {
                break;
            }
            if (currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
            System.out.println();
        }
        System.out.println("Игрок с именем " + currentPlayer.getName() + " победил!");
    }
}
