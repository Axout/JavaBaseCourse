package _6_4_Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Здесь собрано несколько примеров создания и применения стримов.
 */
public class L1_ExampleSteam {
    public static <T> void main(String[] args) {
        // Пример 1. Создание, редактирование и суммирование всех элементов стрима
        int sum = IntStream.iterate(1, n -> n+1)    // создаёт бесконечную алгебраическую последовательность
                .filter(n -> n % 5 == 0 && n % 2 != 0)  // возвращает только те элементы последовательности, которые делятся на 5 без остатка и одновременно делятся на 2 с остатком
                .limit(10)                              // возвращает первые 10 элементов последовательности
                .map(n -> n * n)                        // возводит в квадрат все элементы последовательности
                .sum();                                 // возвращает сумму всех элементов последовательности
                // .sum() - тернальный оператор - запускает выполнение всех вышеуказанных действий
        System.out.println(sum);

        // Пример 2. Создание стрима строк и нахождение минимального и максимального элемента по кол-ву символов.
        Stream<String> stream = Stream.of("a","ccc","bb","dddd");
        Optional<String> min = stream.min(Comparator.comparing(String::length, Integer::compare));
        System.out.println(min);
        Stream<String> stream2 = Stream.of("a","ccc","bb","dddd");
        Optional<String> max = stream2.max(Comparator.comparing(String::length, Integer::compare));
        System.out.println(max);

        // Пример 3. Создание пустого стрима.
        //Stream<Integer> stream3 = (Stream<Integer>) Stream.of((T) null);

        // Пример 4. Создание методом перечисления стрима чисел, превращение в список и вывод в консоль.
        Stream<Integer> stream3 = Stream.of(1,2,3,4,5,6,7,8);
        Stream<Integer> stream4 = Stream.of(1,2,3,4,5,6,7,8);
        if (stream3.anyMatch(Objects::isNull)) {
            System.out.println("Стрим пустой");
        }
        else {
            //stream3.forEach(System.out::println);
            List<Integer> list = stream4.collect(Collectors.toList());
            System.out.println(list);
        }
    }
}
