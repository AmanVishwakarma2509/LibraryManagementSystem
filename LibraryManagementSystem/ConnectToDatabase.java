package LibraryManagementSystem;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class ConnectToDatabase {
        Connection connect;
        Statement st;
        public ConnectToDatabase(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?characterEncoding=latin1","root","AMAN123");

                st = connect.createStatement();

            }
            catch (Exception e){
            System.out.println(e);
        }
        }
    }

