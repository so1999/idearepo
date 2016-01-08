package file;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Sun on 2016/1/8.
 * use DataInputStream to convert all the content into bytes, and create a String variable with the converted bytes.
 */
public class AssignFileToVariable {
    public static void main(String[] args) {
        try {
            DataInputStream dis=new DataInputStream(new FileInputStream("user.json"));
            byte[] datainBytes=new byte[dis.available()];
            dis.readFully(datainBytes);
            dis.close();
            String content=new String(datainBytes,0,datainBytes.length);
            System.out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
