/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

/**
 *
 * @author nahid
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Registration extends Frame{
	Label Firstname,Lastname,Email,Username,Password,Dateofbirth,Gender,Dformat,Gformat;
	TextField firstname,lastname,email,username,password,dateofbirth,gender;
	Button submit,cancel;
	
	
	public Registration(){
		setVisible(true);
		setBounds(100,0,600,600);
		
		Firstname=new Label("First Name");
		Firstname.setBounds(40,80,80,20);
		add(Firstname);
		
		firstname=new TextField();
		firstname.setBounds(140,80,140,20);
		add(firstname);
		
		Lastname=new Label("Last Name");
		Lastname.setBounds(300,80,80,20);
		add(Lastname);
		
		lastname=new TextField();
		lastname.setBounds(400,80,140,20);
		add(lastname);
		
		Email=new Label("Email");
		Email.setBounds(40,140,80,20);
		add(Email);
		
		email=new TextField();
		email.setBounds(140,140,250,20);
		add(email);
		
		Username=new Label("Username");
		Username.setBounds(40,200,80,20);
		add(Username);
		
		username=new TextField();
		username.setBounds(140,200,150,20);
		add(username);
		
		Password=new Label("Password");
		Password.setBounds(40,260,80,20);
		add(Password);
		
		password=new TextField();
		password.setBounds(140,260,100,20);
		add(password);
		
		Dateofbirth=new Label("Date of Birth");
		Dateofbirth.setBounds(40,320,80,20);
		add(Dateofbirth);
		
		dateofbirth=new TextField();
		dateofbirth.setBounds(140,320,120,20);
		add(dateofbirth);
		
		Dformat=new Label("(YYYY-MM-DD)");
		Dformat.setBounds(270,320,100,20);
		add(Dformat);
		
		Gender=new Label("Gender");
		Gender.setBounds(40,380,80,20);
		add(Gender);
		
		gender=new TextField();
		gender.setBounds(140,380,60,20);
		add(gender);
		
		Gformat=new Label("(Male/Female)");
		Gformat.setBounds(210,380,100,20);
		add(Gformat);
		
		submit=new Button("Submit");
		submit.setBounds(250,500,80,20);
		add(submit);
		
		cancel=new Button("Cancel");
		cancel.setBounds(350,500,80,20);
		add(cancel);
		
		setLayout(null);
		
		submit.addActionListener(new ButtonSensor(this));
		cancel.addActionListener(new ButtonSensor(this));
	}
}
class Utility{
	DataAccess d2=new DataAccess();
	int i;
	
	public void submitData(Registration reg){
		boolean flag=true;
		String s1=reg.username.getText();
		
		String sql="INSERT INTO reg (firstname,lastname,email,username,password,dateofbirth,gender) VALUES ('"+reg.firstname.getText()+"','"+reg.lastname.getText()+"' ,'"+reg.email.getText()+"', '"+reg.username.getText()+"', '"+reg.password.getText()+"', '"+reg.dateofbirth.getText()+"', '"+reg.gender.getText()+"')";
		 i=d2.updateDB(sql);
		}
}

class ButtonSensor implements ActionListener{
	Registration rg1;
	Utility u;
public ButtonSensor(Registration r){
	rg1=r;
	u=new Utility();
     }
	 public void actionPerformed(ActionEvent e){
		 boolean flag=true;
		 String s1,s2,s3,s4,s5,s6,s7,s;
		 s1=rg1.firstname.getText();
		 s2=rg1.lastname.getText();
		 s3=rg1.email.getText();
		 s4=rg1.username.getText();
		 s5=rg1.password.getText();
		 s6=rg1.dateofbirth.getText();
		 s7=rg1.gender.getText();
		 s=e.getActionCommand();
		 
		 if(s.equals("Cancel")){
			System.exit(0);
			}
		else{
		 
		 if(s1.length()==0 || s2.length()==0 || s3.length()==0
		 || s4.length()==0 || s5.length()==0 || s6.length()==0 || s7.length()==0){
			 JOptionPane.showMessageDialog(null,"You must provide all information");
			 flag=false;	 
		 }
		 else if(flag && s.equals("Submit")){
			 u.submitData(rg1);
			 //JOptionPane.showMessageDialog(null,"Successfully Registerd");
		 }
		 	 
	 }
	 
  }


}
