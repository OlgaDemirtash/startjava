package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayTheme {
    public static void main(String[] args) {
        arrayValuesReverse();
        arrayValuesProd();
        arrayValuesDelete();
        arrayValuesStareReverseOutput();
        generateUniqueNumbers();
        notBlankLinesCopy();
    }

    private static void arrayValuesReverse() {
        //1. Реверс значений массива
        System.out.println("1. Реверс значений массива\n");
        int[] intNums = {5, 3, 7, 2, 1, 4, 6};
        for (int intNum : intNums) {
            System.out.print(intNum + " ");
        }
        int len = intNums.length - 1;
        for (int i = 0; i < intNums.length / 2; i++) {
            int num = intNums[i];
            intNums[i] = intNums[len - i];
            intNums[len - i] = num;
        }
        System.out.println();
        for (int intNum : intNums) {
            System.out.print(intNum + " ");
        }
        System.out.print("\n\n");
    }

    private static void arrayValuesProd() {
        //2. Вывод произведения элементов массива
        System.out.println("2. Вывод произведения элементов массива\n");
        int[] intNums = new int[10];
        int prod = 1;
        int len = intNums.length - 1;
        for (int i = 0; i <= len; i++) {
            intNums[i] = i;
        }
        for (int i = 1; i < len; i++) {
            prod *= intNums[i];
            System.out.print((i != len - 1) ? (intNums[i] + " * ") : intNums[i] + " = " + prod);
        }
        System.out.println("\n" + intNums[0] + " " + intNums[9]);
        System.out.println();
    }

    private static void arrayValuesDelete() {
        //3. Удаление элементов массива
        System.out.println("3. Удаление элементов массива\n");
        float[] floatNums = new float[15];
        int nullValues = 0;
        for (int i = 0; i < floatNums.length; i++) {
            floatNums[i] = (float) Math.random();
        }
        System.out.println();
        printArray(floatNums, 6);
        int len = floatNums.length;
        float tmpFloatNums = floatNums[len / 2];
        for (int i = 0; i < len; i++) {
            if (floatNums[i] > tmpFloatNums) {
                floatNums[i] = 0;
                nullValues++;
            }
        }
        printArray(floatNums, 6);
        System.out.println("\nКоличество обнуленных ячеек: " + nullValues);
        System.out.println();
    }

    private static void arrayValuesStareReverseOutput() {
        //4. Вывод элементов массива лесенкой в обратном порядке
        System.out.println("4. Вывод элементов массива лесенкой в обратном порядке\n");
        char[] charArr = new char[26];
        int j = 0;
        for (int i = 65; i < 91; i++) {
            charArr[j] = (char) i;
            j++;
        }
        printArray(charArr);
        System.out.println();
    }

    public static void generateUniqueNumbers() {
        //5. Генерация уникальных чисел
        System.out.println("5. Генерация уникальных чисел\n");
        int min = 60;
        int max = 100;
        int[] intArr = new int[30];

        for (int i = 0; i < intArr.length; i++) {
            while (true) {
                int num = (int) ((Math.random() * (max - min)) + min);
                if (isNumExistInArray(num, intArr)) {
                    continue;
                } else {
                    intArr[i] = num;
                    break;
                }
            }
        }
        Arrays.sort(intArr);
        printArray(intArr, 10);
        System.out.println();
    }

    private static void notBlankLinesCopy() {
        //6. Копирование не пустых строк
        System.out.println("6. Копирование не пустых строк *\n");
        int newStrArrLength = 0;
        String[] strArr = {"    ", "AA", "", "BBB", "CC", "D", "    ", "E", "FF", "G", ""};
//      String[] strArr = {"    ", ""};
//      String[] strArr = {"    ", "AA", "", "E", "FF", "G", ""};
//      String[] strArr = {"FF", "G", ""};
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].trim() != " " && strArr[i].trim() != "") {
                newStrArrLength++;
            }
        }
        printArray(strArr);

        String[] newStrArr = new String[newStrArrLength];
        int notNullCount = 0;
        int nullCount = 0;
        int startPos = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].isBlank()) {
                notNullCount++;
            } else {
                if (notNullCount != 0) {
                    System.arraycopy(strArr, i - notNullCount, newStrArr, startPos, notNullCount);
                    startPos += notNullCount;
                    nullCount = 0;
                    notNullCount = 0;
                }
                nullCount++;
            }
        }
        printArray(newStrArr);
    }

    private static void printArray(float[] floatArr, int lineBreak) {
        for (int i = 0; i < floatArr.length; i++) {
            System.out.printf("%5.3f ", floatArr[i]);
            if (i == lineBreak && i != 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void printArray(char[] charArr) {
        int len = charArr.length - 1;
        for (int i = 0; i <= len; i++) {
            for (int j = len; j > len - 1 - i; j--) {
                System.out.print(charArr[j]);
            }
            System.out.println();
        }
    }

    public static boolean isNumExistInArray(int num, int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            if (num == intArr[i]) {
                return true;
            }
        }
        return false;
    }

    public static void printArray(int[] intArr, int lineBreak) {
        for (int i = 0; i < intArr.length; i++) {
            System.out.printf("%3d ", intArr[i]);
            if (i == lineBreak - 1 && i != 0) {
                System.out.println();
                lineBreak += lineBreak;
            }
        }
        System.out.println();
    }

    public static void printArray(String[] strArr) {
        System.out.print("{");
        for (int i = 0; i < strArr.length; i++) {
            System.out.printf("%3s%c", strArr[i], (i == strArr.length - 1) ? 0 : ',');
        }
        System.out.println("}\n");
    }
}





 

