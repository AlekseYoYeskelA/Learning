package work_with_files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test.txt");
        Path directoryPath = Paths.get("C:\\Users\\Алексей\\Desktop\\M");
        Path directoryBPath = Paths.get("C:\\Users\\Алексей\\Desktop\\B");

//        Files.copy(filePath, directoryPath.resolve(filePath) , StandardCopyOption.REPLACE_EXISTING);
//        Files.copy(filePath, directoryPath.resolve("test11.txt"));
//        Files.copy(directoryBPath, directoryPath.resolve("B"));

        //Files.move(filePath, directoryPath.resolve("test.txt"));

//        Files.move(Paths.get("test10.txt"), Paths.get("test100.txt"));

        //Files.delete(Paths.get("test5.txt"));

        Files.delete(directoryPath);
        System.out.println("Done!");
    }
}
