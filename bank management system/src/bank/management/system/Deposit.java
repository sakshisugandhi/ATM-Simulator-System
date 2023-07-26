
package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(0, 0, 900, 900);
    add(label);
    
    JLabel text = new JLabel("Enter The Amount You Want To Deposit");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    text.setBounds(170, 300, 400, 20);
    label.add(text);
    
    amount = new JTextField();
    amount.setBounds(170,350,320,25);
    amount.setFont(new Font("Raleway",Font.BOLD,22));
    label.add(amount);
    
    deposit = new JButton("Deposit");
    deposit.setBounds(355, 485, 150, 30);
    label.add(deposit);
    deposit.addActionListener(this);
    
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
        if(ae.getSource() == deposit){
          String number = amount.getText();
          Date date = new Date();
          if(number.equals("")){
              JOptionPane.showMessageDialog(null, "Please Enter Amount You Want To Deposit");
          }
          else{
              try{
              Conn c = new Conn();
            String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"') ";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "RS "+number+" Deposited Successfully");
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
        new Deposit("");
    }
    
}
