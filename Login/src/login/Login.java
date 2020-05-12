package login;

/**
 *
 * @author nahid
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;




 class DataAccess{
    Connection conn;
    String JDBC_DRIVER;  
    String DB_URL;
    Statement stmt;
    String USER;
    String PASS;
    ResultSet rs;
    public DataAccess(){
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/myproject";
        USER = "root";
        PASS = "";
	   
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void close()throws SQLException{
        if(rs!=null)rs.close();
        if(rs!=null)stmt.close();
    }
    public ResultSet getData(String query) {
        try{
            stmt = conn.createStatement();
            rs= stmt.executeQuery(query);
            //System.out.println("Info from DB");
        }
        catch(Exception ex){
            System.out.println("DB Read Error !");
            //ex.printStackTrace();
        }
        return rs;
   }
    public int updateDB(String sql){
        int numOfRowsUpdated=0;
        try{
            stmt = conn.createStatement(); 
            numOfRowsUpdated=stmt.executeUpdate(sql);
            System.out.println(numOfRowsUpdated+" row(s) updated");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return numOfRowsUpdated;
       }
	public static void main(String[] args){
		new DataAccess();
      }
}


class Final extends JFrame{
    String firstname,lastname,start,end,date,time,not,fare,classs;
    Label Firstname,Lastname,Start,End,Date,Time,Class,NoOfTickets,Cost,Confirmation,Print;
    Label fname,lname,sstart,eend,ddate,ttime,cclass,nnot,ccost,Information;
    Button ok,print,close;
    
    public Final(String firstname,String lastname,String start,String end,
                        String date,String time,String not,String fare,String classs){
        
        super("Confirmation and Ticket");
        
       
        getContentPane().setBackground( Color.CYAN );
        this.firstname=firstname;
        this.lastname=lastname;
        this.start=start;
        this.end=end;
        this.date=date;
        this.time=time;
        this.not=not;
        this.fare=fare;
        this.classs=classs;
        
        /*System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(start);
        System.out.println(end);
        System.out.println(date);
        System.out.println(time);
        System.out.println(classs);
        System.out.println(not);
        System.out.println(fare);*/
        
     Firstname=new Label("First Name :");
     Firstname.setBounds(40,80,80,20);
     add(Firstname);
     
     Lastname=new Label("Last Name :");
     Lastname.setBounds(40,120,80,20);
     add(Lastname);
     
     Start=new Label("From :");
     Start.setBounds(40,160,80,20);
     add(Start);
     
     End=new Label("To :");
     End.setBounds(40,200,80,20);
     add(End);
     
     Date=new Label("Date :");
     Date.setBounds(40,240,80,20);
     add(Date);
     
     Time=new Label("Time :");
     Time.setBounds(40,280,80,20);
     add(Time);
     
     Class=new Label("Class :");
     Class.setBounds(40,320,80,20);
     add(Class);
     
     NoOfTickets=new Label("No Of Tickets :");
     NoOfTickets.setBounds(40,360,80,20);
     add(NoOfTickets);
     
     Cost=new Label("Total Cost :");
     Cost.setBounds(40,400,80,20);
     add(Cost);
    
     fname=new Label();
     fname.setBounds(130,80,80,20);
     add(fname);
     
     lname=new Label();
     lname.setBounds(130,120,80,20);
     add(lname);
     
     sstart=new Label();
     sstart.setBounds(130,160,80,20);
     add(sstart);
     
     eend=new Label();
     eend.setBounds(130,200,80,20);
     add(eend);
     
     ddate=new Label();
     ddate.setBounds(130,240,80,20);
     add(ddate);
     
     ttime=new Label();
     ttime.setBounds(130,280,80,20);
     add(ttime);
     
     cclass=new Label();
     cclass.setBounds(130,320,80,20);
     add(cclass);
     
     nnot=new Label();
     nnot.setBounds(130,360,80,20);
     add(nnot);
     
     ccost=new Label();
     ccost.setBounds(130,400,80,20);
     add(ccost);
     
    // fname.setText(firstname);
     fname.setText(firstname);
     lname.setText(lastname);
     sstart.setText(start);
     eend.setText(end);
     ddate.setText(date);
     ttime.setText(time);
     cclass.setText(classs);
     nnot.setText(not);
     ccost.setText(fare);
     
     Confirmation=new Label("For Confirmation Please Press 'Ok' ");
     Confirmation.setBounds(40,450,300,50);
     Confirmation.setFont(new Font("Calibri",Font.BOLD,15));
     add(Confirmation);
    
     ok=new Button("Ok");
     ok.setBounds(350,500,40,20);
     add(ok);
     
     print=new Button("Print");
     print.setBounds(400,500,50,20);
     add(print);
     
     Information=new Label("Airline Ticket");
     Information.setBounds(200,15,300,40);
     Information.setFont(new Font("Calibri",Font.BOLD,15));
     add(Information);
                
     close=new Button("Close");
     close.setBounds(460,500,40,20);
     add(close);
     
     ok.addActionListener(new OkButtonSensor(this));
     print.addActionListener(new OkButtonSensor(this));
     close.addActionListener(new OkButtonSensor(this));
     
     
     setLayout(null);
        
        
        
        
    }
}



