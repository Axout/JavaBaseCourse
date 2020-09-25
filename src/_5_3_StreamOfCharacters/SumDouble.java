package _5_3_StreamOfCharacters;

/*
Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех
встреченных в тексте вещественных чисел с точностью до шестого знака после запятой.
Числом считается последовательность символов, отделенная от окружающего текста пробелами
или переводами строк и успешно разбираемая методом Double.parseDouble.
*********************
Sample Input 1:
1 2 3

Sample Output 1:
6.000000
*********************
Sample Input 2:
a1 b2 c3

Sample Output 2:
0.000000
*********************
Sample Input 3:
-1e3
18 .111 11bbb

Sample Output 3:
-981.889000
*********************
 */

import java.util.Scanner;

public class SumDouble {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double dbl = 0;
        while (in.hasNext()) {
            // в третьем тесте вылетает ошибка. Чтобы проигнорировать её, используем try с пустым catch
            try {
                dbl += Double.parseDouble(in.next());
            }
            catch (java.lang.NumberFormatException e){
            }
        }
        System.out.printf("%.6f", dbl);
    }
}