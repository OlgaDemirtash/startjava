package com.startjava.lesson_1.base;

public class VariablesTheme {
    public static void main(String[] args) {
        // 1. Вывод характеристик компьютера
        System.out.println("1. Вывод характеристик компьютера\n");
        char cpuType = 'I';
        byte cpuCoreNum = 2;
        short cpuThreadNum = 4;
        int totalRam = 16;
        long ramHz = 1866000000;
        float maxCpuFrequency = 3.8f;
        double baseCpuFrequency = 2.4;
        boolean isVideoCardIntegrated = true;

        System.out.println("    Тип процессора: " + cpuType);
        System.out.println("    Количество ядер процессора: " + cpuCoreNum);
        System.out.println("    Количество потоков процессора: " + cpuThreadNum);
        System.out.println("    Максимальная тактовая частота, Ггц: " + maxCpuFrequency);
        System.out.println("    Базовая тактовая частота, Ггц: " + baseCpuFrequency);
        System.out.println("    Встроенная видео карта: " + isVideoCardIntegrated);
        System.out.println("    Оперативная память, Гбайт: " + totalRam);
        System.out.println("    Частота оперативной памяти, Гц " + ramHz);
        
        //2. Расчет стоимости товара со скидкой
        System.out.println("\n2. Расчет стоимости товара со скидкой\n");
        int penPrice = 100;
        int bookPrice = 200;
        int discount = 11;
        int totalPrice = penPrice + bookPrice;

        System.out.println("    Стоимость товаров, руб.: " + totalPrice);
        double discountSum = discount * totalPrice / 100;
        System.out.println("    Скидка, руб: " + discountSum);
        double discountPrice = totalPrice - discountSum;
        System.out.println("    Стоимость товаров со скидкой, руб: " + discountPrice);

        //3. Вывод слова JAVA
        System.out.println("\n3. Вывод слова JAVA\n");
        System.out.println("       J    a  v     v  a    ");
        System.out.println("       J   a a  v   v  a a   ");
        System.out.println("    J  J  aaaaa  V V  aaaaa  ");
        System.out.println("     JJ  a     a  V  a     a ");

        //4. Вывод min и max значений целых числовых типов
        System.out.println("\n4. Вывод min и max значений целых числовых типов:\n");
        byte byteNum = Byte.MAX_VALUE;
        short shortNum = Short.MAX_VALUE;
        int intNum = Integer.MAX_VALUE;
        long longNum = Long.MAX_VALUE;

        System.out.println("    byte:");
        System.out.println("        " + byteNum);
        System.out.println("        " + ++byteNum);
        System.out.println("        " + --byteNum);
        System.out.println("\n    short:");
        System.out.println("        " + shortNum);
        System.out.println("        " + ++shortNum);
        System.out.println("        " + --shortNum);
        System.out.println("\n    int:");
        System.out.println("        " + intNum);
        System.out.println("        " + ++intNum);
        System.out.println("        " + --intNum);
        System.out.println("\n    long:");
        System.out.println("        " + longNum);
        System.out.println("        " + ++longNum);
        System.out.println("        " + --longNum);

        //5. Перестановка значений переменных
        System.out.println("\n5. Перестановка значений переменных\n");
        int num1 = 2;
        int num2 = 5;
        int num3 = num1;

        System.out.println("    Перестановка с помощью третьей переменной:");
        System.out.println("        Исходные значения:" + num1 + "," + num2);
        num1 = num2;
        num2 = num3;
        System.out.println("        Результат:" + num1 + "," + num2);
        System.out.println("\n    Перестановка с помощью арифметических операций:");
        System.out.println("        Исходные значения:" + num1 + "," + num2);
        num1 += num2;
        num2 = num1 - num2;
        num1 -= num2;
        System.out.println("        Результат:" + num1 + "," + num2);
        System.out.println("\n    Перестановка с помощью побитовой операции:");
        System.out.println("        Исходные значения:" + num1 + "," + num2);
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;
        System.out.println("        Результат:" + num1 + "," + num2);

        //6. Вывод символов и их кодов
        System.out.println("\n6. Вывод символов и их кодов\n");
        char hash = '#';
        char ampersand = '&';
        char at = '@';
        char caret = '^';
        char underscore = '_';

        System.out.println("    " + (int) hash + " " + hash); 
        System.out.println("    " + (int) ampersand + " " + ampersand); 
        System.out.println("    " + (int) at + " " + at); 
        System.out.println("    " + (int) caret + " " + caret); 
        System.out.println("    " + (int) underscore + " " + underscore); 

        //7. Вывод в консоль ASCII-арт Дюка
        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка\n");
        char slash = '/';
        char backslash = '\\';
        char leftBracket = '(';
        char rightBracket = ')';

        System.out.println("        " + slash + backslash);
        System.out.println("       " + slash + "  " + backslash);
        System.out.println("      " + slash + underscore + leftBracket + 
                " " + rightBracket + backslash);
        System.out.println("     " + slash + "      " + backslash);
        System.out.println("    " + slash + underscore + underscore + 
                underscore + underscore + slash + backslash + underscore + underscore + backslash);

        //8. Вывод количества сотен, десятков и единиц числа
        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа\n");
        int num = 123;
        int hundreds = num / 100;
        int tens = num % 100 / 10;
        int ones = num % 10;
        int sum = hundreds + tens + ones;
        int prod = hundreds * tens * ones;

        System.out.println("    Число " + num + " содержит:");
        System.out.println("    " + hundreds + " сотен");
        System.out.println("    " + tens + " десятков");
        System.out.println("    " + ones + " единиц");
        System.out.println("    Сумма его цифр = " + sum);
        System.out.println("    Произведение = " + prod);

        //9. Вывод времени
        System.out.println("\n9. Вывод времени\n");
        int inputSeconds = 86399;
        int hours = inputSeconds / 3600;
        int minutes = inputSeconds / 60 % 60;
        int seconds = inputSeconds % 60;
        System.out.println("    " + inputSeconds + " секунд это: " + 
                hours + ":" + minutes + ":" + seconds);
    }
}
