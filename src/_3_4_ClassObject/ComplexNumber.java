package _3_4_ClassObject;

/*
Порядок создания метода equals:
1) С помощью == проверить, ссылаются ли ссылки на один объект?
2) С помощью instanceof проверить, имеет ли аргумент корректный тип?
3) Привести аргумент к корректному типу. Поскольку эта операция идёт после instanceof, то она гарантирована успешна.
4) Для каждого важного поля класса убедиться, что значение этого поля в аргументе соответствует полю данного объекта.

для примитивных полей, тип которых — не float и не double, для сравнения используйте оператор ==;
для полей, которые представляют собой ссылки на объекты, рекурсивно вызывайте метод equals;
для полей float воспользуйтесь статическим методом Float.compare(float, float),
а для полей double — Double.compare(double, double) (если равны, вернётся int 0)
*/

import java.util.Objects;

public class ComplexNumber {
    public static void main(String[] args) {
        ComplexNumber number1 = new ComplexNumber(3.14, 1.123);
        ComplexNumber number2 = new ComplexNumber(3.14, 1.124);

        System.out.println("number1\n" + number1);
        System.out.println("number2\n" + number2);

        System.out.println("\nThe result of the equals method is " + number1.equals(number2));

        System.out.println("The result of hashCode() for number 1 is " + number1.hashCode());
        System.out.println("The result of hashCode() for number 2 is " + number2.hashCode());
    }

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }



    @Override
    public String toString() {
        return "re: " + re + "\nim: " + im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof ComplexNumber))
            return false;

        ComplexNumber number = (ComplexNumber) o;
        return Double.compare(re, number.re) == 0 && Double.compare(im, number.im) == 0;
    }

    /*
    для сокращения числа коллизий:
    при вычислении хэш-кода умножать промежуточный результат на нечетное простое число.
    Например: 17, 29, 31, 37...
     */
    @Override
    public int hashCode() {
        int result = 17;
        long longRe = Double.doubleToLongBits(re);
        result = 37 * result + (int)(longRe - (longRe >>> 32));
        long longIm = Double.doubleToLongBits(im);
        result = 37 * result + (int)(longIm - (longIm >>> 32));
        return result;
    }

    // equals() и hashCode() сгенерированные средой:

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ComplexNumber number = (ComplexNumber) o;
//        return Double.compare(number.re, re) == 0 && Double.compare(number.im, im) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(re, im);
//    }
}
