package jdbc;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Sun on 2015/12/11.
 */
public class JdbcMysql {
    public static void main(String[] args) {
        System.out.println("-----------MySQL JDBC Connection Testing-----------");

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection=null;

        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        if(connection!=null){
            try {
                System.out.println(connection);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
