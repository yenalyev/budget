   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spending;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author Максим
 */
public class Budget {
final static String doUrl = "jdbc:mysql://localhost:3306/budget";
final static String user = "root";
final static String password = "Bilbao22";
    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        // TODO code application logic here
        try{
        Connection conn = DriverManager.getConnection(doUrl, user, password);
        if (conn != null){
            System.out.println("Connection was created sucsessfully");
        }
        Date date = new Date();
        insert(conn, "sugar", 10.00, "Grosery", date, "", "");
        } catch (SQLException sqlex){
            System.out.println("Connection to databace was failed...");
        }
        
        
    }
    
    public static void insert(Connection conn, String spend_name, Double spend_sum,
            String spend_cat, Date spand_date, String spend_info, String spend_where){
    String Insert = "INSERT into Spending (spend_name, spend_sum, spend_cat, spend_date, spend_addinfo, spend_where) VALUES (?,?,?,?,?,?)";
    
    try{
    PreparedStatement statement = conn.prepareStatement(Insert);
    statement.setString(1, spend_name);
    statement.setDouble(2, spend_sum);
    statement.setString(3, spend_cat);
    statement.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
    statement.setString(5, spend_info);
    statement.setString(6, spend_where);
    
    int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("New information was added");
            }
    } catch (SQLException sqlex){
        System.out.println("Connection was failed during INSERT operation...");
    }
    
    
    }*/
    
    
}
