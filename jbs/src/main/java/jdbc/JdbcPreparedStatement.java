package jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sun on 2015/12/11.
 */
public class JdbcPreparedStatement {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sampledb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void main(String[] args) {
        try {
            //createTable();
            //String sql="INSERT INTO DBUSER"+"(USER_ID,USERNAME,CREATED_BY,CREATED_DATE) VALUES"+ "(?,?,?,?)";
            //String sql="UPDATE DBUSER SET USERNAME = ? " + " WHERE USER_ID = ?";
            //String sql = "DELETE FROM DBUSER WHERE USER_ID=?";
            String sql = "SELECT USER_ID,USERNAME FROM DBUSER WHERE USER_ID=?";
            List list = new ArrayList();
            list.add(1);
            operateTable(sql, list, "2");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param sql SQL语句
     * @param list 参数列表
     * @param flag 查询标志，“1”增删改，“2”查询
     * @throws SQLException
     */
    private static void operateTable(String sql, List list, String flag) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = getDBConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Integer) {
                    pstmt.setInt(i + 1, (Integer) list.get(i));
                }
                if (list.get(i) instanceof String) {
                    pstmt.setString(i + 1, (String) list.get(i));
                }

            }
            if ("1".equals(flag)) {
                pstmt.executeUpdate();
                System.out.println("Operation is successful");
                return;
            }
            if ("2".equals(flag)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String userid = rs.getString("USER_ID");
                    String username = rs.getString("USERNAME");

                    System.out.println("userid : " + userid);
                    System.out.println("username : " + username);
                }
                System.out.println("Operation is successful");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    private static Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static String getCurrentTimeStamp() {
        Date today = new Date();
        return dateFormat.format(today.getTime());
    }
}
