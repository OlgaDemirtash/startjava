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
        printArray(intsArr);
        int len = intsArr.length;
        for (int i = 0; i < len / 2; i++) {
            int num = intsArr[i];
            len--;
            intsArr[i] = intsArr[len];
            intsArr[len] = num;

        }
        printArray(intsArr);
        System.out.println();
    }

    //2. Вывод произведения элементов массива
    private static void multiplyArrayValues() {
        System.out.println("2. Вывод произведения элементов массива\n");
        int[] multipliers = new int[10];
        int len = multipliers.length;
        for (int i = 0; i < len; i++) {
            multipliers[i] = i;
        }
        int prod = 1;
        for (int i = 1; i < len - 1; i++) {
            prod *= multipliers[i];
            System.out.print(multipliers[i] + ((i < len - 2) ? " * " : " = " + prod));
        }
        System.out.println("\n" + multipliers[0] + " " + multipliers[9]);
        System.out.println();
    }

    //3. Удаление элементов массива
    private static void deleteArrayValues() {
        System.out.println("3. Удаление элементов массива\n");
        float[] floatArr = new float[15];

        int len = floatArr.length;
        for (int i = 0; i < len; i++) {
            floatArr[i] = (float) Math.random();
        }
        printArray(floatArr, 7);
        int numberZeroedCells = 0;
        float middleCellValue = floatArr[len / 2];
        for (int i = 0; i < len; i++) {
            if (floatArr[i] > middleCellValue) {
                floatArr[i] = 0;
                numberZeroedCells++;
            }
        }
        System.out.println();
        printArray(floatArr, 7);
        System.out.println("\nКоличество обнуленных ячеек: " + numberZeroedCells);
        System.out.println();
    }

    //4. Вывод элементов массива лесенкой в обратном порядке
    private static void reverseOutputArrayValues() {
        System.out.println("4. Вывод элементов массива лесенкой в обратном порядке\n");
        char[] alphabet = new char[26];
        int len = alphabet.length;
        for (int i = 0; i < len; i++) {
            alphabet[i] = (char) ('A' + i);
        }
        printArray(alphabet);
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
        int countNonBlankStrings = 0;
        String[] srcStrings = {"    ", "AA", "", "BBB", "CC", "D", "    ", "E", "FF", "G", ""};
//      String[] srcStrings = {"    ", ""};
//      String[] srcStrings = {"    ", "AA", "", "E", "FF", "G", ""};
//      String[] srcStrings = {"FF", "G", ""};
        for (String str : srcStrings) {
            if (!str.isBlank()) {
                countNonBlankStrings++;
            }
        }
        printArray(srcStrings);

        String[] destStrings = new String[countNonBlankStrings];
        int notBlankCount = 0;
        int startPos = 0;
        for (int i = 0; i < srcStrings.length; i++) {
            if (!srcStrings[i].isBlank()) {
                notBlankCount++;
            } else {
                if (notBlankCount != 0) {
                    System.arraycopy(srcStrings, i - notBlankCount, destStrings, startPos, notBlankCount);
                    startPos += notBlankCount;
                    notBlankCount = 0;
                }
            }
        }
        printArray(destStrings);
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

    public static void printArray(int[] intArr) {
        for (int intNum : intArr) {
            System.out.print(intNum + " ");
        }
        System.out.println();
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
            System.out.printf("%3s%s", strArr[i], (i == strArr.length - 1) ? "" : ", ");
        }
        System.out.println("}\n");
    }
}





 

