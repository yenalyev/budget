/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budget;

import static budget.ReportBean.doURL;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.sql.rowset.JdbcRowSet;

/**
 *
 * @author Максим
 */
public class ComboBox {
    final static String doURL = "jdbc:mysql://localhost:3306/budget";
    final static String user = "root";
    final static String password = "Bilbao22";
    
    private JdbcRowSet rowSet = null;
    
    public ComboBox(){
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
    
    public String[] getDistinctFromSpending(String columnName){
        ArrayList<String> resultList = new ArrayList<>();
        String [] resultArray = null;
        //String[] unsortedMap = new String[];
        String query = "SELECT DISTINCT " + columnName + " FROM Spending";
        try{
        rowSet.setCommand(query);
        rowSet.execute();
        while(rowSet.next()){
            resultList.add(rowSet.getString(columnName));
        }
        resultArray = new String[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
        resultArray[i] = resultList.get(i);
        }
        } catch (SQLException sqlex){
        
        } 
        return resultArray;
    }
    
    public String[] getDistinctFromSpendingWithFriquency(String columnName){
        ArrayList<String> resultList = new ArrayList<>();
        String [] resultArray = null;
        HashMap<String, Integer> unsortedMap = new HashMap<>();
        ValueComparator comparator = new ValueComparator(unsortedMap);
        TreeMap<String, Integer> sortedMap = new TreeMap<>(comparator);
        
        //String[] unsortedMap = new String[];
        //String queryUnique = "SELECT DISTINCT " + columnName + " FROM Spending";
        String queryAll = "SELECT " + columnName + " FROM Spending";
        try{
        rowSet.setCommand(queryAll);
        rowSet.execute();
        while(rowSet.next()){
            Integer friquency = unsortedMap.get(rowSet.getString(columnName));
            unsortedMap.put(rowSet.getString(columnName), friquency == null ? 1 : friquency + 1);
        }
        
            sortedMap.putAll(unsortedMap);
        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()){
        resultList.add(entry.getKey());
        }
        resultArray = new String[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
        resultArray[i] = resultList.get(i);
        }
        } catch (SQLException sqlex){
        
        } 
        return resultArray;
    }
    
    public String[] getDistinctFromRangeSpendingWithFriquency(String columnName, java.sql.Date startDate, java.sql.Date endDate){
        ArrayList<String> resultList = new ArrayList<>();
        String [] resultArray = null;
        HashMap<String, Integer> unsortedMap = new HashMap<>();
        ValueComparator comparator = new ValueComparator(unsortedMap);
        TreeMap<String, Integer> sortedMap = new TreeMap<>(comparator);
        
        //String[] unsortedMap = new String[];
        //String queryUnique = "SELECT DISTINCT " + columnName + " FROM Spending";
        String queryAll = "SELECT " + columnName + " FROM Spending WHERE spend_date BETWEEN '" + startDate + 
                "' AND '" + endDate + "'";
        try{
        rowSet.setCommand(queryAll);
        rowSet.execute();
        while(rowSet.next()){
            Integer friquency = unsortedMap.get(rowSet.getString(columnName));
            unsortedMap.put(rowSet.getString(columnName), friquency == null ? 1 : friquency + 1);
        }
        
            sortedMap.putAll(unsortedMap);
        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()){
        resultList.add(entry.getKey());
        }
        resultArray = new String[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
        resultArray[i] = resultList.get(i);
        }
        } catch (SQLException sqlex){
        
        } 
        return resultArray;
    }
    
    class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
}
