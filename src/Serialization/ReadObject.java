package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args){
        // Здесь обрабатывается сразу два исключения:
        // 1. Отсутствие файла
        // 2. Отсутствие класса Person у считывающей стороны
        try {
            FileInputStream fis = new FileInputStream("people.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // у метода readObject() возвращаемое значение типа Object. Для этого делаем даункастинг
            Person person1 = (Person) ois.readObject();
            Person person2 = (Person) ois.readObject();
            System.out.println(person1.toString());
            System.out.println(person2.toString());
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
