package _6_2_Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
затем удалит из них все числа, стоящие на четных позициях,
и затем выведет получившуюся последовательность в обратном порядке в System.out.
Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

!!! Помним, что в IDEA конец ввода обозначается нажатием Ctrl+D !!!

Sample Input:
1 2 3 4 5 6 7

Sample Output:
6 4 2
 */
class DeleteEven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> arrayList = new ArrayList<>();

        int n = 0;
        while (in.hasNext()) {
            int val = in.nextInt();
            if ((n++ % 2) != 0)
                arrayList.add(val); // нечётные позиции добавляем
        }
        in.close();

        // выводим в обратном порядке
        for (int i = arrayList.size()-1; i >= 0; i--)
            System.out.print(arrayList.get(i) + " ");
        // тоже иначе:
//        Collections.reverse(evenNumbers);
//        arrayList.forEach(o -> System.out.print(o + " "));
    }
}
