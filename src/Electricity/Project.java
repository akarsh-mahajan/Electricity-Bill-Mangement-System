package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    String meter;
    Project(String meter, String person){
        super("Electricity Billing System");
        this.meter = meter;
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(800,600);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("icon/MainPage.jpg"));
        Image i = ic.getImage().getScaledInstance(1900, 1069,Image.SCALE_DEFAULT);
        ImageIcon icc = new ImageIcon(i);
        JLabel l1 = new JLabel(icc);
        add(l1);
       
 
        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("Admin");
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Deposit Details");
        JMenuItem m4 = new JMenuItem("Calculate Bill");
        mb.setBackground(Color.DARK_GRAY);
        master.setFont(new Font("Regular",Font.PLAIN,18));
        master.setForeground(Color.WHITE);
        
        
        m1.setFont(new Font("monospaced",Font.PLAIN,16));
        m1.setBackground(Color.WHITE);
        
        m2.setFont(new Font("monospaced",Font.PLAIN,16));
        m2.setBackground(Color.WHITE);
        
        m3.setFont(new Font("monospaced",Font.PLAIN,16));
        m3.setBackground(Color.WHITE);
        
        m4.setFont(new Font("monospaced",Font.PLAIN,16));
        m4.setBackground(Color.WHITE);
        
        
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        
        
        
        JMenu info = new JMenu("Information");
        JMenuItem info1 = new JMenuItem("Update Information");
        JMenuItem info2 = new JMenuItem("View Information");
        
        info.setForeground(Color.WHITE);
        info.setFont(new Font("Regular",Font.PLAIN,18));

        info1.setFont(new Font("monospaced",Font.PLAIN,16));
        info1.setBackground(Color.WHITE);

        info2.setFont(new Font("monospaced",Font.PLAIN,16));
        info2.setBackground(Color.WHITE);
        
        info1.addActionListener(this);
        info2.addActionListener(this);
        
        

        JMenu user = new JMenu("User");
        JMenuItem u1 = new JMenuItem("Pay Bill");
        
        JMenuItem u3 = new JMenuItem("Bill Details");
        user.setForeground(Color.WHITE);
        user.setFont(new Font("Regular",Font.PLAIN,18));
        u1.setFont(new Font("monospaced",Font.PLAIN,16));
        u1.setBackground(Color.WHITE);

        u3.setFont(new Font("monospaced",Font.PLAIN,16));
        u3.setBackground(Color.WHITE);
        
        
        u1.addActionListener(this);
        u3.addActionListener(this);

        JMenu report = new JMenu("Report");
        JMenuItem r1 = new JMenuItem("Generate Bill");
        report.setForeground(Color.WHITE);
        report.setFont(new Font("Regular",Font.PLAIN,18));
        r1.setFont(new Font("monospaced",Font.PLAIN,16));
        r1.setBackground(Color.WHITE);
        
        r1.addActionListener(this);
        
        JMenu exit = new JMenu("Logout");
        JMenuItem ex = new JMenuItem("Logout");
        JMenuItem by= new JMenuItem("Exit");
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Regular",Font.PLAIN,18));
        ex.setFont(new Font("monospaced",Font.PLAIN,16));
        ex.setBackground(Color.WHITE);
        
        by.setFont(new Font("monospaced", Font.PLAIN,16));
        by.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        by.addActionListener(this);

        master.add(m1);
        master.add(m2);
        master.add(m3);
        master.add(m4);
        
        info.add(info1);
        info.add(info2);
        
        user.add(u1);
        user.add(u3);
        
        report.add(r1);
        exit.add(ex);
        exit.add(by);
         
        if(person.equals("Admin")){
            mb.add(master);
        }else{             
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(exit);
        
        setJMenuBar(mb);    
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent button_pressed){
        String msg = button_pressed.getActionCommand();
        if(msg.equals("Customer Details")){
            new CustomerDetails().setVisible(true);
            
        }
        else if(msg.equals("New Customer")){
            new NewCustomer().setVisible(true);
            
        }
        else if(msg.equals("Calculate Bill")){
            new CalculateBill().setVisible(true);
            
        }
        else if(msg.equals("Pay Bill")){
            new PayBill(meter).setVisible(true);
           
        }
        else if(msg.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }
        else if(msg.equals("Exit")){
            System.exit(0);
        }
        else if(msg.equals("Generate Bill")){
            new GenerateBill(meter).setVisible(true);
            
        }
        else if(msg.equals("Deposit Details")){
            new DepositDetails().setVisible(true);
        }
        else if(msg.equals("View Information")){
            new ViewInformation(meter).setVisible(true);
        }
        else if(msg.equals("Update Information")){
            new UpdateInformation(meter).setVisible(true);
        }
        else if(msg.equals("Bill Details")){
            new BillDetails(meter).setVisible(true);
        }
        
        
    }
    
    
    public static void main(String[] args){
        new Project("", "").setVisible(true);
    }
    
}