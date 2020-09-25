package _5_2_ByteStreams;

/*
Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
Контрольная сумма данных вычисляется по следующему алгоритму:
Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
C_n+1 = rotateLeft(C_n) xor b_n+1,
где C_n — контрольная сумма первых n байт данных,
rotateLeft — циклический сдвиг бит числа на один бит влево
(чтобы не изобретать велосипед, используйте Integer.rotateLeft)
b_n — n-ный байт данных.
Поскольку метод не открывал данный InputStream, то и закрывать его он не должен.
Выброшенное из методов InputStream исключение должно выбрасываться из метода.

Пример
На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01.
В качестве контрольной суммы должно быть возвращено число 71.
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class CheckSumOfStream {
    public static void main(String[] args) throws IOException {
        byte[] arrByte = new byte[] {0x33, 0x45, 0x01};
        InputStream stream = new ByteArrayInputStream(arrByte);
        System.out.println("Input data:");
        System.out.println(Arrays.toString(arrByte));
        System.out.println("Checksum:");
        System.out.println(checkSumOfStream(stream));
    }
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int i;
        int checkSum = 0;
        while ((i = inputStream.read()) != -1) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ i;
            //System.out.println(checkSum);
        }
        return checkSum;
    }
}
