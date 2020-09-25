class Main {
    public static void main(String[] args) {
        Human h1 = new Human("Sergei", 20);
        System.out.println(h1);
        h1.setName("Nikolai");
        h1.setAge(34);
        System.out.println(h1);
        Human.description = "Благодаря модификатору static можно обращаться к полю класса без создания объекта\n" +
                "И это поле будет одинаковым для всех объектов";
        System.out.println(Human.description);
        Human h2 = new Human("Pety", 18);
        System.out.println(h2);
        Human.printCountNumberOfPeople();
    }
}

class Human {
    private  String name;
    private  int age;
    private static int countPeople;

    public static String description;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        countPeople++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void printCountNumberOfPeople() {
        System.out.println("Number of people is " + countPeople);
        System.out.println("Статический метод также можно вызывать без создания объекта");
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}