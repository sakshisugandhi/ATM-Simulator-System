
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(0, 0, 900, 900);
    add(label);
    
    JLabel text = new JLabel("Please Select Your Transactions");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    text.setBounds(210, 300, 700, 35);
    label.add(text);
    
    deposit = new JButton("Deposit");
    deposit.setBounds(170, 415, 150, 30);
    label.add(deposit);
    deposit.addActionListener(this);
    
    withdrawl = new JButton("Cash Withdrawl");
    withdrawl.setBounds(355, 415, 150, 30);
    label.add(withdrawl);
    withdrawl.addActionListener(this);
    
    fastcash = new JButton("Fast Cash");
    fastcash.setBounds(170, 450, 150, 30);
    label.add(fastcash);
    fastcash.addActionListener(this);
    
    ministatement = new JButton("Mini Statement");
    ministatement.setBounds(355, 450, 150, 30);
    label.add(ministatement);
    ministatement.addActionListener(this);
    
    pinchange = new JButton("Pin Change");
    pinchange.setBounds(170, 485, 150, 30);
    label.add(pinchange);
    pinchange.addActionListener(this);
    
    balanceenquiry = new JButton("Balance Enquiry");
    balanceenquiry.setBounds(355, 485, 150, 30);
    label.add(balanceenquiry);
    balanceenquiry.addActionListener(this);
    
    exit = new JButton("Exit");
    exit.setBounds(355, 520, 150, 30);
    label.add(exit);
    exit.addActionListener(this);
    
    
    
    setSize(900,900);
    setLocation(300,0);
    //setUndecorated(true);
    setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        if(ae.getSource() == deposit){
         setVisible(false);
         new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawl){
            setVisible(false);
         new Withdraw(pinnumber).setVisible(true);
        }
         else if(ae.getSource() == fastcash){
            setVisible(false);
         new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == pinchange){
            setVisible(false);
         new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == balanceenquiry){
            setVisible(false);
         new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == ministatement){
         new MiniStatement(pinnumber).setVisible(true);
        }
    }


    
    public static void main(String[] args) {
new Transactions("");
        
    }   
}
