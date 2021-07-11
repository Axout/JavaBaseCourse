package _2_3_Arrays_and_Strings;

import java.util.Arrays;
import java.util.Scanner;

/*
Программа осуществляет проверку - является ли строка палиндромом или нет?
Метод palindrome(str); решает задачу через массив.
Метод palindrome2(str); решает задачу лаконично.
 */

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Please, enter your string:");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println("Is your string a palindrome?");

        String result = palindrome(str);
        System.out.println(result);

        String result2 = palindrome2(str);
        System.out.println(result2);
    }

    public static String palindrome(String str) {
        char[] arrayChar = str.toCharArray();
        System.out.println(Arrays.toString(arrayChar)); // правильный вывод массива

        int lengthArray = arrayChar.length;
        int k = lengthArray / 2;
        for (int i = 0; i < k; i++) {
            if (arrayChar[i] != arrayChar[lengthArray - 1 - i])
                return "No";
        }
        return "Yes";
    }

    public static String palindrome2(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return str.equals(stringBuilder.reverse().toString()) ? "Yes" : "No";
    }
}
