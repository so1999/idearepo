package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Sun on 2015/12/11.
 */
public class FileToArrayOfBytes {
    public static void main(String[] args) throws IOException {
        //FileInputStream fileInputStream=null;
        //File file=new File("testing.txt");
        byte[] bFile=new byte[15];
        System.out.println(bFile[0]);
        try{
            //convert file into array of bytes
            FileInputStream fileInputStream=new FileInputStream(new File("testing.txt"));
            fileInputStream.read(bFile);
            fileInputStream.close();
            System.out.println(bFile[0]);

            for(int i=0;i<bFile.length;i++){
                System.out.println((char) bFile[i]);
            }

            System.out.println("Done");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
