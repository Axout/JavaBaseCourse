package _6_4_Streams;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком,
заданным Comparator'ом.
Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
minMaxConsumer.accept(min, max);
Если стрим не содержит элементов, то вызовите
minMaxConsumer.accept(null, null);
 */

public class FindMinMax {
    public static void main(String[] args) {
        // вызов требуемой функции
        findMinMax(
                Stream.of(9, 6, 8, 3, 19, 16, 18, 13),
                Integer::compareTo,
                (v1, v2) -> System.out.println("max = " + v2 + "\nmin = " + v1)
        );
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.isEmpty())
            minMaxConsumer.accept(null, null);
        else
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
    }
}
