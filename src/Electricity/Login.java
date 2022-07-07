package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3, l4;
    JTextField tf1;
    JPasswordField pass_field;
    JButton b1,b2, b3;
    JPanel p1,p2,p3,p4;
    Choice c1;
    Login(){
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        
        l1 = new JLabel("Username");
        l1.setBounds(300, 40, 100, 20);
        l1.setForeground(Color.WHITE);
        add(l1);
        l2 = new JLabel("Password");
        l2.setBounds(300, 80, 100, 20);
        l2.setForeground(Color.WHITE);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(400, 40, 150, 20);
        add(tf1);
        pass_field = new JPasswordField(15);
        pass_field.setBounds(400, 80, 150, 20);
        add(pass_field);
        
        l4 = new JLabel("Logging in as");
        l4.setBounds(300, 120, 100, 20);
        l4.setForeground(Color.WHITE);
        add(l4);
        
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(400, 120, 150, 20);
        add(c1);
        
        b1 = new JButton("Login");
        b1.setBounds(330, 160, 100, 20);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(450, 160, 100, 20);
        add(b2);
        

        b3 = new JButton("Signup");
        b3.setBounds(380, 200, 130, 20);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);


        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i = ic.getImage().getScaledInstance(150, 200,Image.SCALE_DEFAULT);
        ImageIcon icc = new ImageIcon(i);
        l3 = new JLabel(icc);
        l3.setBounds(0, 0, 250, 250);
        add(l3);
        
        setLayout(new BorderLayout());
    
     
        setSize(640,300);
        setLocation(600,300);
        setVisible(true);
        

        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{        
                Conn c = new Conn();
                String a  = tf1.getText();
                String b  = pass_field.getText();
                String user = c1.getSelectedItem();
                String q  = "select * from login where username = '"+a+"' and password = '"+b+"' and user = '"+user+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    String meter = rs.getString("meter");
                    new Project(meter, user).setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pass_field.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == b2){
            System.exit(0);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}



