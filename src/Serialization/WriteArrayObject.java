package Serialization;

import java.io.*;

public class WriteArrayObject {
    public static void main(String[] args) {
        // создаём массив объектов
        Person[] people = {new Person(3, "Egor"),
                new Person(4,"Pavel"), new Person(5, "Alexander")};

        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // записываем массив объектов people как один единый объект
            oos.writeObject(people);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
