package _5_1_File_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
Записть текста в файл.txt
 */
public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("fileInCore.txt");
        PrintWriter pw = new PrintWriter(file);

        pw.println("New line1");
        pw.println("New line2");

        pw.close();
    }
}
