package GoogleGson;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Sun on 2015/12/30.
 */
public class JsonReaderExample {

    public static void main(String[] args) {
        try {
            JsonReader reader=new JsonReader(new FileReader("user.json"));
            reader.beginObject();
            while (reader.hasNext()){
                String name=reader.nextName();
                if(name.equals("name")){
                    System.out.println(reader.nextString());
                }else if(name.equals("age")){
                    System.out.println(reader.nextInt());
                }else if(name.equals("messages")){
                    reader.beginArray();
                    while ((reader.hasNext())){
                        System.out.println(reader.nextString());
                    }
                    reader.endArray();
                }else {
                    reader.skipValue();
                }
            }
            reader.endObject();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
