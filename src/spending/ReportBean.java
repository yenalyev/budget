/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spending;

import com.mysql.jdbc.ResultSetMetaData;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Максим
 */
public class ReportBean {
    final static String doURL = "jdbc:mysql://localhost:3306/budget";
    final static String user = "root";
    final static String password = "Bilbao22";
    
    private JdbcRowSet rowSet = null;
    
    public ReportBean(){
    try{
        rowSet = new JdbcRowSetImpl();
        rowSet.setUrl(doURL);
        rowSet.setUsername(user);
        rowSet.setPassword(password);
        //rowSet.setCommand("SELECT * FROM Spending");
        //rowSet.execute();
    } catch (SQLException sqlex){
    
    }
    }
    
    public ArrayList<Spending> getRangeSpending(java.sql.Date startDate, java.sql.Date endDate){
    String query = "SELECT * FROM spending WHERE spend_date BETWEEN '" + startDate +"' AND '" + endDate +"'";
    try{
    rowSet.setCommand(query);
    rowSet.execute();
    ArrayList<Spending> resultQueryList = new ArrayList<>();
    Double total = 0.0;
    while (rowSet.next()){
        //int id = rowSet.getInt(1);
        String name = rowSet.getString(2);
        Double sum = rowSet.getDouble(3);
        total = total + sum;
        String category = rowSet.getString(4);
        java.sql.Date date = rowSet.getDate(5);
        String addinfo = rowSet.getString(6);
        String where = rowSet.getString(7);
        resultQueryList.add(new Spending(name, sum, category, date, addinfo, where));
    //JOptionPane.showMessageDialog(null, "name: " + rowSet.getString("spend_name"));
    }
    Spending totalRow = new Spending("Total sum", total);
    resultQueryList.add(totalRow);
    
    return resultQueryList;
    //rowSet.close();
        //System.out.println("done");
    } catch (SQLException sqlex){
        System.out.println("not done");
    }
    return null;
    }
    
    public ArrayList<Spending> getRangeSpendingWithAggregating(java.sql.Date startDate, java.sql.Date endDate){
        ArrayList<Spending> resultQueryList = new ArrayList<>();
        Double totalAll = 0.0;
        ComboBox combo = new ComboBox();
        final String COLUMNNAME = "spend_cat";
        String [] sortCategoryByFriequency = combo.getDistinctFromRangeSpendingWithFriquency(COLUMNNAME, startDate, endDate);
        for(String s : sortCategoryByFriequency){
        Double total = 0.0;
        String query = "SELECT * FROM spending WHERE (spend_date BETWEEN '" + startDate +"' AND '" + endDate +
                "') AND (" + COLUMNNAME + " ='" + s + "')";
    try{
    rowSet.setCommand(query);
    rowSet.execute();
    
    while (rowSet.next()){
        //int id = rowSet.getInt(1);
        String name = rowSet.getString(2);
        Double sum = rowSet.getDouble(3);
        total = total + sum;
        totalAll = totalAll + sum;
        String category = rowSet.getString(4);
        java.sql.Date date = rowSet.getDate(5);
        String addinfo = rowSet.getString(6);
        String where = rowSet.getString(7);
        resultQueryList.add(new Spending(name, sum, category, date, addinfo, where));
    //JOptionPane.showMessageDialog(null, "name: " + rowSet.getString("spend_name"));
    }
    Spending totalRow = new Spending("Total sum " + s, total);
    resultQueryList.add(totalRow);
    
    //return resultQueryList;
    //rowSet.close();
        //System.out.println("done");
    } catch (SQLException sqlex){
        System.out.println("not done");
    }
    //return null;
    }
    Spending totalRow = new Spending("TOTAL SPENDING", totalAll);
    resultQueryList.add(totalRow);
    return resultQueryList;
        }
    
    
}
