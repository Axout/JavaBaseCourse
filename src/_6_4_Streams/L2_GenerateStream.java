package _6_4_Streams;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Способы получения стрима
 */
public class L2_GenerateStream {
    public static void main(String[] args) {
//        // 1. Stream из коллекции
//        Set<String> vocabulary = ...;
//        Stream<String> stream1 = vocabulary.stream();
//
//        // !!! Примеры 2 и 3 нужно закрывать .close(); и удобно использовать в блоке try с ресурсами !!!
//        // 2. Stream form BufferedReader
//        BufferedReader reader = ...;
//        Stream<String> stream2 = reader.lines();
//
//        // 3. Stream из директории на диске
//        Path path = ...;
//        Stream<Path> stream3 = Files.list(path); // вернёт содержимое директории на один уровень
//        Stream<Path> stream4 = Files.walk(path); // рекурсивно обойдёт и поддиректории тоже

        // 4. Stream from string
        IntStream chars = "hello".chars(); // получим символы строки

        // Динамические способы получения стримов
        // 5. С помощью supplier
        DoubleStream randomNumbers = DoubleStream.generate(Math::random);
        // 6. С помощью итерирования функции
        IntStream integers = IntStream.iterate(0, n -> n + 1);
        // 7. Получение диапазона чисел
        IntStream smallIntegers = IntStream.range(0, 100); // не включая правую границу 0..99
        IntStream smallIntegers2 = IntStream.rangeClosed(0, 100); // включая правую границу 0..100

        // 8. Конкатенация двух других стримов
        IntStream combinedStream = IntStream.concat(smallIntegers, smallIntegers2);

        // 9. Пустой стрим
        IntStream empty = IntStream.empty();

        // 10. Stream from array
        double[] array = new double[]{0.1, 0.2, 0.3, 0.4, 0.5};
        DoubleStream streamFromArray = Arrays.stream(array);

        // 11. Явное перечисление всех элементов стрима
        IntStream streamOfElement = IntStream.of(0, 1, 2, 3, 4, 5, 6, 7);
    }
}
