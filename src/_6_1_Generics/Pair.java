package _6_1_Generics;

import java.util.NoSuchElementException;
import java.util.Objects;

/*
Реализуйте generic-класс Pair, похожий на Optional,
но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.

Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of().
Конструктор должен быть закрытым (private).

С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:

Pair<Integer, String> pair = Pair.of(1, "hello");
Integer i = pair.getFirst(); // 1
String s = pair.getSecond(); // "hello"

Pair<Integer, String> pair2 = Pair.of(1, "hello");
boolean mustBeTrue = pair.equals(pair2); // true!
boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

Справочная:
1. про хешкод и иквалс:
https://habr.com/ru/post/168195/
 */
public class Pair<T, R> {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

        System.out.println("i = " + i);
        System.out.println("s = " + s);
        System.out.println("mustBeTrue = " + mustBeTrue);
        System.out.println("mustAlsoBeTrue = " + mustAlsoBeTrue);
    }

    private final T value1 ;
    private final R value2 ;

    private Pair (T value1, R value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getFirst() {
        if ( value1 == null ) {
            throw new NoSuchElementException("No value present ");
        }
        return value1;
    }
    public R getSecond() {
        if ( value2 == null ) {
            throw new NoSuchElementException("No value present ");
        }
        return value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(value1, pair.value1) &&
                Objects.equals(value2, pair.value2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2);
    }

    public static Pair of(Object value1, Object value2) {
        return new Pair(value1, value2);
    }
}
