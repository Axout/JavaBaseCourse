package _3_5_Abstract_classes;

import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

/*
Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале по формуле левых прямоугольников.
Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator.
Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.
Интервал интегрирования задается его конечными точками a и b, причем a <= b.
Для получения достаточно точного результата используйте шаг сетки не больше 10^(-6).

Пример. Вызов
integrate(x -> 1, 0, 10)
должен возвращать значение 10.
 */
public class Integral {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите интервалы интегрирования:\nа = ");
        double a = in.nextDouble();
        System.out.print("b = ");
        double b = in.nextDouble();
        System.out.println("*******************");
        System.out.printf("a = %.1f; b = %.1f\n", a, b);
        System.out.printf("Результат: integral = %.1f\n\n", integrate(x -> 1, a, b));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double h = 0.000001;        // шаг сетки
        double n = (b-a)/h;   // кол-во шагов
        double integral = 0;
        for (int i = 0; i < n; i++) {
            // Интеграл - сумма площадей прямоугольников (площадь = значение функции * шаг сетки)
            integral = integral + (f.applyAsDouble(a+h*i))*h;
        }
        return integral;
    }
}
