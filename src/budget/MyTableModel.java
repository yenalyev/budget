/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budget;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Максим
 */
public class MyTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    
            
    private List<Spending> spendingBean;
    
    
    public MyTableModel(List<Spending> spending){
    this.spendingBean = spending;
    }        
    
     
    
            
    @Override
    public int getRowCount() {
        return spendingBean.size();
    }

    @Override
    public int getColumnCount() {
          return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if(columnIndex == 0)
            return "NAME";
        else if (columnIndex == 1)
            return "SUM";
        else if (columnIndex == 2)
            return "CATEGORY";
        else if (columnIndex == 3)
            return "DATE";
        else if (columnIndex == 4)
            return "ADDINFO";
        else if (columnIndex == 5)
            return "LOCATION";
        else return "nonamed";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> classType;
        if(columnIndex == 0)
            return classType = String.class;
        else if (columnIndex == 1)
            return classType = Double.class;
        else if (columnIndex == 2)
            return classType = String.class;
        else if (columnIndex == 3)
            return classType = java.sql.Date.class;
        else if (columnIndex == 4)
            return classType = String.class;
        else if (columnIndex == 5)
            return classType = String.class;
        else return classType = String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int colunmIndex) {
        Spending spending = spendingBean.get(rowIndex);
        switch(colunmIndex){
            case 0:
                return spending.getSpend_name();
            case 1:
                return spending.getSpend_sum();
            case 2:
                return spending.getSpend_cat();
            case 3:
                return spending.getSpend_date();
            case 4:
                return spending.getSpend_addinfo();
            case 5: 
                return spending.getSpend_where();
            
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener listener) {
    listeners.add(listener);
        }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }
    
}
