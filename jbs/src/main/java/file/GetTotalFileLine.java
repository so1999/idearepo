package file;

import java.io.*;

/**
 * Created by Sun on 2016/1/8.
 */
public class GetTotalFileLine {
    public static void main(String[] args) {
        File file=new File("utf8test.txt");
        if(file.exists()){
            try {
                FileReader fr=new FileReader(file);
                LineNumberReader lnr=new LineNumberReader(fr);
                int linenumber=0;
                while(lnr.readLine()!=null){
                    linenumber++;
                }
                System.out.println(linenumber);
                lnr.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
