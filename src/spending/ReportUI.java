/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spending;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Максим
 */
public class ReportUI extends JPanel{
    private JTextField firstDateField = new JTextField(15);
    private JTextField lastDateField = new JTextField(15);
    
    private JButton startButton = new JButton("Start");
    
    public static void showGUI() {
    JFrame reportFrame = new JFrame();
    //reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    reportFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    reportFrame.getContentPane().add(new ReportUI());
    reportFrame.setSize(600, 280);
    reportFrame.setTitle("Report");
    reportFrame.setVisible(true);
    }
    
    private ReportBean repBean = new ReportBean();
    
    private Report report = new Report();
    
    public ReportUI(){
    setBorder(new TitledBorder(new EtchedBorder(), "Report"));
    add(initFields(), BorderLayout.NORTH);
    add(initButtons(), BorderLayout.SOUTH);
    setFieldData(report);
    }
    
    
    private JPanel initFields(){
    JPanel panel = new JPanel();
    panel.setLayout(new MigLayout());
    panel.add(new JLabel("First Date"), "align label");
    panel.add(firstDateField);
    panel.add(new JLabel("Second Date"), "align label");
    panel.add(lastDateField, "wrap");
    return panel;
    }
    
    private JPanel initButtons(){
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
    panel.add(startButton);
    startButton.addActionListener(new ButtonHandler());
    return panel;
    }
    
    private Report getFieldData(){
        Report report = new Report();
        report.setStartDate(Date.valueOf(firstDateField.getText()));
        report.setEndDate(Date.valueOf(lastDateField.getText()));
        
        return report;
    }
    
    private void setFieldData(Report report){
        
        firstDateField.setText(String.valueOf(report.getStartDate()));
        lastDateField.setText(String.valueOf(report.getEndDate()));
        
    }
    
    private boolean isEmptyData(){
    return(firstDateField.getText().trim().isEmpty()&&lastDateField.getText().trim().isEmpty());
    }
        
    private class ButtonHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Report report = getFieldData();
            switch(e.getActionCommand()){
                case "Start":
                    java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
                    java.sql.Date startDate = report.getStartDate();
                    java.sql.Date endDate = report.getEndDate();
                    setFieldData(report);
                    ArrayList<Spending> resultQueryList = repBean.getRangeSpendingWithAggregating(startDate, endDate);
                    ResultUI.showGUI(resultQueryList);
                    //JOptionPane.showMessageDialog(null, "Not done yet...");
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Unsupported command");
            }
        }
    }
}
