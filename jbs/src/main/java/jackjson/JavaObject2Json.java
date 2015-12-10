package jackjson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun on 2015/12/9.
 */
public class JavaObject2Json {
    public static void main(String[] args) {
        JavaObject2Json obj=new JavaObject2Json();
        obj.run();
    }

    public void run(){
        ObjectMapper mapper=new ObjectMapper();
        Staff staff=createDummyObject();
        try {
            //Convert object to JSON string and save into a file directly
            mapper.writeValue(new File("staff.json"),staff);

            //Convert object to JSON string
            String jsonString =mapper.writeValueAsString(staff);
            System.out.println(jsonString);

            //Convert object to JSON string and pretty print
            jsonString=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
            System.out.println(jsonString);

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Staff createDummyObject(){
        Staff staff=new Staff();
        staff.setName("zhangsan");
        staff.setAge(26);
        staff.setPosition("Developer");
        staff.setSalary(new BigDecimal("7500"));

        List<String> skills=new ArrayList<String>();
        skills.add("java");
        skills.add("python");

        staff.setSkills(skills);
        return staff;
    }

}
