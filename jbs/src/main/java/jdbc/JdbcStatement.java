package jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sun on 2015/12/11.
 */
public class JdbcStatement {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sampledb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void main(String[] args) {
        try {
            //createDbUserTable();
            //insertRecordIntoDbUserTable();
            //updateRecordIntoDbUserTable();
            //deleteRecordFromDbUserTable();
            //selectListFromDbUserTable();
            batchInsertRecordsIntoTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void batchInsertRecordsIntoTable() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        String sql1 = "INSERT INTO DBUSER "
                + "(USER_ID,USERNAME,CREATED_BY,CREATED_DATE) "
                + "VALUES"
                + "(4,'wangwu','system',"
                + "'" + getCurrentTimeStamp() + "'"
                + ")";
        String sql2 = "INSERT INTO DBUSER "
                + "(USER_ID,USERNAME,CREATED_BY,CREATED_DATE) "
                + "VALUES"
                + "(5,'wangwu','system',"
                + "'" + getCurrentTimeStamp() + "'"
                + ")";
        String sql3 = "INSERT INTO DBUSER "
                + "(USER_ID,USERNAME,CREATED_BY,CREATED_DATE) "
                + "VALUES"
                + "(6,'wangwu','system',"
                + "'" + getCurrentTimeStamp() + "'"
                + ")";

        try {
            conn = getDBConnection();
            stmt = conn.createStatement();
            conn.setAutoCommit(false);
            stmt.addBatch(sql1);
            stmt.addBatch(sql2);
            stmt.addBatch(sql3);

            stmt.executeBatch();
            conn.commit();

            System.out.println("Records are inserted into DBUSER table !");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    private static void selectListFromDbUserTable() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        String sql = "SELECT USER_ID,USERNAME FROM DBUSER";

        try {
            conn = getDBConnection();
            stmt = conn.createStatement();
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                String userid=rs.getString("USER_ID");
                String username=rs.getString("USERNAME");

                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println("userid: "+ userid);
                System.out.println("username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }


    /**
     * Delete record
     * @throws SQLException
     */
    private static void deleteRecordFromDbUserTable() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        String sql = "DELETE FROM DBUSER WHERE USER_ID=1";

        try {
            conn = getDBConnection();
            stmt = conn.createStatement();
            System.out.println(sql);
            stmt.execute(sql);

            System.out.println("Record is Deleted !");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    private static void updateRecordIntoDbUserTable() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        String sql = "UPDATE DBUSER"
                + " SET USERNAME='LISI'"
                + " WHERE USER_ID=1";

        try {
            conn = getDBConnection();
            stmt = conn.createStatement();
            System.out.println(sql);
            stmt.execute(sql);

            System.out.println("Record is UPDATED !");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    private static void insertRecordIntoDbUserTable() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        String sql = "INSERT INTO DBUSER "
                + "(USER_ID,USERNAME,CREATED_BY,CREATED_DATE) "
                + "VALUES"
                + "(3,'wangwu','system',"
                + "'" + getCurrentTimeStamp() + "'"
                + ")";

        try {
            conn = getDBConnection();
            stmt = conn.createStatement();
            System.out.println(sql);
            stmt.executeUpdate(sql);

            System.out.println("Record is inserted into DBUSER table !");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    private static String getCurrentTimeStamp() {
        Date today = new Date();
        return dateFormat.format(today.getTime());
    }

    private static void createDbUserTable() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        String sql = "CREATE TABLE DBUSER("
                + "USER_ID INT(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL,"
                + "CREATED_BY VARCHAR(20) NOT NULL,"
                + "CREATED_DATE DATETIME NOT NULL,"
                + "PRIMARY KEY(USER_ID)"
                + ")";

        try {
            conn = getDBConnection();
            stmt = conn.createStatement();
            System.out.println(sql);
            stmt.execute(sql);

            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
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
}