class Utility1{
    
    DataAccess d8=new DataAccess();
	int i;
	
	public void submitData(Final f){
		boolean flag=true;
		//String s1=reg.username.getText();
		
		String sql="INSERT INTO final (firstname,lastname,start,end,date,time,class,nooftickets,cost) VALUES ('"+f.fname.getText()+"',"
                        + "'"+f.lname.getText()+"' ,'"+f.sstart.getText()+"', '"+f.eend.getText()+"', '"+f.ddate.getText()+"'"
                        + ", '"+f.ttime.getText()+"', '"+f.cclass.getText()+"', '"+f.nnot.getText()+"', '"+f.ccost.getText()+"')";
		 i=d8.updateDB(sql);
                 JOptionPane.showMessageDialog(f,"Successfully Reserved");
                  //f.dispose();
		}
        
 }




class OkButtonSensor implements ActionListener{
    Final f1;
    Utility1 u1;
    public OkButtonSensor(Final f2){
        f1=f2;
        u1=new Utility1();
    }
    public void actionPerformed(ActionEvent a){
        boolean flag=true;
        String s=a.getActionCommand();
        
        if(flag && s.equals("Ok")){
            u1.submitData(f1);
        }
         if(flag && s.equals("Print")){
            JOptionPane.showMessageDialog(f1,"Yout Ticket Is Printing");
            //System.exit(0);
        }
         if(flag && s.equals("Close")){
            JOptionPane.showMessageDialog(f1,"System Is Closing");
            System.exit(0);
        }
        
        
    }
}

class Submit extends JFrame implements ActionListener{
    
    JComboBox classs;
    Label Class,NoOfTickets,Information;
    Button submit;
    TextField not;
    String routekey2,firstname,lastname,start,end,date,time,fare;
    int f;
    ResultSet rs=null;
    DataAccess d4=new DataAccess();
    
