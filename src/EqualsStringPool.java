/*
Демонстрация работы == и метода equals
 */

public class EqualsStringPool {
    public static void main(String[] args) {
        Animal animal = new Animal(1);
        Animal animal1 = new Animal(1);
        Animal animal2 = animal1; // присваивание ссылок

        System.out.println("Animal");
        System.out.println(animal == animal1); // false - разные ссылки
        System.out.println(animal.equals(animal1)); // true - но если не переопределить, то будет сравнивать ссылки
        System.out.println(animal2 == animal1); // true - т.к. ссылки одинаковые

        String string = "Hello"; // строка попадает в stringpool
        String string1 = "Hello"; // не происходит создание нового объекта! java ссылает указатель на уже созданный объект

        System.out.println("\nString");
        // НЕправильное сравнение строк!!!
        System.out.println(string == string1); // true - объект один и тот же

        String string2 = new String("world"); // так stringpool не работает
        String string3 = new String("world"); // создаются два разных объекта

        System.out.println(string2 == string3); // false - java создала разные объекты, следовательно и ссылки разные
        // правильное сравнение строк!!!
        System.out.println(string2.equals(string3)); // true - метод equals уже переопрделён в классе String
    }
}

class Animal {
    private int id;

    public Animal(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // быстрое стравнение ссылок (если ссылки равны, то и объекты равны)
        if (o == null || getClass() != o.getClass()) return false;  // проверка на null и быстрое сравнение классов (если классы разные, то и объекты разные)
        Animal animal = (Animal) o; // class down - это нужно поскольку в родительском классе Object метод equals принимает параметр класса Object
        return id == animal.id;     // сравнение по содержанию
    }
}