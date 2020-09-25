package _5_3_StreamOfCharacters;

import java.io.Reader;
import java.io.StringReader;
import java.util.Locale;
import java.util.Scanner;

/*
Задача изучить класс Scanner.
Например, нужно записать в поток информация в виде строки и считать её, распарсив по типам данных.
 */

public class TestScanner {
    public static void main(String[] args) {
        Reader reader = new StringReader("abc|true|1,1e3|-42");

        Scanner scanner = new Scanner(reader)
                .useDelimiter("\\|")    // шаблон разделителя, для нарезания входного потока на токены
                .useLocale(Locale.forLanguageTag("ru"));    // локаль
        // локаль отвечает за региональные настройки и в частности за то, как форматируются числа.
        // Например, с каким десятичным разделителем. В данном случае русская локаль.
        // Это позволяет распозновать числа, у которых десятичный разделитель - запятая (1,1e3).

        // считаем токены в соответствие с их типом данных
        String token = scanner.next();
        boolean bool = scanner.nextBoolean();
        double dbl = scanner.nextDouble();
        int integer = scanner.nextInt();

        System.out.println(token);
        System.out.println(bool);
        System.out.println(dbl);
        System.out.println(integer);
    }
}
