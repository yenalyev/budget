/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budget;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class SpendingUI extends JPanel {

    private boolean categoryVisibleFlag = true;
    private JTextField spend_nameField = new JTextField(30);
    private JTextField spend_sumField = new JTextField(30);
    
    private JTextField spend_catField = new JTextField(30);
    private JComboBox editComboCategory;
    private JComboBox comboCase;
    
    
    
    
    
    private JTextField spend_dateField = new JTextField(30);
    private JTextField spend_addinfoField = new JTextField(30);
    private JTextField spend_whereField = new JTextField(30);
    
    private JButton createButton = new JButton("New");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    private JButton firstButton = new JButton("First");
    private JButton lastButton = new JButton("Last");
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");
    private JButton showAllButton = new JButton("ShowALL");
            //JPanel panel = new JPanel();

    
    
    private SpendingBean bean = new SpendingBean();
    JPanel panel;
      
    
    public SpendingUI () {
    setBorder(new TitledBorder(new EtchedBorder(), "Spending"));
    
    setLayout(new BorderLayout (5, 5));
    this.panel = new JPanel();
    this.panel.setVisible(true);
    this.panel.setLayout(new FlowLayout());
    add(panel, BorderLayout.EAST);
    add(initFields(), BorderLayout.NORTH);
    add(initButtons(), BorderLayout.CENTER);
    setFieldData(bean.moveLast());
    }

      
    private JPanel initButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
        panel.add(createButton);
        createButton.addActionListener(new ButtonHandler());
        panel.add(updateButton);
        updateButton.addActionListener(new ButtonHandler());
        panel.add(deleteButton);
        deleteButton.addActionListener(new ButtonHandler());
        panel.add(firstButton);
        firstButton.addActionListener(new ButtonHandler());
        panel.add(nextButton);
        nextButton.addActionListener(new ButtonHandler());
        panel.add(previousButton);
        previousButton.addActionListener(new ButtonHandler());
        panel.add(lastButton);
        lastButton.addActionListener(new ButtonHandler());
        panel.add(showAllButton);
        showAllButton.addActionListener(new ButtonHandler());
        
        return panel;
    }
    JPanel catPanel;
    private JPanel initFields() {
        JPanel panel = new JPanel();
        
                
                
        panel.setLayout(new MigLayout());
        panel.add(new JLabel("Spend"), "align label");
        panel.add(spend_nameField, "wrap");
        panel.add(new JLabel("Sum"), "align label");
        panel.add(spend_sumField, "wrap");
        panel.add(new JLabel("Category"), "align label");
        catPanel = getCategoryView();
        
        panel.add(catPanel, "wrap");
        
        //panel.add(addJComboBox());
        //spend_catField.setVisible(false);
        //panel.add(spend_catField, "wrap");
        //spend_catField.setVisible(false);
        panel.add(new JLabel("Date"), "align label");
        panel.add(spend_dateField, "wrap");
        panel.add(new JLabel("Additional info"), "align label");
        panel.add(spend_addinfoField, "wrap");
        panel.add(new JLabel("Location"), "align label");
        panel.add(spend_whereField, "wrap");
        
        return panel;
        
    }
    
    private Spending getFieldData(){
        
        Spending s = new Spending();
        s.setSpend_name(spend_nameField.getText());
        s.setSpend_sum(Double.parseDouble(spend_sumField.getText()));
        s.setSpend_cat(spend_catField.getText());
        s.setSpend_date(Date.valueOf(spend_dateField.getText()));
        s.setSpend_addinfo(spend_addinfoField.getText());
        s.setSpend_where(spend_whereField.getText());
        
        return s;
    }

    private void setFieldData(Spending s) {
        
        spend_nameField.setText(s.getSpend_name());
        spend_sumField.setText(String.valueOf(s.getSpend_sum()));
        spend_catField.setText(s.getSpend_cat());
        
        spend_dateField.setText(String.valueOf(s.getSpend_date()));
        spend_addinfoField.setText(s.getSpend_addinfo());
        spend_whereField.setText(s.getSpend_where());
    }
    
    private boolean isEmptyFieldData(){
    return (spend_nameField.getText().trim().isEmpty() && spend_sumField.getText().trim().isEmpty());
    }   
    
    private JComboBox addJComboBox(){
    ComboBox combo = new ComboBox();
    String[] sourceForComboCategory = combo.getDistinctFromSpendingWithFriquency("spend_cat");
    editComboCategory = new JComboBox(sourceForComboCategory);
    editComboCategory.setEditable(true);
    editComboCategory.setAlignmentX(LEFT_ALIGNMENT);
    
    editComboCategory.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String strToTextField = (String) editComboCategory.getSelectedItem();
            spend_catField.setText(strToTextField);
        }});
    
    return editComboCategory;
    
    }
    private JPanel getCategoryView(){
        JPanel categoryContainer = new JPanel();
        categoryContainer.setVisible(true);
        comboCase = addJComboBox();
        if (categoryVisibleFlag){
        categoryContainer.add(spend_catField);
        
        } else {
        categoryContainer.add(comboCase);
        }
        return categoryContainer;
    }    
    
    
       
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            Spending s = getFieldData();
            switch (e.getActionCommand()){
                case "Save":
                    if (isEmptyFieldData()){
                        JOptionPane.showMessageDialog(null, "Cannot create an empty record");
                        return;
                    }
                    if (bean.create(s) != null){
                        SpendingUI.this.categoryVisibleFlag = true;
                    JPanel catPanel = getCategoryView();
                    
                    SpendingUI.this.spend_catField.setVisible(true);
                    SpendingUI.this.catPanel.removeAll();
                    SpendingUI.this.catPanel.add(catPanel, "wrap");
                        JOptionPane.showMessageDialog(null, "New spending was created successfully");
                        createButton.setText("New");
                        break;
                    }
                
                case "New":
                    SpendingUI.this.categoryVisibleFlag = false;
                    JPanel catPanel = getCategoryView();
                    
                    SpendingUI.this.spend_catField.setVisible(false);
                    SpendingUI.this.comboCase.setVisible(true);
                    SpendingUI.this.catPanel.removeAll();
                    SpendingUI.this.catPanel.add(catPanel, "wrap");
                    java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
                    
                    s.setSpend_name("");
                    s.setSpend_sum(0.00);
                    s.setSpend_cat("");
                    s.setSpend_date(today);
                    s.setSpend_addinfo("");
                    s.setSpend_where("");
                    
                    createButton.setText("Save");
                    setFieldData(s);
                    
                    break;
                
                case "Update":
                    if (isEmptyFieldData()){
                    JOptionPane.showMessageDialog(null, "Cannot update an empty record");
                    return;
                    }
                    if (bean.update(s) != null){
                        SpendingUI.this.spend_catField.setVisible(true);
                        SpendingUI.this.comboCase.setVisible(false);
                    JOptionPane.showMessageDialog(null, "The record was update");
                    break;
                    }
                    
                case "Delete":
                    
                    if (isEmptyFieldData()){
                    JOptionPane.showMessageDialog(null, "Cannot delete an empty record");
                    return;
                    }
                        SpendingUI.this.spend_catField.setVisible(true);
                        SpendingUI.this.comboCase.setVisible(false);
                    s = bean.getCurrent();
                    bean.delete(s);
                    JOptionPane.showMessageDialog(null, "The record was delete");
                    break;
                    
                case "First":
                        SpendingUI.this.spend_catField.setVisible(true);
                        SpendingUI.this.comboCase.setVisible(false);
                    setFieldData(bean.moveFirst());
                    break;
                    
                case "Last":
                        SpendingUI.this.spend_catField.setVisible(true);
                        SpendingUI.this.comboCase.setVisible(false);
                    setFieldData(bean.moveLast());
                    break;
                    
                case "Next":
                        SpendingUI.this.spend_catField.setVisible(true);
                        SpendingUI.this.comboCase.setVisible(false);
                    setFieldData(bean.moveNext());
                    break;
                    
                case "Previous":
                        SpendingUI.this.spend_catField.setVisible(true);
                        SpendingUI.this.comboCase.setVisible(false);
                    setFieldData(bean.movePrevious());
                    break;
                    
                case "ShowALL":
                    ReportUI.showGUI();
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Invalid command");
            }
                    
        }
    
    
    }
}
