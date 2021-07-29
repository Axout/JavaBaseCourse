package _4_1_Exception.Task2;

/*
Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод,
вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"),
если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод,
откуда сообщение было залогировано.

При запуске эта программа должна вывести:
null
org.stepic.java.example.Test#main
 */
public class GetClassAndMethod {
    public static void main(String[] args) {
        System.out.println("null");
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
        m1();
    }
    public static String getCallerClassAndMethodName() {
        // Реализация через исключения
        try {
            StackTraceElement element = new Throwable().getStackTrace()[2];
            return element.getClassName() + "#" + element.getMethodName();
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    
//    public static String getCallerClassAndMethodName() {
//        // Реализация через потоки
//        /*
//        Любой код в Java выполняется обязательно в каком-то потоке.
//        При помощи Thread.currentThread() получаем ссылку на текущий поток.
//        Затем при помощи getStackTrace() получаем весь стек вызовов или stack trace.
//        В результате получаем мы массив StackTraceElement[]. Каждый StackTraceElement содержит информацию так нужную нам.
//        Первое — это имя класса, из которого делался или делается вызов. Второе — это имя метода, из которого делается вызов.
//         */
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        if (stackTraceElements.length > 3) {
//            StackTraceElement element = stackTraceElements[3];
//            return element.getClassName() + "#" + element.getMethodName();
//        }
//        else return null;
//    }
    public static void anotherMethod() {
        System.out.println("...main");
        System.out.println(getCallerClassAndMethodName());
    }
    public static void m1() {
        System.out.println("...main");
        System.out.println(getCallerClassAndMethodName());
        m2();
    }
    public static void m2() {
        System.out.println("...m1");
        System.out.println(getCallerClassAndMethodName());
        m3();
    }
    public static void m3() {
        System.out.println("...m2");
        System.out.println(getCallerClassAndMethodName());
    }
}
