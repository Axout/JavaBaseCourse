package _4_1_Exception.Task1;

/*
Реализуйте метод sqrt(), вычисляющий квадратный корень числа.
В отличие от Math.sqrt(), это метод при передаче отрицательного параметра должен бросать исключение
java.lang.IllegalArgumentExceptionс сообщением "Expected non-negative number, got ?",
где вместо вопросика будет подставлено фактически переданное в метод число.
 */
public class ExcSqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(-9));
    }
    public static double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("Expected non-negative number, got " + x);
        else return Math.sqrt(x);
    }
}
