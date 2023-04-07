public class IfElseStatementTheme {
    public static void main(String[] args) {
        //1. Перевод псевдокода на язык Java
        System.out.println("1. Перевод псевдокода на язык Java\n");
        int age = 25;
        boolean isMaleSex = true;
        float height = 1.7f;

        if (age > 20) {
            System.out.println("    Возраст: > 20");
        } else {
            System.out.println("    Возраст: < 20");
        }
        if (!isMaleSex) {
            System.out.println("    Пол: женский");
        } else {
            System.out.println("    Пол: мужской");
        }
        if (height < 1.80) {
            System.out.println("    Рост: < 1.8 м");
        } else {
            System.out.println("    Рост: > 1.8 м");
        }
        char capitalLetter = "Bob".charAt(0);
        if (capitalLetter == 'M') {
            System.out.println("    Первая буква имени: M");
        } else if (capitalLetter == 'I') {
            System.out.println("    Первая бука имени: I");
        } else {
            System.out.println("    Первая буква имени " + capitalLetter);
        }

        //2. Поиск max и min числа
        System.out.println("\n2. Поиск max и min числа\n");
        int num1 = 344;
        int num2 = 345;
        if (num1 > num2) {
            System.out.println("    Число 1 (" + num1 + ") - максимальное");
            System.out.println("    Число 2 (" + num2 + ") - минимальное");
        } else if (num1 < num2) {
            System.out.println("    Число 1 (" + num1 + ") - минимальное");
            System.out.println("    Число 2 (" + num2 + ") - максимальное");
        } else {
            System.out.println("    Число 1 (" + num1  + 
                    ") и число 2 (" + num2 + ") равны");
        }

        //3. Проверка числа
        System.out.println("\n3. Проверка числа\n");
        int num = 8;
        System.out.println("    Исходное число: " + num);
        if (num == 0) {
            System.out.println("    Число равно 0");
        } else {
            System.out.print("    Число является ");
            if (num > 0) {
                System.out.print("положительным, ");
            } else {
                System.out.print("отрицательным, ");
            }
            if (num % 2 == 0) {
                System.out.println("четным.");
            } else {
                System.out.println("нечетным.");
            }
        }

        //4. Поиск одинаковых цифр в числах
        System.out.println("\n4. Поиск одинаковых цифр в числах\n");
        num1 = 786;
        num2 = 186;
        int hundreds1 = num1 / 100;
        int tens1 = num1 % 100 / 10;
        int ones1 = num1 % 10;
        int hundreds2 = num2 / 100;
        int tens2 = num2 % 100 / 10;
        int ones2 = num2 % 10;

        System.out.println("    Число 1: " + num1);
        System.out.println("    Число 2: " + num2);

        if (num1 != num2) {
            if (ones1 == ones2 || tens1 == tens2 || hundreds1 == hundreds2) {
                System.out.println("\n    Одинаковые цифры в числах:");
                if (ones1 == ones2) {
                    System.out.println("        1-ый разряд - " + ones1);
                }
                if (tens1 == tens2) {
                    System.out.println("        2-ой разряд - " + tens1);
                }
                if (hundreds1 == hundreds2) {
                    System.out.println("        3-ий разряд - " + hundreds1);
                }
            } else {
                System.out.println("\n    В исходных числах нет одинаковых цифр");
            } 
        } else {
            System.out.println("\n    Исходные числа равны"); 
        }

        //5.Определение символа по его коду
        System.out.println("\n5.Определение символа по его коду\n");
        char symbol = '\u0057';
        System.out.println("    Исходный символ: " + symbol);
        if (symbol >= '0' && symbol <= '9') {
            System.out.println("        Число ");
        } else if (symbol >= 'A' && symbol <= 'Z') {
            System.out.println("    Большая буква ");
        } else if (symbol >= 'a' && symbol <= 'z') {
            System.out.println("    Маленькая буква ");
        } else { 
            System.out.println("    Другой символ ");
        }

        //6.Подсчет суммы вклада и начисленных банком %
        System.out.println("\n6.Подсчет суммы вклада и начисленных банком %\n");
        float depositSum = 100000;
        float interesRate = 10;
        System.out.println("    Сумма вклада: " + depositSum);
        if (depositSum < 100000) {
            interesRate = 5;
        } else if (depositSum >= 100000 && depositSum < 300000) {
            interesRate = 7;
        } 
        float interesSum = depositSum * interesRate / 100;
        float total = depositSum + interesSum;
        System.out.println("    Начисленный %: " + interesSum);
        System.out.println("    Итоговая сумма с %: " + total);

        //7.Определение оценки по предметам
        System.out.println("\n7.Определение оценки по предметам\n");
        int histRate = 59;
        int histPoints = 5;
        if (histRate <= 60) {
            histPoints = 2;
        } else if (histRate > 60 && histRate <= 73) {
            histPoints = 3;
        } else if (histRate > 73 && histRate <= 91) {
            histPoints = 4;
        } 
        int progRate = 91;
        int progPoints = 5;
        if (progRate <= 60) {
            progPoints = 2;
        } else if (progRate > 60 && progRate <= 73) {
            progPoints = 3;
        } else if (progRate > 73 && progRate <= 91) {
            progPoints = 4;
        } 
        System.out.println("    Оценки по предметам:");
        System.out.println("        история - " + histPoints);
        System.out.println("        программирование - " + progPoints);
        System.out.println("\n    Средний балл: " + ((float) histPoints + progPoints) / 2);
        System.out.println("    Средний %: " +  ((float) histRate + progRate) / 2);

        //8.Расчет прибыли за год
        System.out.println("\n8.Расчет прибыли за год\n");
        int rent = 5000;
        int soldGoods = 13000;
        int goodsCost = 9000;
        int profit = (soldGoods - goodsCost - rent) * 12;
        System.out.print("    Прибыль за год: ");
        if (profit > 0) { 
            System.out.print( "+" + profit + " руб."); 
        } else {
            System.out.println(profit + " руб."); 
        }
        //9.Подсчет количества банкнот
        System.out.println("\n9.Подсчет количества банкнот\n");
        int needSum = 5674444;
        int totalHundreds = 100;
        int totalTens = 5;
        int totalOnes = 50;
        boolean isEnough = true;
        int outHundreds = needSum / 100;
        int outTens = needSum % 100 / 10;
        int outOnes = needSum % 10;
        
        if (needSum > (totalHundreds*100 + totalTens*10 + totalOnes)) { 
            System.out.println("    В банкомате недостаточно средств для выдачи");
        }
        else {
            System.out.println("    В банкомате следующие номиналы: \n" + 
                    "       " + totalHundreds + " банкнот номиналом 100 USD\n" + 
                    "       " + totalTens + " банкнот номиналом 10 USD\n" + 
                    "       " + totalOnes +" банкнот номиналом 1 USD");
            System.out.println("\n    Требуется выдать сумму " + needSum + " USD: \n" + 
                    "       " + outHundreds + " банкнот номиналом 100\n" +
                    "       " + outTens + " банкнот номиналом 10\n"  +
                    "       " + outOnes + " банкнот номиналом 1");
            if (outHundreds > totalHundreds) { 
                outTens += (outHundreds - totalHundreds) * 10;
                outHundreds = totalHundreds;
            }
            if (outTens > totalTens) {
                outOnes += (outTens - totalTens) * 10;
                outTens = totalTens;
            }
            System.out.println("\n    Будет выдано: ");
            if (outHundreds != 0) { 
                System.out.println("        " + outHundreds + " банкнот номиналом 100");
            }
            if (outTens != 0) { 
                System.out.println("        " + outTens + " банкнот номиналом 10");
            }
            System.out.println("        " + outOnes + " банкнот номиналом 1");
        }
    }
}

