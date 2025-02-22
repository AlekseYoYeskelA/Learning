package work_with_files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileEx {
    public static void main(String[] args) throws IOException {
        File file = new File("test2.txt");
        File folder = new File("C:\\Users\\Алексей\\Desktop\\A");
        File file2 = new File("C:\\Users\\Алексей\\Desktop\\A\\test3.txt");
        File folder2 = new File("C:\\Users\\Алексей\\Desktop\\B");


        System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath() " + folder.getAbsolutePath());
        System.out.println("_______________________________________________");

        System.out.println("file.isAbsolute() " + file.isAbsolute());
        System.out.println("folder.isAbsolute() " + folder.isAbsolute());
        System.out.println("_______________________________________________");

        System.out.println("file.isDirectory() " + file.isDirectory());
        System.out.println("folder.isDirectory() " + folder.isDirectory());
        System.out.println("_______________________________________________");

        System.out.println("file.exist() " + file.exists());
        System.out.println("folder.exist() " + folder.exists());
        System.out.println("file2.exist() " + file2.exists());
        System.out.println("folder2.exist() " + folder2.exists());
        System.out.println("_______________________________________________");

        System.out.println("file2.createNewFile() " + file2.createNewFile());
        System.out.println("folder2.mkdir() " + folder2.mkdir());
        System.out.println("_______________________________________________");

        System.out.println("file2.createNewFile() " + file2.length());
        System.out.println("folder.mkdir() " + folder.length());
        System.out.println("_______________________________________________");

//        System.out.println("folder.delete() " + folder2.delete());
//        System.out.println("file2.delete() " + file2.delete());
//        System.out.println("folder2.delete() " + folder2.delete());
//        System.out.println("_______________________________________________");

        File[] files = folder.listFiles();
        System.out.println(Arrays.toString(files));

        System.out.println("file2.isHidden() " + file2.isHidden());
        System.out.println("file2.canRead() " + file2.canRead());
        System.out.println("file2.canWrite() " + file2.canWrite());
        System.out.println("file2.canExecute() " + file2.canExecute());


    }
}
