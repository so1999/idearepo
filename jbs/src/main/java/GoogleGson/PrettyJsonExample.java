package GoogleGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Sun on 2015/12/30.
 */
public class PrettyJsonExample {

    public static void main(String[] args) {
        DataObject obj=new DataObject();

        Gson gson=new GsonBuilder().setPrettyPrinting().create();

        String json=gson.toJson(obj);
        System.out.println(json);
    }
}
