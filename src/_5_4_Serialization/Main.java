package _5_4_Serialization;

import java.io.*;

/*
Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
Массив байт устроен следующим образом.
Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size).
Далее подряд записано указанное количество объектов типа Animal,
сериализованных при помощи ObjectOutputStream.writeObject(animal).

Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
то метод должен бросить исключение java.lang.IllegalArgumentException.

Причины некорректности могут быть разные.
Попробуйте подать на вход методу разные некорректные данные и посмотрите, какие исключения будут возникать.
Вот их-то и нужно превратить в IllegalArgumentException и выбросить.Если что-то забудете,
то проверяющая система подскажет. Главное не глотать никаких исключений, т.е. не оставлять нигде пустой catch.
 */
public class Main {
    public static void main(String[] args) {
        byte[] data = new byte[]{3, 44,55,66};
        Animal[] animals = deserializeAnimalArray(data);
        System.out.println(animals);
    }

    /*
    В задаче нужно вернуть массив объектов Animal.
    Для начала нужно определить количество объектов в будущем массиве.
    Это число идёт в начале массива байт и записано оно было при помощи ObjectOutputStream.writeInt(size).
    А так как мы не знаем алгоритм десериализации, то первое int-вое число нужно считать с помощью readInt().
    Чтобы применить этот метод нам необходим объект типа ObjectInputStream.
    Но чтобы получить объект типа ObjectInputStream, предватильное массив байт нужно завернуть в ByteArrayInputStream.
    Это конструкция при некорректных входных данных (при некорректном массиве байт) вызовет исключение.
    Поэтому используем конструкцию try-catch.

    После того как мы входные данные (массив байт) поместили в объект ObjectInputStream ois,
    мы считаем количество элементов в массиве ois.readInt(), создадим этот массив и
    в цикле наполним объектами с помощью ois.readObject(), не забыл про приведение типов.
    Всё возвращеам готовый массив объектов Animal.

    Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
    то метод (по требованию условия задачи) бросит исключение java.lang.IllegalArgumentException.
    */
    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {

            Animal[] animals = new Animal[ois.readInt()];

            for (int i = 0; i < animals.length; i++) {
                animals[i] = (Animal) ois.readObject();
            }
            return animals;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
