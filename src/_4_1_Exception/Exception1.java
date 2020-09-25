package _4_1_Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Обработка ошибки: файл не найден
 */

public class Exception1 {
    public static void main(String[] args) {
        File file = new File("asd.txt");

        // возможная ошибка: файл может быть не найден
        // чтобы программа далее корректно продолжила работать, используем try-catch
        // если в блоке try на какой-нибудь строчке вылетит ошибка,
        // тогда выполнение программы на этой строчке закончится
        // и начнётся с блока catch
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            System.out.println("Файл потеряли...");
        }

    }
}
