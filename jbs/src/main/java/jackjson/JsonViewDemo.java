package jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun on 2015/12/9.
 */
public class JsonViewDemo {
    public static void main(String[] args) {
        JsonViewDemo obj=new JsonViewDemo();
        obj.run();
    }

    private void run() {
        ObjectMapper mapper=new ObjectMapper();
        ViewStaff staff=createDummyObject();

        try{
            //Salary will be hidden
            System.out.println("Normal View");
            String normalView=mapper.writerWithView(Views.Normal.class).writeValueAsString(staff);
            System.out.println(normalView);

            String jsonInString="{\"name\":\"mkyong\",\"age\":33,\"position\":\"Developer\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
            ViewStaff normalStaff=mapper.readerWithView(Views.Normal.class).forType(ViewStaff.class).readValue(jsonInString);
            System.out.println(normalStaff);

            //Display everything
            System.out.println("\nManager View");
            String managerView=mapper.writerWithView(Views.Manager.class).writeValueAsString(staff);
            System.out.println(managerView);

            ViewStaff managerStaff=mapper.readerWithView(Views.Manager.class).forType(ViewStaff.class).readValue(managerView);
            System.out.println(managerStaff);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ViewStaff createDummyObject() {
        ViewStaff staff=new ViewStaff();
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
