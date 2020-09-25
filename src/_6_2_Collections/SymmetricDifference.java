package _6_2_Collections;

/*
Реализуйте метод, вычисляющий симметрическую разность двух множеств.
Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
Пример:
Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.

Sample Input:
1 2 3
0 1 2

Sample Output:
0 3
 */

import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strA = in.nextLine();
        String strB = in.nextLine();
        String[] stringsA = strA.split(" ");
        String[] stringsB = strB.split(" ");
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (String s: stringsA)
            set1.add(Integer.parseInt(s));
        for (String s: stringsB)
            set2.add(Integer.parseInt(s));

        System.out.println(symmetricDifference(set1, set2));
    }

    /*
    <?> - wildcard - означает, что в данный метод можено передать множество (список, массив...) любых объектов (объекты класса Object)
    <? extends T> - означает, что мы хотим передавать в данный метод множество (список, массив...) объектов класса T и
    множество объектов классов наследуемых от класса T
    <? super T> - означает, что мы хотим передать в данный метод множестов (список, массив...) объектов классов родителей
    класса T
     */
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> setResult = new HashSet<>();
        Set<T> set1Copy = new HashSet<>(set1);
        Set<T> set2Copy = new HashSet<>(set2);

        set1Copy.removeAll(set2);
        set2Copy.removeAll(set1);
        setResult.addAll(set1Copy);
        setResult.addAll(set2Copy);

        return setResult;
    }
}
