package GoogleGson;

import com.google.gson.stream.JsonWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Sun on 2015/12/30.
 */
public class JsonWriterExample {

    public static void main(String[] args) {
        JsonWriter writer;
        try {
            writer=new JsonWriter(new FileWriter("user.json"));
            writer.beginObject(); //{

            writer.name("name").value("sun");//"name":"sun"
            writer.name("age").value(29);
            writer.name("messages");//"messages":

            writer.beginArray();//[
            writer.value("msg 1");
            writer.value("msg 2");
            writer.value("msg 3");
            writer.endArray();

            writer.endObject();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
