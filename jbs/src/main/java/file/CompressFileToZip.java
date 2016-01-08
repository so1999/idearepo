package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Sun on 2015/12/14.
 */
public class CompressFileToZip {
    public static void main(String[] args) {
        byte[] buffer =new byte[1024];
        try {
            FileOutputStream fos=new FileOutputStream("myfile.zip");
            ZipOutputStream zos=new ZipOutputStream(fos);
            ZipEntry ze=new ZipEntry("testing.txt");
            zos.putNextEntry(ze);
            FileInputStream in=new FileInputStream("testing.txt");
            int len;
            while((len=in.read(buffer))>0){
                zos.write(buffer,0,len);
            }

            in.close();
            zos.closeEntry();
            zos.close();
            System.out.println("Done");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
