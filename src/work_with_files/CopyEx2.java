package work_with_files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx2 {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\Алексей\\Desktop\\cat.jpg");
             FileOutputStream outputStream = new FileOutputStream("cat_pic.jpg");) {
            int i;
            while((i=inputStream.read()) != -1){
                outputStream.write(i);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}