package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayTheme {
    public static void main(String[] args) {
        reverseArrayValues();
        multiplyArrayValues();
        deleteArrayValues();
        reverseOutputArrayValues();
        generateUniqueNumbersArray();
        copyNotBlankValues();
    }

    //1. Реверс значений массива
    private static void reverseArrayValues() {

        System.out.println("1. Реверс значений массива\n");
        int[] intsArr = {5, 3, 7, 2, 1, 4, 6};
        for (int intNum : intsArr) {
            System.out.print(intNum + " ");
        }
        int len = intsArr.length - 1;
        for (int i = 0; i < intsArr.length / 2; i++) {
            int num = intsArr[i];
            intsArr[i] = intsArr[len];
            intsArr[len] = num;
            len--;
        }
        System.out.println();
        for (int intNum : intsArr) {
            System.out.print(intNum + " ");
        }
        System.out.print("\n\n");
    }

    //2. Вывод произведения элементов массива
    private static void multiplyArrayValues() {
        System.out.println("2. Вывод произведения элементов массива\n");
        int[] digitsArr = new int[10];
        int prod = 1;
        int len = digitsArr.length - 1;
        for (int i = 0; i <= len; i++) {
            digitsArr[i] = i;
        }
        for (int i = 1; i < len; i++) {
            prod *= digitsArr[i];
            System.out.print(digitsArr[i] + ((i != len - 1) ? (" * ") : " = " + prod));
        }
        System.out.println("\n" + digitsArr[0] + " " + digitsArr[9]);
        System.out.println();
    }
    
    //3. Удаление элементов массива
    private static void deleteArrayValues() {
        System.out.println("3. Удаление элементов массива\n");
        float[] floatArr = new float[15];
        int nullValuesCounter = 0;
        int len = floatArr.length;
        for (int i = 0; i < len; i++) {
            floatArr[i] = (float) Math.random();
        }
        System.out.println();
        printArray(floatArr, 6);

        float middleArrayElementValue = floatArr[len / 2];
        for (int i = 0; i < len; i++) {
            if (floatArr[i] > middleArrayElementValue) {
                floatArr[i] = 0;
                nullValuesCounter++;
            }
        }
        printArray(floatArr, 6);
        System.out.println("\nКоличество обнуленных ячеек: " + nullValuesCounter);
        System.out.println();
    }

    //4. Вывод элементов массива лесенкой в обратном порядке
    private static void reverseOutputArrayValues() {
        System.out.println("4. Вывод элементов массива лесенкой в обратном порядке\n");
        char[] capitalEngLetters = new char[26];
        int len = capitalEngLetters.length;
        for (int i = 0; i < len; i++) {
            capitalEngLetters[i] = (char) ('A' + i);
        }
        printArray(capitalEngLetters);
        System.out.println();
    }
    //5. Генерация уникальных чисел
    public static void generateUniqueNumbersArray() {
        System.out.println("5. Генерация уникальных чисел\n");
        int min = 60;
        int max = 100;
        int[] intArr = new int[30];

        for (int i = 0; i < intArr.length; i++) {
            while (true) {
                int num = (int) ((Math.random() * (max - min)) + min);
                if (!isNumExistInArray(num, intArr)) {
                    intArr[i] = num;
                    break;
                }
            }
        }
        Arrays.sort(intArr);
        printArray(intArr, 10);
        System.out.println();
    }
    //6. Копирование не пустых строк
    private static void copyNotBlankValues() {
        System.out.println("6. Копирование не пустых строк *\n");
        int notBlankStrArrLength = 0;
        String[] strArr = {"    ", "AA", "", "BBB", "CC", "D", "    ", "E", "FF", "G", ""};
//      String[] strArr = {"    ", ""};
//      String[] strArr = {"    ", "AA", "", "E", "FF", "G", ""};
//      String[] strArr = {"FF", "G", ""};
        for (String str : strArr) {
            if (!str.isBlank()) {
                notBlankStrArrLength++;
            }
        }
        printArray(strArr);

        String[] notBlankStrArr = new String[notBlankStrArrLength];
        int notBlankCount = 0;
        int startPos = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].isBlank()) {
                notBlankCount++;
            } else {
                if (notBlankCount != 0) {
                    System.arraycopy(strArr, i - notBlankCount, notBlankStrArr, startPos, notBlankCount);
                    startPos += notBlankCount;
                    notBlankCount = 0;
                }
            }
        }
        printArray(notBlankStrArr);
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
        for (int j : intArr) {
            if (num == j) {
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





 

