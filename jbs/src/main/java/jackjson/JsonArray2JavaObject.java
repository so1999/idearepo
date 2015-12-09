package jackjson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sun on 2015/12/9.
 */
public class JsonArray2JavaObject {
    public static void main(String[] args) {
        JsonArray2JavaObject obj=new JsonArray2JavaObject();
        obj.run();
    }

    private void run() {
        ObjectMapper mapper=new ObjectMapper();
        try {

            //Convert JSON Array string to Object
            String jsonString="[{\"name\":\"zhangsan\"},{\"name\":\"lisi\"}]";
            List<Staff> staff1 =mapper.readValue(jsonString, new TypeReference<List<Staff>>(){});
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
