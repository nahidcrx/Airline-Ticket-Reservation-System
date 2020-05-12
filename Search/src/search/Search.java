/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

class WindowSensor extends WindowAdapter{
	public void windowClosing(WindowEvent W){
				System.exit(0);
	}
}

public class Search extends Frame implements ActionListener {
    JComboBox start,end,time;
    Label Start,End,Date,Time,Dformat;
    TextField date;
    Button search,cancel;
    
    public Search(){
        setBounds(150,0,500,500);
        Start=new Label("Start :");
        Start.setBounds(40,80,40,20);
        add(Start);
        
        start=new JComboBox();
        start.addItem("Dhaka");
        start.setBounds(100,80,80,20);
        add(start);
        
        End=new Label("End :");
        End.setBounds(40,120,40,20);
        add(End);
        
        end=new JComboBox();
        end.addItem("Chittagong");
        end.addItem("Sylhet");
        end.addItem("Jessore");
        end.addItem("Barisal");
        end.addItem("Rajshahi");
        end.addItem("Cox-Bazar");
        end.setBounds(100,120,80,20);
        add(end);
        
        Date=new Label("Date :");
        Date.setBounds(40,160,40,20);
        add(Date);
        
        date=new TextField();
        date.setBounds(100,160,80,20);
        add(date);
        
        Dformat=new Label("(YYYY-MM-DD)");
        Dformat.setBounds(180,160,100,20);
        add(Dformat);
        
        Time=new Label("Time :");
        Time.setBounds(40,200,40,20);
        add(Time);
        
        time=new JComboBox();
        time.addItem("08:00:00");
        time.addItem("02:00:00");
        time.setBounds(80,200,100,20);
        add(time);
        
        search=new Button("Search");
        search.setBounds(300,350,60,20);
        add(search);
        
        /*cancel=new Button("Cancel");
        cancel.setBounds(370,350,60,20);
        add(cancel);*/
        
        search.addActionListener(this);
        
        
        setLayout(null);
        
        
        
    }
    
    public static void main(String[] args){
        Search s1=new Search();
        s1.setVisible(true);
        s1.addWindowListener(new WindowSensor());
    }
    
    public void actionPerformed(ActionEvent e){
        String s1,s2;
        s1=search.getActionCommand();
        //s2=cancel.getActionCommand()
        
        
        
        //JOptionPane.showMessageDialog(this, time.getSelectedItem());
        }
        
    }
