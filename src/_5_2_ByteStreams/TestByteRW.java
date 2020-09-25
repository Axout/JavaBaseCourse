package _5_2_ByteStreams;

import java.io.*;
import java.util.Arrays;

public class TestByteRW {
    public static void main(String[] args) throws IOException {

        /*
        Задача 1.
        Записать в файл информацию (массив байт, напрмер) и затем побайтово её оттуда же считать.
         */

        // создадим массив байт, который будем записывать и считывать из потока
        byte[] bytes = new byte[]{1,2,3,4,5};
        // в качестве потока будет файл
        OutputStream outputStream = new FileOutputStream(new File("out.txt"));
        // запишем в поток(файл) массив байт
        outputStream.write(bytes);
        // закроем выходной поток
        outputStream.close();

        // теперь считаем из потока (файла)
        InputStream inputStream = new FileInputStream(new File("out.txt"));
        // считаем один байт из потока и выведем в консоль
        System.out.println(inputStream.read());
        // пропустим один байт из потока
        System.out.println("Пропустим один байт");
        inputStream.skip(1);
        // считаем ещё один байт из потока и выведем в консоль
        System.out.println(inputStream.read());
        // выведем остальные байты из потока в консоль
        System.out.println("Выведем оставшиеся байты:");
        int check;
        while ((check = inputStream.read()) >= 0) {
            System.out.println(check);
        }
        // закроем входной поток
        inputStream.close();

        // Задача 1 решена.

        //***************************************************************************//

        /*
        Задача 2.
        Записать в поток информацию не по одному байту, а сразу массивом байт.
        Потом скопировать информацию из входного потока в выходной поток, также массивом.
        Убедиться, что информация была скопирована (вывести в консоль).
         */

        // в новый поток запишем массив байт
        byte[] bytes1 = new byte[]{5,4,3,2,1};
        InputStream inputStream1 = new ByteArrayInputStream(bytes1);

        // подготовим выходной поток, в который СКОПИРУЕМ информацию из входного потока
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();

        // переменные для копирования
        int totalBytesWritten = 0;  // общее количество считанных байтов
        byte[] buf = new byte[2];   // временный буфер
        int blockSize;              // количесво прочитанных байт за один цикл

        // КОПИРУЕМ. В цикле вызываем метод read(), передавая туда наш временный буфер
        while ((blockSize = inputStream1.read(buf)) >= 0) {
            // если что-то прочитано, то выводим(записываем) в выходной поток.
            // иначе поток закончился и копирование завершается.
            outputStream1.write(buf, 0, blockSize);
            totalBytesWritten += blockSize;
        }

        // проверим как мы записали в выходной поток
        // для этого достанем информацию из выходного потока в массив
        byte[] newBytes = outputStream1.toByteArray();
        System.out.println("\nСКОПИРОВАННЫЙ массив байт:");
        System.out.println(Arrays.toString(newBytes));

        // Задача 2 решена.
    }
}
