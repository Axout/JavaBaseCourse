package LeetCode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _7_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(revers(123));
    }
    public static int revers(int x) {
        String str = "" + x;
        System.out.println(str);
        String[] strings = str.split("");

        Integer[] array = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        List<Integer> list = Arrays.asList(array);
        Collections.reverse(list);
        int result = Integer.parseInt(list.toString());
        return result;
    }
}
