/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author nahid
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

class WindowSensor extends WindowAdapter{
	
	public void windowClosing(WindowEvent w){
		System.out.println("Window is cloasing");
		System.exit(0);
	}
}

class Frame1 extends Frame implements ActionListener{
    String s;
    TextField T2;
    public Frame1(String s2){
        s=s2;
        setVisible(true);
        setSize(300,400);
        
        T2=new TextField();
        add(T2);
        
        Button B2=new Button("Ok");
        add(B2);
        
        B2.addActionListener(this);
        setLayout(new FlowLayout());
        
    }
    
    
        public void actionPerformed(ActionEvent e){
            if (e.getActionCommand()=="Ok"){
            T2.setText(s);
            }
        
        }
        
  }

public class Test extends Frame implements ActionListener{
    TextField T1;
    public Test(){
        
        setSize(500,500);
        setVisible(true);
        T1=new TextField();
        add(T1);
        Button B1=new Button("Button");
        add(B1);
        
        B1.addActionListener(this);
        
        setLayout(new FlowLayout());
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Test t1=new Test();
        t1.addWindowListener(new WindowSensor());
    }
    
    public void actionPerformed(ActionEvent e){
        String s1;
        s1=T1.getText();
        if(e.getActionCommand()=="Button"){
            new Frame1(s1);
        }
        
    
    }
    
}