    public Submit(String routekey1,String firstname,String lastname,String start,
                           String end,String time,String date){
        
        super("Submit");
        
        getContentPane().setBackground( Color.PINK );
        
        this.firstname=firstname;
        this.lastname=lastname;
        this.start=start;
        this.end=end;
        this.date=date;
        this.time=time;
        
        routekey2=routekey1;
        System.out.println(routekey2);
        
        Class=new Label("Class");
        Class.setBounds(40,80,40,20);
        add(Class);
        
        classs=new JComboBox();
        classs.addItem("Economy");
        classs.addItem("Business");
        classs.setBounds(100,80,80,20);
        add(classs);
        
        NoOfTickets=new Label("No. Of Tickets :");
        NoOfTickets.setBounds(40,120,80,20);
        add(NoOfTickets);
        
        not=new TextField();
        not.setBounds(140,120,40,20);
        add(not);
        
        submit=new Button("Submit");
        submit.setBounds(300,300,60,20);
        add(submit);
        
        Information=new Label("Please Submit");
        Information.setBounds(120,15,300,40);
        Information.setFont(new Font("Calibri",Font.BOLD,15));
        add(Information);
                       
        submit.addActionListener(this);
        setLayout(null);
    }
        

        
     public void actionPerformed(ActionEvent e){
            String s1,s2;
            int efare,bfare;
            int s;
            s1 = (String)classs.getSelectedItem();
            s2 = not.getText();
           // s=Integer.parseInt(s2);
           
         if(s2.length()==0){
            JOptionPane.showMessageDialog(this,"Please Enter Number Of Seats You Need");
        }else{
             s=Integer.parseInt(s2);
            String sql2="select * from route where routekey='"+routekey2+"'  ";
            rs=d4.getData(sql2);
            try{
                if(rs.next()){
                    efare=rs.getInt("economyfare");
                    bfare=rs.getInt("businessfare");
                    if(s1=="Economy" && s<=200){
                        f=s*efare;
                        fare=String.valueOf(f);
                        
                        Final ff=new Final(firstname,lastname,start,end,date,time,s2,fare,s1);
                        ff.setSize(600,600);
                        ff.addWindowListener(new WindowSensor());
                        ff.setVisible(true);
                        dispose();
                        
                    }
                    else if(s1=="Business" && s<=50){
                        f=s*bfare;
                        fare=String.valueOf(f);
                        
                        Final ff=new Final(firstname,lastname,start,end,date,time,s2,fare,s1);
                        ff.setSize(600,600);
                        ff.addWindowListener(new WindowSensor());
                        ff.setVisible(true);
                        dispose();
                    }
                    else{
                       JOptionPane.showMessageDialog(this,"Not Available");
                       System.exit(0);
                    }
                }
            }
            catch(SQLException ex){
		ex.printStackTrace();
           }
             //System.out.println(fare);
        }
     }      
        
}

class Search extends JFrame implements ActionListener {
    
    ResultSet rs=null;
    DataAccess d3 = new DataAccess();
    
    JComboBox start,end,time;
    Label Start,End,Date,Time,Dformat,Information;
    TextField date;
    Button search,cancel;
    String routekey1;
    String firstname,lastname;
    
    public Search(String firstname,String lastname){
        super("Search");
        this.firstname=firstname;
        this.lastname=lastname;
        getContentPane().setBackground( Color.GRAY );
        
        setVisible(true);
        addWindowListener(new WindowSensor());
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
        
        
        Information=new Label("Make Your Schdule");
        Information.setBounds(150,15,300,40);
        Information.setFont(new Font("Calibri",Font.BOLD,15));
        add(Information);
        
        search.addActionListener(this);
        
        
        setLayout(null);
        
        
        
    }
    
    public void actionPerformed(ActionEvent e){
        //boolean flag=true;
        
        String s1,s2,s3,s4;

       s1 = (String)start.getSelectedItem();
       s2 = (String)end.getSelectedItem();
       s3 = (String)time.getSelectedItem();
       s4= date.getText();
       System.out.println(s1);
       System.out.println(s2);
       System.out.println(s3);
       
       if(s4.length()==0){
           JOptionPane.showMessageDialog(this,"Please Enter Your Travel Date");
           
       }else{
       String sql="select * from route where start='"+s1+"' and end='"+s2+"' ";
        rs=d3.getData(sql);
        try{
            if(rs.next()){
               // se.dispose();
              String routekey=rs.getString("routekey");
              // System.out.println(routekey);
               
               String sql1="select * from schdule where routekey='"+routekey+"' and time='"+s3+"' ";
               rs=d3.getData(sql1);
               try{
                   if(rs.next()){
                       JOptionPane.showMessageDialog(this,"Seat Available");
                       
                       routekey1=rs.getString("routekey");
                       String time=rs.getString("time");
                       //System.out.println(time);
                      // System.out.println(routekey1);
                       Submit sb =new Submit(routekey1,firstname,lastname,s1,s2,s3,s4);
                       sb.setVisible(true);
                       sb.setBounds(160,0,400,400);
                       sb.addWindowListener(new WindowSensor());
                       dispose();
                   }
                   else{
                       JOptionPane.showMessageDialog(this,"Not Available");
                       
                   }
               }
              catch(SQLException ex){
	    ex.printStackTrace();
               }
            }
         }catch(SQLException ex){
	    ex.printStackTrace();
         }

    }
 }

