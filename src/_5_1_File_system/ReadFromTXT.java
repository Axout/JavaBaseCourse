package _5_1_File_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
Считывание данных из файла
 */

public class ReadFromTXT {
    public static void main(String[] args) throws FileNotFoundException {
        // СЧИТЫВАНИЕ СТРОК ИЗ ФАЙЛА

        // на разных ОС путь описывается по разному - разные разделители папок.
        // Чтобы код работал везде, поручим разделитель определять джаве.
        // File.separator - константа, которая и есть разделитель данной ОС
        String separator = File.separator;
        String path = "C:"+separator+"Users"+separator+"rako-"+separator+"IdeaProjects"+separator+
                "JavaBaseCourse"+separator+"src"+separator+"_5_1_File_system"+separator+"test.txt";
        File file = new File(path);

        // считывание потока данных с файла.
        // Если файл не будет найден, тогда будет выброшено исключение FileNotFoundException
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();

        //***************************************************************************************************

        // СЧИТЫВАНИЕ ЧИСЕЛ ИЗ ФАЙЛА

        String path2 = "C:"+separator+"Users"+separator+"rako-"+separator+"IdeaProjects"+separator+
                "JavaBaseCourse"+separator+"src"+separator+"_5_1_File_system"+separator+"test2.txt";
        File file2 = new File(path2);
        Scanner scanner2 = new Scanner(file2);
        String str = scanner2.nextLine();
        scanner2.close();
        String[] arrStr = str.split(" ");
        int[] arrNumber = new int[arrStr.length];
        int count = 0;
        for (String s : arrStr) {
            arrNumber[count++] = Integer.parseInt(s);
        }
        System.out.println(Arrays.toString(arrNumber));

        //***************************************************************************************************

        // СЧИТЫВАНИЕ ИЗ ФАЙЛА В КОРНЕ

        File file3 = new File("fileInCore.txt");
        Scanner scanner3 = new Scanner(file3);
        String string3 = scanner3.nextLine();
        System.out.println(string3);
    }
}