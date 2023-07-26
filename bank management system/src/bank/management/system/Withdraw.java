package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdraw extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdraw(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(0, 0, 900, 900);
    add(label);
    
    JLabel text = new JLabel("Enter The Amount You Want To Withdraw");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    text.setBounds(170, 300, 400, 20);
    label.add(text);
    
    amount = new JTextField();
    amount.setBounds(170,350,320,25);
    amount.setFont(new Font("Raleway",Font.BOLD,22));
    label.add(amount);
    
    withdraw = new JButton("Withdraw");
    withdraw.setBounds(355, 485, 150, 30);
    label.add(withdraw);
    withdraw.addActionListener(this);
    
    back= new JButton("Back");
    back.setBounds(355, 520, 150, 30);
    label.add(back);
    back.addActionListener(this);
    
    
    
    
    setSize(900,900);
    setLocation(300,0);
    //setUndecorated(true);
    setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
          String number = amount.getText();
          Date date = new Date();
          if(number.equals("")){
              JOptionPane.showMessageDialog(null, "Please Enter Amount You Want To Withdraw");
          }
          else{
              try{
              Conn c = new Conn();
            String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"') ";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "RS "+number+" Withdraw Successfully");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
              }
              catch(Exception e){
                  System.out.println(e);
              }
          }
          
        }
        
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }
    
    public static void main(String[] args) {
        new Withdraw("");
    }
    
}

