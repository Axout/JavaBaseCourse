package _2_1_Primitive_data_type;

/*
Показаны правила преобразования типов, автоматическое расширение и неявное преобразование.
 */

public class TypeConversion {
    public static void main(String[] args) {
        // 1. При приведение более ёмкого целого типа к менее ёмкому типу лишние старшие биты просто отбрасываются
        int intValue = 1024;
        byte byteValue = (byte) intValue;

        System.out.println("Правило 1:");
        System.out.println("int:\t" + intValue);
        System.out.println("int in binary:\t" + Integer.toBinaryString(intValue));
        System.out.println("byte:\t" + byteValue);

        // 2. При приведении числа с плавающей точной к целому числу дробная часть просто отбрасывается
        // (математическое округление не происходит)
        double pi = 3.64;
        int intFromDouble = (int) pi;

        System.out.println("\nПравило 2:");
        System.out.println("double:\t" + pi);
        System.out.println("int:\t" + intFromDouble);

        // 3. Слишком большое по модулю вещественное число, при приведении к целому,
        // превращается в максимальное по модулю представимое целое число того же знака.
        // Т.е. в примере ниже, после приведения, переменная будет равна максимальному значению int.
        float largeFloat = 1e20f;
        int intFromLargeFloat = (int) largeFloat;

        System.out.println("\nПравило 3:");
        System.out.println("float:\t" + largeFloat);
        System.out.println("int:\t" + intFromLargeFloat);

        // 4. Слишком большой double при приведение к float превращается в бесконечность того же знака.
        double largeDouble = -1e100;
        float floatFromLargeDouble = (float) largeDouble;

        System.out.println("\nПравило 4:");
        System.out.println("double:\t" + largeDouble);
        System.out.println("float:\t" + floatFromLargeDouble);

        // 5. Автоматическое расширение.
        // Когда java применяет какой-нибудь бинарный арифметический или побитовый оператор к двум операндам,
        // то первым делом операнды приводятся к одному типу - это наз. автоматическое расширение.
        // Общий тип выбирается по следующим правилам:

        // 5.1. Если один из операндов double, то оба приводятся к double
        double doubleValue = 1d + 1f;

        // 5.2. Иначе, если один из операторов имеет тип float, то оба приводятся к float.
        float floatValue = 1f * 1;

        // 5.3. Иначе, если один из операндов имеет тип long, то оба приводятся к long.
        long longValue = 1L - '0';

        // 5.4. И иначе, оба приводятся к Int !!!
        // Из этого следует, что если складываются два значения byte, то оба сперва приводятся к типу int.
        // И присвоить результат обратно в переменную типа byte, без явного приведения, уже не получиться.
        // Зато, получив от компилятора такую ошибку, невольно задумаешься о возможном переполнении.
        byte a = 127;
        byte b = 1;
        byte c = (byte) (a + b);

        System.out.println("\nПравило 5:");
        System.out.println("byte a = 127");
        System.out.println("byte b = 1");
        System.out.println("c = a + b = " + c);

        // 6. Неявное преобразование.
        // Следовательно, из правила 5.4 вытекает следующее:
        byte d = 1;
        d += 3; // это эквивалентно: d = (byte) (d + 3);

        byte e = -1; // 11111111
        e >>>= 7; // вроде бы должно быть так: 00000001
        // Но на самом деле, это эквивалентно: e = (byte) (e >>> 7);
        // Т.е. сначала е расшириться до int и будет равно 11111111111111111111111111111111 (32-е единицы).
        // А только потом будет сдвиг в право и обратное приведение к байту.
        // И результат будет такой: 11111111

        System.out.println("\nПравило 6:");
        System.out.println(e);
    }
}
