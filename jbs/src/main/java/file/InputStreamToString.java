package file;

import java.io.*;

/**
 * Created by Sun on 2015/12/11.
 */
public class InputStreamToString {
    public static void main(String[] args) {
        InputStream is=new ByteArrayInputStream("file content".getBytes());
        String result=getStringFromInputStream(is);

        System.out.println(result);
    }

    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br=null;
        StringBuilder sb=new StringBuilder();
        String line;

        try {
            br=new BufferedReader(new InputStreamReader(is));
            while ((line=br.readLine())!=null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }
}