    private void setString(int i, String s1) {
        
        throw new UnsupportedOperationException("Not supported yet.");
   }
        
}


class WindowSensor extends WindowAdapter{
	
	public void windowClosing(WindowEvent w){
		System.out.println("Window is cloasing");
		System.exit(0);
	}
}




class Registration extends JFrame{
	Label Firstname,Lastname,Email,Username,Password,Dateofbirth,Gender,Dformat,Information;
	TextField firstname,lastname,email,username,password,dateofbirth;
	Button submit,cancel,back;
        JComboBox gender;
	
	
	public Registration(){
                super("Registration");
                getContentPane().setBackground( Color.LIGHT_GRAY );
		setVisible(true);
		setBounds(100,0,600,650);
		
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
                
                gender=new JComboBox();
                gender.addItem("Male");
                gender.addItem("Female");
                gender.setBounds(140,380,60,20);
                add(gender);
                		
		submit=new Button("Submit");
		submit.setBounds(250,500,80,20);
		add(submit);
                
                back=new Button("Back");
		back.setBounds(350,500,80,20);
		add(back);
		
		cancel=new Button("Cancel");
		cancel.setBounds(450,500,80,20);
		add(cancel);
                
                Information=new Label("Please Submit Your Information");
                Information.setBounds(180,15,300,40);
                Information.setFont(new Font("Calibri",Font.BOLD,15));
                add(Information);
		
		setLayout(null);
		
		submit.addActionListener(new ButtonSensor(this));
		cancel.addActionListener(new ButtonSensor(this));
                back.addActionListener(new ButtonSensor(this));
	}
}
class Utility{
	DataAccess d2=new DataAccess();
        ResultSet rs;
	int i;
        String s2;
	
