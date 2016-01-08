package GoogleGson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

/**
 * Created by Sun on 2015/12/30.
 */
public class FromJson {
    public static void main(String[] args) {

        Gson gson=new Gson();

        try {
            BufferedReader br=new BufferedReader(new FileReader("file.json"));
            //convert the json string back to objcet
            DataObject obj=gson.fromJson(br, DataObject.class);
            System.out.println(obj);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
