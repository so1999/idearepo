package file;

import java.io.*;

/**
 * Created by Sun on 2015/12/11.
 */
public class StringToInputstream {
    public static void main(String[] args) throws IOException {
        String str="This is a String";

        //convert String into InputStream
        InputStream is=new ByteArrayInputStream(str.getBytes());


        //read with BufferedReader
        BufferedReader br=new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);

        }

        br.close();

    }
}
