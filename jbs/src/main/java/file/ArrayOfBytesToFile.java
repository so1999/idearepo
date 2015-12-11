package file;

import java.io.*;

/**
 * Created by Sun on 2015/12/11.
 */
public class ArrayOfBytesToFile {
    public static void main(String[] args) {
        //convert file into array of bytes
        byte[] bFile=new byte[10];
        bFile[0]='a';
        bFile[1]='b';
        bFile[3]='c';
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("testing2.txt");
            fileOutputStream.write(bFile);
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
