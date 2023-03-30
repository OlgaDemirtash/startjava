public class VariablesTheme
{
    public static void main(String[] args) {
        // 1. Вывод характеристик компьютера
        char procType = 'I';
        byte procCoreNum = 2;
        short procThreadNum = 4;
        int totalRam = 16;
        long ramHz = 1866000000;
        float maxProcFrequency = 3.8f;
        double baseProcFrequency = 2.4;
        boolean isVideoCardIntegrated = true;
        
        System.out.println("1. Вывод характеристик компьютера\n");
        System.out.println("    Тип процессора: " + procType);
        System.out.println("    Количество ядер процессора: " + procCoreNum);
        System.out.println("    Количество потоков процессора: " + procThreadNum);
        System.out.println("    Максимальная тактовая частота, Ггц: " + maxProcFrequency);
        System.out.println("    Базовая тактовая частота, Ггц: " + baseProcFrequency);
        System.out.println("    Встроенная видео карта: " + isVideoCardIntegrated);
        System.out.println("    Оперативная память, Гбайт: " + totalRam);
        System.out.println("    Частота оперативной памяти, Гц " + ramHz);

        //2. Расчет стоимости товара со скидкой
        int penPrice = 100;
        int bookPrice = 200;
        int discount = 11;
        double discSum;
        double discPrice;

        System.out.println("\n2. Расчет стоимости товара со скидкой\n");
        int totalPrice = penPrice + bookPrice;
        System.out.println("    Стоимость товаров, руб.: " + totalPrice);
        discSum = discount * totalPrice / 100;
        System.out.println("    Скидка, руб: " + discSum);
        discPrice = totalPrice - discSum;
        System.out.println("    Стоимость товаров со скидкой, руб: " + discPrice);

        //3. Вывод слова JAVA
        System.out.println("\n3. Вывод слова JAVA\n");
        System.out.println("    " + "   J    a  v     v  a    ");
        System.out.println("    " + "   J   a a  v   v  a a   ");
        System.out.println("    " + "J  J  aaaaa  V V  aaaaa  ");
        System.out.println("    " + " JJ  a     a  V  a     a ");

        //4. Вывод min и max значений целых числовых типов
        byte byteNum = Byte.MAX_VALUE;
        short shortNum = Short.MAX_VALUE;
        int intNum = Integer.MAX_VALUE;
        long longNum = Long.MAX_VALUE;

        System.out.println("\n4. Вывод min и max значений целых числовых типов:\n");
        System.out.println("    byte:");
        System.out.println("        " + byteNum);
        System.out.println("        " + byteNum++);
        System.out.println("        " + byteNum--);
        System.out.println("\n    short:");
        System.out.println("        " + shortNum);
        System.out.println("        " + shortNum++);
        System.out.println("        " + shortNum--);
        System.out.println("\n    int:");
        System.out.println("        " + intNum);
        System.out.println("        " + intNum++);
        System.out.println("        " + intNum--);
        System.out.println("\n    long:");
        System.out.println("        " + intNum);
        System.out.println("        " + intNum++);
        System.out.println("        " + intNum--);

        //5. Перестановка значений переменных
        int num1 = 2;
        int num2 = 5;
        int num3;

        System.out.println("\n5. Перестановка значений переменных\n");
        System.out.println("    Перестановка с помощью третьей переменной:");
        System.out.println("        Исходные значения:" + num1 + "," + num2);
        num3 = num1;
        num1 = num2;
        num2 = num3;
        System.out.println("        Результат:" + num1 + "," + num2);
        System.out.println("\n    Перестановка с помощью арифметических операций:");
        System.out.println("        Исходные значения:" + num1 + "," + num2);
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println("        Результат:" + num1 + "," + num2);
        System.out.println("\n    Перестановка с помощью побитовой операции:");
        System.out.println("        Исходные значения:" + num1 + "," + num2);
        num1 = num1 ^ num2;
        num2 = num2 ^ num1;
        num1 = num1 ^ num2;
        System.out.println("        Результат:" + num1 + "," + num2);

        //6. Вывод символов и их кодов
        char symb1 = 35;
        char symb2 = 38;
        char symb3 = 64;
        char symb4 = 94;
        char symb5 = 95;

        System.out.println("\n6. Вывод символов и их кодов\n");
        System.out.println("    " + (int) symb1 + " " + symb1); 
        System.out.println("    " + (int) symb2 + " " + symb2); 
        System.out.println("    " + (int) symb3 + " " + symb3); 
        System.out.println("    " + (int) symb4 + " " + symb4); 
        System.out.println("    " + (int) symb5 + " " + symb5); 

        //7. Вывод в консоль ASCII-арт Дюка
        char s1 = '/';
        char s2 = '\\';
        char s3 = '_';
        char s4 = '(';
        char s5 = ')';

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка\n");
        System.out.println("    " + "    "+s1+s2);
        System.out.println("    " + "   "+s1+"  "+s2);
        System.out.println("    " + "  "+s1+s3+s4+" "+s5+s2);
        System.out.println("    " + " "+s1+"      "+s2);
        System.out.println("    " + ""+s1+s3+s3+s3+s3+s1+s2+s3+s3+s2);

        //8. Вывод количества сотен, десятков и единиц числа
        int num =123;
        int numH;
        int numT;
        int numU;
        int sum = 0;
        int numS;
        int prod = 0;
        int numP;

        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа\n");
        System.out.println("    " + "Число " + num + " содержит:");
        numH = num / 100;
        System.out.println("    " + numH + " сотен");
        numT = num % 100 / 10;
        System.out.println("    " + numT + " десятков");
        numU = num % 100 % 10;
        System.out.println("    " + numU + " единиц");
        numS = num;
        sum += numS % 10;
        numS /= 10;
        sum += numS % 10;
        numS /= 10;
        sum += numS % 10;
        numS /= 10;
        sum += numS % 10;
        numS /= 10;
        sum += numS % 10;
        numS /= 10;
        sum += numS % 10;
        numS /= 10;
        sum += numS % 10;
        numS /= 10;
        sum += numS % 10;
        numS /= 10;
        sum += numS % 10;
        numS /= 10;
        System.out.println("    " + "Сумма его цифр = " + sum);
        numP = num;
        prod *= numP % 10;
        numP /= 10;
        prod *= numP % 10;
        numP /= 10;
        prod *= numP % 10;
        numP /= 10;
        prod *= numP % 10;
        numP /= 10;
        prod *= numP % 10;
        numP /= 10;
        prod *= numP % 10;
        numP /= 10;
        prod *= numP % 10;
        numP /= 10;
        prod *= numP % 10;
        numP /= 10;
        prod *= numP % 10;
        numP /= 10;
        System.out.println("    " + "Произведение = " + prod);

        //9. Вывод времени
        int inpSeconds = 86399;
        int hours;
        int minutes;
        int seconds;

        System.out.println("\n9. Вывод времени\n");
        hours = inpSeconds / 3600;
        minutes = inpSeconds / 60 % 60;
        seconds = inpSeconds % 60;
        System.out.println("    " + inpSeconds + " секунд это: " + hours + ":" + minutes + ":" + seconds);
    }
}
