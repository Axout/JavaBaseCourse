package _3_5_Abstract_classes.Lambda;

/*
Необходимо написать программу, измеряющую время работы различных вычислений.
Код замера времени напишем один раз - в классе Timer - и замет переиспользовать.
Метод measureTime() принимает экземпляр класса BigDecimalPower, реализующий интерфейс Runnable.
Класс BigDecimalPower описывает действие, время вычисления которого необходимо измерить.
 */

import java.math.BigDecimal;

public class Main{
//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        long time = timer.measureTime(new BigDecimalPower());
//        System.out.println(time);
//    }
//
//    private static class BigDecimalPower implements Runnable {
//        @Override
//        public void run() { new BigDecimal("1234567").pow(100000); }
//    }

//*******************************************************************************

/*
Тоже самое, но только задекларируем класс прямо в теле метода.
Объявим анонимный класс, реализующий интерфейс Runnable() и сразу же создаётся его экземпляр.
*/

//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        long time = timer.measureTime(new Runnable() {
//            @Override
//            public void run() {
//                new BigDecimal("1234567").pow(100000);
//            }
//        });
//        System.out.println(time);
//    }

//*******************************************************************************

/*
До Java 7 больше ничего нельзя было сделать. Но в Java 8 добавили лямбда-выражения.
Лямбда-выражение начинается с круглых скобок, в которых указываются параметры.
В данном случае, метод run() не предполагает никаких параметров, поэтому скобки пустые.
Параметры указываются без типов, т.к. типу известны компилятору из объявления интерфейса.
После скобок идёт "->", а затем тело лямбда-выражения.
В данном случае, оно состоит у нас из одного единственного выражения. Если что-то сложнее, то нужны фигурные скобки.

Необходимое и достаточное условие для того, чтобы интерфейс можно было инстанцировать при помощи лямбда-выражения:
Интерфейс должен содержать ровно один абстрактный метод (функциональный интерфейс).
 */

    public static void main(String[] args) {
        Timer timer = new Timer();
        long time = timer.measureTime(() -> new BigDecimal("1234567").pow(100000));
        System.out.println(time);
    }
}
