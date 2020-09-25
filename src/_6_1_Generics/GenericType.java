package _6_1_Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Для демонстрации того, для чего нужны дженерики решим следующую задачу:
Создадим список объектов типа String и выведем список в консоль.
Без дженериков пришлось бы делать downcast, так как List хранит список объектов типа Object.
После Java 7 можно не указывать второй раз тип в угловых скобках.

Правило #1: всегда использовать diamond синтаксис, если мы используем типизированные типы.
В противном случае мы рискуем пропустить, где у нас используется raw type.

Правило #2: Если класс типизирован, всегда указывать тип в дженерике.
 */

public class GenericType {
    public static void main(String[] args) {
        //////////// До Java 5 (до появления дженериков) //////////
        List animals = new ArrayList();
        animals.add("dog");
        animals.add("cat");
        animals.add("frog");
        animals.add(1);

        // необходим downcasting (List хранит список объектов типа Object)
        String animal0 = (String) animals.get(0);
        String animal1 = (String) animals.get(1);
        String animal2 = (String) animals.get(2);

        System.out.println(animal0);
        System.out.println(animal1);
        System.out.println(animal2);

        // а без дженериков участок кода ниже скомпилируется и выдаст Runtime ошибку (ClassCastException)!
        //String animal3 = (String) animals.get(3);
        //System.out.println(animal3);

        //////////// До Java 7 (после появления дженериков) //////////
        List<String> animals2 = new ArrayList<String>(Arrays.asList("dog", "cat", "frog"));

        // downcast уже не нужен
        String animal00 = animals2.get(0);
        String animal01 = animals2.get(1);
        String animal02 = animals2.get(2);

        System.out.println(animal00);
        System.out.println(animal01);
        System.out.println(animal02);

        // Теперь попытка добавить в список объект нестрингового типа вызовет ошибку компиляции
        //animals2.add(1);

        //////////// После Java 7 //////////
        List<String> animals3 = new ArrayList<>(Arrays.asList("dog", "cat", "frog"));
        System.out.println(animals3);

        List<Integer> numbers = Arrays.asList(1,2,3);
        System.out.println(numbers);
    }
}
