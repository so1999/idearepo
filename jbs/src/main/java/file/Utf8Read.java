package file;

import java.io.*;

/**
 * Created by Sun on 2016/1/8.
 */
public class Utf8Read {
    public static void main(String[] args) {
        File fileDir = new File("utf8test.txt");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
