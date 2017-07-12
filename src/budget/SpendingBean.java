/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budget;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.JdbcRowSet;
/**
 *
 * @author Максим
 */
public class SpendingBean {
final static String doUrl = "jdbc:mysql://localhost:3306/budget";
final static String user = "root";
final static String password = "Bilbao22";
private JdbcRowSet rowSet = null;
    public SpendingBean(){
        try {
    
        rowSet = new JdbcRowSetImpl();
        rowSet.setUrl(doUrl);
        rowSet.setUsername(user);
        rowSet.setPassword(password);
        rowSet.setCommand("SELECT * FROM Spending");
        rowSet.execute();
    } catch (SQLException ex) {
            Logger.getLogger(SpendingBean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR # 0 ...");
        }
    }
    //create new spending
    public Spending create (Spending s){
    try {
        rowSet.moveToInsertRow();
        rowSet.updateString("spend_name", s.getSpend_name());
        rowSet.updateDouble("spend_sum", s.getSpend_sum());
        rowSet.updateString("spend_cat", s.getSpend_cat());
        rowSet.updateDate("spend_date", s.getSpend_date());
        rowSet.updateString("spend_addinfo", s.getSpend_addinfo());
        rowSet.updateString("spend_where", s.getSpend_where());
        rowSet.insertRow();
        rowSet.moveToCurrentRow();
    } catch (SQLException sqlex) {
        System.out.println("Creation of new row was stopped... Trying to delete this...");
        try{
        rowSet.rollback();
        s = null;
        } catch (SQLException sqlex1) {
            System.out.println("ERROR # 1 was detected");
        }
        sqlex.printStackTrace();
    }
    return s;
    }
    
    public Spending update (Spending s){
    try {
        rowSet.updateString("spend_name", s.getSpend_name());
        rowSet.updateDouble("spend_sum", s.getSpend_sum());
        rowSet.updateString("spend_cat", s.getSpend_cat());
        rowSet.updateDate("spend_date", s.getSpend_date());
        rowSet.updateString("spend_addinfo", s.getSpend_addinfo());
        rowSet.updateString("spend_where", s.getSpend_where());
        rowSet.updateRow();
        rowSet.moveToCurrentRow();
    } catch (SQLException sqlex) {
        System.out.println("Update of new row was stopped... Trying to delete this...");
        try{
        rowSet.rollback();
        s = null;
        } catch (SQLException sqlex1) {
            System.out.println("ERROR # 2 was detected");
        }
    }
    return s;
    }
    
    public Spending delete (Spending s){
    try {
        rowSet.deleteRow();
        rowSet.moveToCurrentRow();
    } catch (SQLException sqlex) {
        System.out.println("Deleting of this row was stopped... Trying to stop this...");
        try{
        rowSet.rollback();
        s = null;
        } catch (SQLException sqlex1) {
            System.out.println("ERROR # 3 was detected");
        }
        sqlex.printStackTrace();
    }
    return s;
    }
    
    public Spending moveFirst (){
      Spending s = new Spending();
      try{
      rowSet.first();
      s.setSpend_name(rowSet.getString("spend_name"));
      s.setSpend_sum(rowSet.getDouble("spend_sum"));
      s.setSpend_cat(rowSet.getString("spend_cat"));
      s.setSpend_date(rowSet.getDate("spend_date"));
      s.setSpend_addinfo(rowSet.getString("spend_addinfo"));
      s.setSpend_where(rowSet.getString("spend_where"));
      
      } catch (SQLException sqlex){
          System.out.println("Error *move first* was detected");
      }
         
      return s; 
    }
    
    public Spending moveLast (){
        Spending s = new Spending();
        try{
      rowSet.last();
      s.setSpend_name(rowSet.getString("spend_name"));
      s.setSpend_sum(rowSet.getDouble("spend_sum"));
      s.setSpend_cat(rowSet.getString("spend_cat"));
      s.setSpend_date(rowSet.getDate("spend_date"));
      s.setSpend_addinfo(rowSet.getString("spend_addinfo"));
      s.setSpend_where(rowSet.getString("spend_where"));
      
      } catch (SQLException sqlex){
          System.out.println("Error *move last* was detected");
      }
        return s; 
    }
    
    public Spending moveNext (){
        Spending s = new Spending();
      try{
      if (rowSet.next() == false)
          rowSet.previous();
      s.setSpend_name(rowSet.getString("spend_name"));
      s.setSpend_sum(rowSet.getDouble("spend_sum"));
      s.setSpend_cat(rowSet.getString("spend_cat"));
      s.setSpend_date(rowSet.getDate("spend_date"));
      s.setSpend_addinfo(rowSet.getString("spend_addinfo"));
      s.setSpend_where(rowSet.getString("spend_where"));
      
      } catch (SQLException sqlex){
          System.out.println("Error *move next* was detected");
      }
        return s; 
    }
    
    public Spending movePrevious (){
        Spending s = new Spending();
      try{
      if (rowSet.previous() == false)
          rowSet.next();
      s.setSpend_name(rowSet.getString("spend_name"));
      s.setSpend_sum(rowSet.getDouble("spend_sum"));
      s.setSpend_cat(rowSet.getString("spend_cat"));
      s.setSpend_date(rowSet.getDate("spend_date"));
      s.setSpend_addinfo(rowSet.getString("spend_addinfo"));
      s.setSpend_where(rowSet.getString("spend_where"));
      
      } catch (SQLException sqlex){
          System.out.println("Error *move previous* was detected");
      }
        return s; 
    }
    
    public Spending getCurrent (){
        Spending s = new Spending();
            try{
      rowSet.moveToCurrentRow();
      s.setSpend_name(rowSet.getString("spend_name"));
      s.setSpend_sum(rowSet.getDouble("spend_sum"));
      s.setSpend_cat(rowSet.getString("spend_cat"));
      s.setSpend_date(rowSet.getDate("spend_date"));
      s.setSpend_addinfo(rowSet.getString("spend_addinfo"));
      s.setSpend_where(rowSet.getString("spend_where"));
      
      } catch (SQLException sqlex){
          System.out.println("Error *move to current* was detected");
      }
        return s; 
    }
}
