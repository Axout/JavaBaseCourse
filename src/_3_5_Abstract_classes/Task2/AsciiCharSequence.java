package _3_5_Abstract_classes.Task2;

/*
Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт)
в массиве байт. По сравнению с классом String, хранящим каждый символ как char,
AsciiCharSequence будет занимать в два раза меньше памяти.
Класс AsciiCharSequence должен:
    - реализовывать интерфейс java.lang.CharSequence;
    - иметь конструктор, принимающий массив байт;
    - определять методы length(), charAt(), subSequence() и toString().
Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры,
поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254
 */

public class AsciiCharSequence implements CharSequence {
    private int length;
    private byte [] arrByte;

    public AsciiCharSequence(byte[] arrByte) {
        this.length = arrByte.length;
        this.arrByte = arrByte;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int index) {
        return (char) arrByte[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte[] subArrByte = new byte[end - start];
        int n = 0;
        for (int i = start; i < end; i++) {
            subArrByte[n] = arrByte[i];
            n++;
        }
        return new AsciiCharSequence(subArrByte);
    }

    @Override
    public String toString() {
        return new String(arrByte);
    }

    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
        //проверка на нарушение инкапсуляции private поля
        // в конструкторе нужно инициализировать массив байтов при помощи метода clone ()
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }
}