	public void submitData(Registration reg){
		boolean flag=true;
		String s1=reg.username.getText();
                System.out.println(s1);
                String sql1="select username from reg where username='"+s1+"'";
                rs=d2.getData(sql1);
                
              try{ 
                
                 if(rs.next()){
                          s2=rs.getString("username");
                         // System.out.println(s2);
                          JOptionPane.showMessageDialog(reg,"This Username Already Taken");
                
                       }else{
		          String sql="INSERT INTO reg (firstname,lastname,email,username,password,dateofbirth,gender)"
                        + " VALUES ('"+reg.firstname.getText()+"','"+reg.lastname.getText()+"' ,'"+reg.email.getText()+"', '"+reg.username.getText()+"', '"+reg.password.getText()+"', "
                        + "'"+reg.dateofbirth.getText()+"', '"+(String)reg.gender.getSelectedItem()+"')";
		        i=d2.updateDB(sql);
                 
                        JOptionPane.showMessageDialog(reg,"Successfully Registerd");
                        reg.dispose();        
                 
		        }
                     }
             
                    catch(SQLException ex){
			 ex.printStackTrace();
	  }
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
		 s7=(String)rg1.gender.getSelectedItem();
		 s=e.getActionCommand();
		 
		 if(s.equals("Cancel")){
			System.exit(0);
			}
                 
                 else if(s.equals("Back")){
                     LoginFrame lf=new LoginFrame();
                     rg1.dispose();
	             lf.addWindowListener(new WindowSensor());
		}else{
		 
		 if(s1.length()==0 || s2.length()==0 || s3.length()==0
		 || s4.length()==0 || s5.length()==0 || s6.length()==0 || s7.length()==0){
	         JOptionPane.showMessageDialog(rg1,"You must provide all information");
	         flag=false;
                 
		 }else if(s5.length()<5){
                     JOptionPane.showMessageDialog(rg1,"Password is too short please provide at least 5 character");
                 }
                 else if(s4.length()<5){
                     JOptionPane.showMessageDialog(rg1,"Username is too short please provide at least 5 character");
                 }
                 
		 else if(flag && s.equals("Submit")){
			 u.submitData(rg1);
		}
		 	 
	}
	 
  }
}



 class LoginFrame extends JFrame{
	  Label userName,passWord,welcome,Information;
	  TextField username;
          JPasswordField password;
	  Button login,registration;
        
	
 public LoginFrame(){
                super("Login");
		setSize(600,500);
                getContentPane().setBackground( Color.LIGHT_GRAY );
                
                
		userName=new Label("Username");
		userName.setBounds(40,80,80,20);
		add(userName);
		
		username=new TextField();
		username.setBounds(140,80,140,20);
		add(username);
		
		passWord=new Label("Password");
		passWord.setBounds(40,140,80,20);
		add(passWord);
		
		password=new JPasswordField();
                password.setEchoChar('*');
		password.setBounds(140,140,140,20);
		add(password);
		
		login=new Button("Login");
		login.setBounds(140,200,50,20);
		add(login);
		
		registration=new Button("Registration");
		registration.setBounds(200,200,80,20);
		add(registration);
                
                login.addActionListener(new loginButtonSensor(this));
		registration.addActionListener(new loginButtonSensor(this));
                
                setLayout(null);
                setVisible(true);
                
                //dispose();
                
                welcome=new Label("Welcome To Airline Reservation System");
                welcome.setBounds(150,20,300,40);
                welcome.setFont(new Font("Calibri",Font.BOLD,15));
                add(welcome);
                
                Information=new Label("*If you don't have username and password please go to registration*");
                Information.setBounds(40,300,500,40);
                Information.setFont(new Font("Calibri",Font.BOLD,15));
                add(Information);
                
        }
		
}

       
        
class loginButtonSensor implements ActionListener{
        String firstname,lastname;
        LoginFrame fm;
        ResultSet rs=null;
	DataAccess d1=new DataAccess();
       
        public loginButtonSensor(LoginFrame l){
           fm=l; 
        }
        
	public void actionPerformed(ActionEvent a){
		boolean flag=true;
		String s1,s2;
		String s=a.getActionCommand();
		s1=fm.username.getText();
		s2=fm.password.getText();
                
		if(s.equals("Registration")){
			Registration rg=new Registration();
			rg.addWindowListener(new WindowSensor());
		}
		else{
			
			if(s1.length()==0 || s2.length()==0){
			JOptionPane.showMessageDialog(fm,"You must provide User name and Password");
			flag=false;
                        
		}
		else if(flag && s.equals("Login")){
                    
			String sql="select * from reg where username='"+s1+"' and password='"+s2+"'";
			rs=d1.getData(sql);
                        
			try{
				if(rs.next()){
                                         //fm.dispose();
                                        firstname=rs.getString("firstname");
                                        lastname=rs.getString("lastname");
                                        
                                        new Search(firstname,lastname);
                                        
					//Do everything after login from here
					/*Search se=new Search();
					se.setVisible(true);
		                        se.addWindowListener(new WindowSensor());*/
                                        fm.dispose();
                 
					
				}else{
					JOptionPane.showMessageDialog(fm,"You must need to provide Valid User name and Password");
				}
                                
				d1.close();
			}
                        
			catch(SQLException ex){
				ex.printStackTrace();
		}
	}
		
		
    }
  }
}


public class Login{
 
          public static void main(String[] args){
		LoginFrame lf=new LoginFrame();
		lf.addWindowListener(new WindowSensor());         
	}
}
		



