package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Sun on 2016/1/8.
 * generate a file checksum value with “SHA-1” mechanism in Java.
 */
public class GenerateFileChecksum {
    public static void main(String[] args) {
        String datafile="user.json";
        try {
            MessageDigest md=MessageDigest.getInstance("SHA1");
            FileInputStream fis=new FileInputStream(datafile);
            byte[] dataBytes=new byte[1024];
            int nread=0;
            while ((nread=fis.read(dataBytes))!=-1){
                md.update(dataBytes,0,nread);
            }
            byte[] mdbytes=md.digest();
            //convert the byte to hex format
            StringBuffer sb=new StringBuffer("");
            for (int i=0;i<mdbytes.length;i++){
                sb.append(Integer.toString((mdbytes[i]&0xff)+0x100,16).substring(1));
            }
            System.out.println(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
