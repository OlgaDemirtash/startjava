import java.util.Scanner;

public class Player {

    private String name;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int nextNumber(int min, int max) {
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
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод");
                continue;
            }
        }
    
    }
}

