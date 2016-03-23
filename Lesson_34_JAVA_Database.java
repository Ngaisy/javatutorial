package javatutorial;
import java.sql.*;
/**
 * Created by Shawn on 3/20/16.
 */
public class Lesson_34_JAVA_Database {
    public static void main(String[] args){
        // A connection object is used to provide access to a database
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/customer","Shawn","myhome82663779");
            Statement sqlState = conn.createStatement();

            String selectStuff = "select first_name from customers";

            ResultSet rows = sqlState.executeQuery(selectStuff);

            while(rows.next()){
                System.out.println(rows.getString("first_name"));
            }
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch (ClassNotFoundException e){
            // Executes if the driver can't be found
            e.printStackTrace();
        }

    }
}
