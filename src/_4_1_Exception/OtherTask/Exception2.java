package _4_1_Exception.OtherTask;

import java.util.Scanner;

/*
Создание своих собственных исключений
Нужно создать исключение, которое обрабатывало бы ошибки scanner
 */
public class Exception2 {
    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = Integer.parseInt(scanner.nextLine());

            if (x != 0 ) {
                throw new ScannerException("Пользователь ввёл что-то кроме нуля");
            }
        }
    }
}
