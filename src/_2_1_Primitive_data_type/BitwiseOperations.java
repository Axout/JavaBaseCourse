package _2_1_Primitive_data_type;

/*
Демонстрация работы побитовых логических операций над целыми числами
 */

public class BitwiseOperations {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        String format = "|%1$-10s|%2$-10s|%3$-33s|\n";
        System.out.format(format, "Name", "Dec", "Bin");
        System.out.println("----------------------------------");
        System.out.format(format, "a", a, Integer.toBinaryString(a));
        System.out.format(format, "b", b, Integer.toBinaryString(b));
        System.out.format(format, "~a", ~a, Integer.toBinaryString(~a)); // отрицание
        System.out.format(format, "~b", ~b, Integer.toBinaryString(~b)); // отрицание
        System.out.format(format, "a & b", a & b, Integer.toBinaryString(a & b)); // логическое И
        System.out.format(format, "a | b", a | b, Integer.toBinaryString(a | b)); // логическое ИЛИ
        System.out.format(format, "a ^ b", a ^ b, Integer.toBinaryString(a ^ b)); // логическое исключающее ИЛИ
        // арифметический сдвиг вправо, при котором младшие биты теряются, а освободившиеся старшие позиции заполняются знаковым битом
        System.out.format(format, "a >> 1", a >> 1, Integer.toBinaryString(a >> 1));
        // логический сдвиг вправо, при котором освободившиеся позиции заполняются нулями
        System.out.format(format, "a >>> 1", a >>> 1, Integer.toBinaryString(a >>> 1));
        // сдвиг влево, старшие позиции теряются, а младшие заполняются нулями
        System.out.format(format, "a << 1", a << 1, Integer.toBinaryString(a << 1));
    }
}
