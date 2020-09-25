package _5_3_StreamOfCharacters;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TestReaderWriter {
    public static void main(String[] args) throws IOException {
//        // побайтовый способ записи в файл
//        String text = "Hello world!";
//        byte[] bytes = text.getBytes();
//        OutputStream outputStream = new FileOutputStream(new File("out.txt"));
//        outputStream.write(bytes);
//        outputStream.close();

        //***************************************************

        // запись строки в файл
        List<String> lines = Arrays.asList("Hello world!", "Привет мир!");
        Files.write(Paths.get("out.txt"), lines, StandardCharsets.UTF_8);

        //***************************************************

        // старый способ считывания строк из файла (громоздки)

        // без указания кодировки
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader("out.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) { // возвращает null, когда заканчиваются строки
                System.out.println(line);
            }
        }

        // с указанием кодировки
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream("out.txt"), StandardCharsets.UTF_16))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) { // возвращает null, когда заканчиваются строки
                System.out.println(line);
            }
        }

        //***************************************************

        // новый способ считывания строк из файла с указанием кодировки (компактный)
        try (BufferedReader reader3 = Files.newBufferedReader(
                Paths.get("out.txt"), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader3.readLine()) != null) {
                System.out.println(line);
            }
        }

        //***************************************************

        // если файл небольшой, то можно сразу все строки считать разом
        System.out.println("\nСчитаем все строки сразу:");
        List<String> lines2 = Files.readAllLines(
                Paths.get("out.txt"), StandardCharsets.UTF_8);

        for (String s: lines2) {
            System.out.println(s);
        }

        //***************************************************
    }
}
