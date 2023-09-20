package step.learning.basics;

import java.io.File;
import java.text.SimpleDateFormat;

public class Dz_1_Files {

    public static void main() {
        File currentDirectory = new File(".");  // "." вказує на поточний каталог
        displayContents(currentDirectory);
    }

    private static void displayContents(File directory) {
        File[] files = directory.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        System.out.println("Mode                 LastWriteTime         Length Name");
        System.out.println("----                 -------------         ------ ----");

        for (File file : files) {
            String date = sdf.format(file.lastModified());
            String name = file.getName();
            String size = file.isFile() ? String.valueOf(file.length()) : "";
            String mode = file.isDirectory() ? "d-----" : "-a----";

            System.out.printf("%-20s %-20s %-10s %s%n", mode, date, size, name);
        }
    }
}