package _5_3_StreamOfCharacters;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
Пример
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
 */

public class ReadAsString {
    public static void main(String[] args) throws IOException {
        InputStream inputByteArray = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println(readAsString(inputByteArray, StandardCharsets.US_ASCII));
    }
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // если входные поток вводится одной строкой:
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
//        return reader.readLine();

        // если входной поток прерывается enterом
        // поток байт заварачиваем в поток символов с указанной кодировкой
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuilder stringBuilder = new StringBuilder();
        int value;
        // когда заканчивается входной поток read() возвращает -1
        while ((value = reader.read()) != -1 ) {
            stringBuilder.append((char) value);
        }
        return stringBuilder.toString();
    }
}
