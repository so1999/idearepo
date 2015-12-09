package jackjson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Sun on 2015/12/9.
 */
public class Json2Map {
    public static void main(String[] args) {
        Json2Map obj = new Json2Map();
        obj.run();
    }

    private void run() {
        ObjectMapper mapper = new ObjectMapper();
        try {

            //Convert JSON Array string to Object
            String jsonString = "{\"name\":\"zhangsan\"}";
            Map<String,Object> staff1 = mapper.readValue(jsonString, new TypeReference<Map<String,Object>>() {
            });
            System.out.println(staff1);

            //Pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
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
