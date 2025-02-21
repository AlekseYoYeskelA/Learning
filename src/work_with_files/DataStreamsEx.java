package work_with_files;

import java.io.*;

public class DataStreamsEx { // для записи и чтения примитивных типов данных
    public static void main(String[] args) {
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("my_test.bin"));
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("my_test.bin"));) {
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(5);
            dataOutputStream.writeChar('a');
            dataOutputStream.writeFloat(3.15F);
            dataOutputStream.writeDouble(3.14);

            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readFloat());
            System.out.println(dataInputStream.readDouble());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
