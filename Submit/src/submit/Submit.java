/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submit;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author nahid
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

class WindowSensor extends WindowAdapter{
	
	public void windowClosing(WindowEvent w){
		System.out.println("Window is cloasing");
		System.exit(0);
	}
}

class Final extends Frame{
    public Final(){
        
    }
}

public class Submit extends Frame implements ActionListener{
    
    JComboBox classs;
    Label Class,NoOfTickets;
    Button submit;
    TextField not;
    
    public Submit(){
        Class=new Label("Class");
        Class.setBounds(40,80,40,20);
        add(Class);
        
        classs=new JComboBox();
        classs.addItem("Economy");
        classs.addItem("Business");
        classs.setBounds(100,80,80,20);
        add(classs);
        
        NoOfTickets=new Label("No. Of Tickets :");
        NoOfTickets.setBounds(40,120,40,20);
        add(NoOfTickets);
        
        not=new TextField();
        not.setBounds(100,120,40,20);
        add(not);
        
        submit=new Button("Button");
        submit.setBounds(300,300,60,20);
        add(submit);
        
        submit.addActionListener(this);
        setLayout(null);
    }
        
        public static void main(String[] args){
        Submit sb =new Submit();
        sb.setVisible(true);
        sb.setBounds(160,0,400,400);
        sb.addWindowListener(new WindowSensor());
      }
        
        public void actionPerformed(ActionEvent e){
            //Work Here
            String s1=e.getActionCommand();
            
            Final ff=new Final();
            ff.setSize(600,600);
            ff.addWindowListener(new WindowSensor());
            ff.setVisible(true);
        }
        
}
