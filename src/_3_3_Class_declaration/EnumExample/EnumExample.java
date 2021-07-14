package _3_3_Class_declaration.EnumExample;

public class EnumExample {
    public static void main(String[] args) {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println( day.ordinal() + " " + day.name());
        }
    }
}
