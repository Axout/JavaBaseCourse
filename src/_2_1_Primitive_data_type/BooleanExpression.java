package _2_1_Primitive_data_type;

/*
Реализуйте метод, возвращающий true, если среди четырех его аргументов ровно два истинны (любые).
Во всех остальных случаях метод должен возвращать false.
Попробуйте составить формулу с использованием булевых операторов.
Если не получается, вернитесь к этому заданию после просмотра степов про условные операторы и циклы.
При записи сложных выражений рекомендуется использовать скобки, чтобы не запутаться в порядке применения операторов.
Совет тем, у кого не проходит какой-то из тестов. В данной задаче возможно всего 16 комбинаций значений входных параметров.
Их можно выписать на бумажку, посчитать для них правильные ответы и сравнить с тем, что выдает ваше решение.
Попробуйте самостоятельно проделать это, найти ошибку и исправить решение.

Sample Input 1:     false false false false
Sample Output 1:    false

Sample Input 2:     true true true true
Sample Output 2:    false

Sample Input 3:     false false true true
Sample Output 3:    true
 */
public class BooleanExpression {
    public static void main(String[] args) {
        System.out.println("Sample 1:");
        System.out.println(booleanExpression(false, false, false, false));

        System.out.println("Sample 2:");
        System.out.println(booleanExpression(true, true, true, true));

        System.out.println("Sample 3:");
        System.out.println(booleanExpression(false, false, true, true));
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a | b | c | d) && !(a & b & c & d) && !(a ^ b ^ c ^ d);
    }
}
