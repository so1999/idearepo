package jackjson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sun on 2015/12/9.
 */
public class Json2JavaObject {
    public static void main(String[] args) {
        Json2JavaObject obj=new Json2JavaObject();
        obj.run();
    }

    private void run() {
        ObjectMapper mapper=new ObjectMapper();
        try {
            //Convert JSON string from file to Object
            Staff staff=mapper.readValue(new File("staff.json"),Staff.class);
            System.out.println(staff);

            //Convert JSON string to Object
            String jsonString="{\"name\":\"zhangsan\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
            Staff staff1 =mapper.readValue(jsonString,Staff.class);
            System.out.println(staff1);

            //Pretty print
            String prettyStaff1=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
            System.out.println(prettyStaff1);

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
