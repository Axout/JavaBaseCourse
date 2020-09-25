package _2_1_Primitive_data_type;

/*
Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
Допустимая погрешность – 0.0001 (1E-4)
Можно использовать класс Math и его методы.

Sample Input:   0.1 0.2 0.3
Sample Output:  true
 */
public class DoubleExpression {

    public static final double eps = 0.0001;

    public static void main(String[] args) {
        System.out.println("Sample: 0.1 0.2 0.3");
        System.out.println(doubleExpression(0.1, 0.2, 0.3));
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return  Math.abs(c - (a+b)) < eps;
    }
}
