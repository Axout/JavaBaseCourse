package _6_1_Generics;

import java.util.Arrays;
import java.util.List;

/*
Дженерики позволяют типизировать методы.
Данной возможности в tutorial от Oracle посвящен отдельный раздел: "Generic Methods".

Из данного tutorial важно запомнить про синтаксис:
    1) включает список типизированных параметров внутри угловых скобок;
    2) список типизированных параметров идёт до возвращаемого метода.

Задача:
Создать класс с типизированными методами, записать туда разные объекты и вывести всё в консоль.
 */
public class GenericsMethod {
    public static class Util {
        public static <T> T getValue(Object obj) {
            return (T) obj;
        }

        public static <T> void myPrintln(List<T> list) {
            for (Object object: list) {
                T data = Util.getValue(object);
                System.out.println(data);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Author", "book");
        Util.myPrintln(list);

        List<Integer> list1 = Arrays.asList(1,2,3);
        Util.myPrintln(list1);
    }
}