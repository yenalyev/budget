/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spending;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Максим
 */
public class ResultUI extends JFrame {
    
    public static void showGUI(ArrayList<Spending> resultQueryList){
    //JFrame result = new JFrame();
    //result.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    new ResultUI(resultQueryList);
    
    //result.setSize(600, 400);
    //result.setTitle("Result");
    //result.setVisible(true);
    }
    
    public ResultUI(ArrayList<Spending> resultQueryList){
       TableModel model = new MyTableModel(resultQueryList);
        JTable table = new JTable(model);
        //JScrollPane scrollpane = new JScrollPane(table);
        //getContentPane().add(table);
        getContentPane().add(new JScrollPane(table));
        setPreferredSize(new Dimension(600, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

   

   
    
}
