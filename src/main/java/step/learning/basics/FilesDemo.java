package step.learning.basics;

import java.io.*;

public class FilesDemo {
    public void run(){
        String filename = "test.txt";
        try(OutputStream writer = new FileOutputStream(filename)) {
            writer.write("Hello world".getBytes());
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        StringBuilder sb = new StringBuilder();
        try (InputStream reader = new FileInputStream(filename)){
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
            System.out.println(sb.toString());
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    public void run2(){
        File dir = new File("./uploads");
        if (dir.exists()){
            if(dir.isDirectory())
            {
                System.out.printf("'%s' already exists%n", dir.getName());
            }
            else{
                System.out.printf("'%s' already exists BUT NOT AS DIRECTORY%n", dir.getName());
            }
        }
        else{
            if (dir.mkdir()){
                System.out.printf("Directory %s created%n", dir.getName());
            }
            else{
                System.out.printf("Directory %s already exists%n", dir.getName());
            }
        }
        File file = new File("./uploads/whitelist.txt");
        if (file.exists()){
            if(dir.isFile())
            {
                System.out.printf("'%s' already exists%n", dir.getName());
            }
            else{
                System.out.printf("'%s' already exists BUT NOT AS FILE%n", dir.getName());
            }
        }
        else{
            try {
                if(file.createNewFile()){
                    System.out.printf("File %s created%n", dir.getName());
                }
                else{
                    System.out.printf("File %s creation error%n", dir.getName());
                }
            }
            catch (IOException ex){
                System.err.println(ex.getMessage());
            }
        }
    }
    public void run1(){
        File dir = new File("./");
        if(dir.exists()){
            System.out.println("Path exists");
        }
        else{
            System.out.println("Path does not exist");
        }
        System.out.printf("Path is %s %n",
                dir.isDirectory() ? "directory" : "file");
        System.out.println(dir.getAbsolutePath());
        for ( String filename : dir.list()){ // dir.list() - только имена (String)
            System.out.println( filename); // dir.listFiles() - объекты (File)
        }
    }
}
