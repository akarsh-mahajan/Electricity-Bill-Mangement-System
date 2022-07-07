package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CustomerDetails extends JFrame implements ActionListener{
 
    JTable table1;
    JButton b1;
    String x[] = {"Customer Name","Meter Number","Address","City","State","Email","Phone"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    CustomerDetails(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(400,150);
        
        try{
            Conn c1  = new Conn();
            String s1 = "select * from customer";
            ResultSet res  = c1.s.executeQuery(s1);
            while(res.next()){
                y[i][j++]=res.getString("name");
                y[i][j++]=res.getString("meter");
                y[i][j++]=res.getString("address");
                y[i][j++]=res.getString("city");
                y[i][j++]=res.getString("state");
                y[i][j++]=res.getString("email");
                y[i][j++]=res.getString("phone");
                i++;
                j=0;
            }
            table1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"North");
        JScrollPane sp = new JScrollPane(table1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            table1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new CustomerDetails().setVisible(true);
    }
    
}
