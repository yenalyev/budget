/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spending;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Максим
 */
public class AppMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(new SpendingUI());
        frame.setSize(600, 280);
        frame.setVisible(true);
    }
    
}
