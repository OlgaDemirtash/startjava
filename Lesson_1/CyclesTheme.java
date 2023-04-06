public class CyclesTheme {
    public static void main(String[] args) {

        //1. Подсчет суммы четных и нечетных чисел
        System.out.println("1. Подсчет суммы четных и нечетных чисел\n");
        int sumX = 0;
        int sumY = 0;
        int start = -10;
        int end = 21;
        int num = start;
        do {
            if (num % 2 == 0) {
                sumX++;
            } 
            else {
                sumY++;
            }
            num++;
        } while ( num >= start && num <= end);
        System.out.println("    В промежутке [" + start + ", " + end +"] сумма четных чисел = " +
                sumX + ", а нечетных = " + sumY);

        //2. Вывод чисел в интервале (min и max) в порядке убывания
        System.out.println("\n2. Вывод чисел в интервале (min и max) в порядке убывания\n");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int max;
        int min;
        if (num1 > num2 && num1  > num3) {
            max = num1;
            if (num2 > num3) {
                min = num3;
            } else {    
                min = num2;
            }
        } else if (num1 > num2 && num1 < num3 ) {
            max = num3;
            min = num2;
        } else {
            max = num2; 
            min = num1; 
        }
        System.out.print("\t(" + max + "," + min + ")\t");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }
        System.out.println("");

        //3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n3. Вывод реверсивного числа и суммы его цифр\n");
        int digit1 = 0;
        int digit2 = 0;
        int digit3 = 0;
        int digit4 = 0;
        num = 1234;
        int k = 1000;
        while (k >= 1) {
            if (k == 1000) {
                digit1 = num / k;
            } else if ( k == 100) {
                digit2 = num / k;
            } else if (k == 10) {
                digit3 = num / k;
            } else if (k == 1) {
                digit4 = num;
            }
            num %= k;
            k /= 10;
        }
        System.out.println("\t" + digit4 + digit3 + digit2 + digit1);
        System.out.println("\tСумма: " + (digit4 + digit3 + digit2 + digit1));

        //4. Вывод чисел на консоль в несколько строк
        System.out.println("\n4. Вывод чисел на консоль в несколько строк\n");
        start = 1;
        end = 24;
        int stop = 0;
        System.out.print("\t");
        for (int i = start; i < end; i += 2) {
            System.out.printf("%3d", i);
            ++stop;
            if (stop == 5) {
                System.out.print("\n\t");
                stop = 0;
            }
        }
        if (stop != 0) { 
            stop = 5 - stop;
            for (int i = 1; i <= stop; i++) {
                System.out.printf("%3d", 0);
            }
        System.out.println("");
        }

        //5. Проверка количества двоек на четность/нечетность
        System.out.println("\n5. Проверка количества двоек на четность/нечетность\n");
        num = 3242592;
        int remainder = num % 10;
        int numInteger = num / 10;
        int counter = 0;
        while (remainder != 0) {
            if (remainder == 2) {
                ++counter;
            }
            remainder = numInteger % 10;
            numInteger /= 10;
        }
        if (counter % 2 == 0) {
            System.out.printf("\tЧисло %d содержит %d (%s) количество двоек\n", num, counter, "четное");
        } else {
            System.out.printf("\tЧисло %d содержит %d (%s) количество двоек\n", num, counter, "нечетное");
        }
        System.out.println("");

        //6. Отображение фигур в консоли
        System.out.println("\n6. Отображение фигур в консоли\n");
        char asterisk = '*';
        char  hash = '#';
        char dollar = '$';

        for (int i = 0; i < 5; i++ ) {
            for (int j = 0; j < 10; j++) {
                System.out.print(asterisk);
            } 
            System.out.println("");
        }

        System.out.println("");
        int lines;
        int positions;
        int linePositions = positions = lines = 5;
        while (lines > 0) {
            while (positions > 0) {
                System.out.print(hash);
                --positions;
            }
            System.out.println("");
            --lines;
            --linePositions;
            positions = linePositions;
        }

        System.out.println("");
        lines = positions= linePositions = 1;
        do { 
            linePositions = positions;
            do {
                System.out.print(dollar); 
                --linePositions;
            } while (linePositions > 0);
            if (lines < 3) {
                ++positions;
            } else if (lines >= 3) {
                --positions;
            }
            ++lines;
            System.out.println("");
        } while (lines <= 5);

        //7. Отображение ASCII-символов
        System.out.println("\n7. Отображение ASCII-символов\n");

        for (int i = 33; i <= 48; i += 2) {
            if (i == 33) {
                System.out.printf("%5s\t%5s\n", "Dec", "Char");
            }
            System.out.printf("%5d\t%5c\n",(int) i,(char) i);
        }
        for (int i = 96; i <= 122; i += 2) {
            System.out.printf("%5d\t%5c\n",(int) i,(char) i);
        }

        //8. Проверка, является ли число палиндромом
        System.out.println("\n8. Проверка, является ли число палиндромом\n");
        int numInteger1;
        int numInteger2;
        int remainder1;
        int remainder2;
        num = numInteger1 = numInteger2 = remainder2 = 1234321; 
        int ones = 0;
        int equals = 0;

        numInteger1 /= 10;
        int factor = 1;
        while (numInteger1 > 0) {
            numInteger1 /= 10;
            factor *= 10;
        }
        numInteger1 = num;
        do { 
            remainder1 = numInteger1 % 10;
            numInteger1 = numInteger1 / 10;
            numInteger2 = remainder2 / factor;
            remainder2 = remainder2 % factor;
            if (remainder1 == numInteger2) {
                equals++;
            }
            factor /= 10;
            ones++;
        }
        while (numInteger1 > 0);

        if (equals == ones ) {
            System.out.printf("\tЧисло %d является палиндромом\n", num);
        } else {
            System.out.printf("\tЧисло %d не является палиндромом\n", num);
        }

        //9. Определение, является ли число счастливым
        System.out.println("\n9. Определение, является ли число счастливым\n");
        int sum1 = 0;
        int sum2 = 0;
        num = numInteger1 =  534912;

        while (numInteger1 > 0) {
            remainder1 = numInteger1 % 10;
            numInteger1 /= 10;
            ++positions;
            if (positions <= 3) {
                sum1 += remainder1;
            } else {
                sum2 += remainder1;
            }
        }
        numInteger1 = num;
        System.out.println("\tСумма цифр " + numInteger1 / 1000 + " = " + sum2);
        System.out.println("\tСумма цифр " + numInteger1 % 1000 + " = " + sum1);
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
            System.out.println("");
        }
    }
}