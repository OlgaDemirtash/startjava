public class CyclesTheme {
    public static void main(String[] args) {
        //1. Подсчет суммы четных и нечетных чисел
        System.out.println("1. Подсчет суммы четных и нечетных чисел\n");
        int sumEven = 0;
        int sumOdd = 0;
        int start = -10;
        int end = 21;
        int num = start;
        do {
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
            num++;
        } while (num >= start && num <= end);
        System.out.println("\tВ промежутке [" + start + ", " + end +"] сумма четных чисел = " +
                sumEven + ", а нечетных = " + sumOdd);

        //2. Вывод чисел в интервале (min и max) в порядке убывания
        System.out.println("\n2. Вывод чисел в интервале (min и max) в порядке убывания\n");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int max = num3;
        int min = num3;
        if (num1 > num2 && num1 > num3) {
            max = num1;
        } else if(num2 > num1 && num2 > num3) {
            max = num2;
        }
        if (num1 < num2 && num1 < num3) {
            min = num1;
        } else if (num2 < num1 && num2 < num3) {
            min = num2; 
        }

        System.out.print("\t(" + min + "," + max + ")\t");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        //3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр\n");
        num = 12;
        int sum = 0;
        System.out.printf("\t");
        while (num > 0) {
            int remainder = num % 10;
            num = num / 10;
            System.out.printf("" + remainder);
            sum += remainder;
        }
        System.out.println("\n\tСумма: " + sum);

        //4. Вывод чисел на консоль в несколько строк
        System.out.println("\n4. Вывод чисел на консоль в несколько строк\n");
        start = 1;
        end = 24;
        int count = 0;
        System.out.print("\t");
        for (int i = start; i < end; i += 2) {
            System.out.printf("%3d", i);
            count++;
            if (count == 5) {
                System.out.print("\n\t");
                count = 0;
            }
        }
        if (count != 0) {
            count = 5 - count;
            for (int i = 1; i <= count; i++) {
                System.out.printf("%3d", 0);
            }
        }

        //5. Проверка количества двоек на четность/нечетность
        System.out.println("\n\n5. Проверка количества двоек на четность/нечетность\n");
        num = 3242592;
        int countTwos = 0;
        System.out.printf("\tЧисло %d содержит ", num);
        while (num > 0) {
            if (num % 10 == 2) {
                countTwos++;
            }
            num /= 10;
        }
        if (countTwos % 2 == 0) {
            System.out.printf("%d (%s) количество двоек\n", countTwos, "четное");
        } else {
            System.out.printf("%d (%s) количество двоек\n", countTwos, "нечетное");
        }

        //6. Отображение фигур в консоли
        System.out.println("\n6. Отображение фигур в консоли\n");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            } 
            System.out.println();
        }

        System.out.println();
        int lines = 5;
        int charsPerLine = lines;
        int positions = lines;
        while (lines > 0) {
            while (charsPerLine > 0) {
                System.out.print("#");
                charsPerLine--;
            }
            System.out.println();
            lines--;
            charsPerLine = lines;
        }

        System.out.println();
        int charsCount = 0;
        System.out.println();
        lines = 1;
        charsCount = 1;
        do {
            charsPerLine = charsCount;
            do {
                System.out.print("$");
                charsPerLine --;
            } while (charsPerLine > 0);
            if (lines < 3) {
                charsCount++;
            } else {
                charsCount--;
            }
            lines++;
            System.out.println();
        } while (lines < 6 );

        //7. Отображение ASCII-символов
        System.out.println("\n7. Отображение ASCII-символов\n");
        System.out.printf("%5s\t%5s\n", "Dec", "Char");
        for (int i = 33; i <= 48; i += 2) {
            System.out.printf("%5d\t%5c\n",i,i);
        }
        for (int i = 96; i <= 122; i += 2) {
            System.out.printf("%5d\t%5c\n",i,i);
        }

        //8. Проверка, является ли число палиндромом
        System.out.println("\n8. Проверка, является ли число палиндромом\n");
        num = 1234321;
        num1 = num;
        num2 = 0;
        while (num > 0) {
            int remainder = num % 10;
            num2 = num2 * 10 + remainder;
            num = num / 10;
        }
        if (num1 == num2) {
            System.out.printf("\tЧисло %d является палиндромом\n", num1);
        } else {
            System.out.printf("\tЧисло %d не является палиндромом\n", num2);
        }

        //9. Определение, является ли число счастливым
        System.out.println("\n9. Определение, является ли число счастливым\n");
        int sum1 = 0;
        int sum2 = 0;
        int copyNum;
        num = 534912;
        int digitCounter = 0;
        copyNum = num;
        while (copyNum > 0) {
            int remainder = copyNum % 10;
            copyNum /= 10;
            digitCounter++;
            if (digitCounter <= 3) {
                sum1 += remainder;
            } else {
                sum2 += remainder;
            }
        }
        System.out.println("\tСумма цифр " + num / 1000 + " = " + sum2);
        System.out.println("\tСумма цифр " + num % 1000 + " = " + sum1);
        if (sum1 == sum2) {
            System.out.printf("\n\tЧисло %d является счастливым\n", num);
        } else {
            System.out.printf("\n\tЧисло %d не является счастливым\n", num);
        }

        //10. Вывод таблицы умножения Пифагора
        System.out.println("\n10. Вывод таблицы умножения Пифагора\n");
        System.out.printf("       ТАБЛИЦА ПИФАГОРА\n");
        System.out.printf("%4s%3d%3d%3d%3d%3d%3d%3d%3d\n","|",2,3,4,5,6,7,8,9);
        System.out.printf("%3s\n","-----------------------------");
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%3d", i * j);
                if (j == 1) {
                    System.out.printf("|");
                }
            }
            System.out.println();
        }
    }
}