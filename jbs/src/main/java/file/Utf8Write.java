package file;

import java.io.*;

/**
 * Created by Sun on 2016/1/8.
 */
public class Utf8Write {
    public static void main(String[] args) {
        File fileDir=new File("writeutf8.txt");
        try {
            Writer out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir),"UTF-8"));
            out.append("Helllo UTF-8").append("\r\n");
            out.append("你好 UTF-8").append("\r\n");
            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
