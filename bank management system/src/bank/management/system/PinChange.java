
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin , repin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnnumber) {
        setLayout(null);
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(0, 0, 900, 900);
    add(label);
    
    JLabel text = new JLabel("CHANGE YOUR PIN");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    text.setBounds(250, 280, 500, 35);
    label.add(text);
    
    JLabel pintext = new JLabel("New PIN: ");
    pintext.setForeground(Color.WHITE);
    pintext.setFont(new Font("System", Font.BOLD,16));
    pintext.setBounds(165, 320, 180, 25);
    label.add(pintext);
    
    pin = new JPasswordField();
    pin.setFont(new Font("Raleway", Font.BOLD,25));
    pin.setBounds(330, 320, 180, 25);
    label.add(pin);
    
    JLabel repintext = new JLabel("Re-Enter New PIN:");
    repintext.setForeground(Color.WHITE);
    repintext.setFont(new Font("System", Font.BOLD,16));
    repintext.setBounds(165, 360, 180, 25);
    label.add(repintext);
    
    repin = new JPasswordField();
    repin.setFont(new Font("Raleway", Font.BOLD,25));
    repin.setBounds(330, 360, 180, 25);
    label.add(repin);
    
    change = new JButton("Change");
    change.setBounds(355, 485, 150, 30);
    label.add(change);
    change.addActionListener(this);
    
    back = new JButton("Back");
    back.setBounds(355, 520, 150, 30);
    label.add(back);
    back.addActionListener(this);
    
    setSize(900,900);
    setLocation(300,0);
    //setUndecorated(true);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){
            try{
          String npin = pin.getText();
          String rpin = repin.getText();
          if(!npin.equals(rpin)){
              JOptionPane.showMessageDialog(null, "Entered PIN Does Not Match");
              return;
          }
          if(npin.equals("")){
              JOptionPane.showMessageDialog(null, "Please Enter New PIN");
              return;
          }
          if(rpin.equals("")){
              JOptionPane.showMessageDialog(null, "Please re-Enter New PIN");
              return;
          }
            
          Conn conn = new Conn();
          String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
          String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
          String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
          
          conn.s.executeUpdate(query1);
          conn.s.executeUpdate(query2);
          conn.s.executeUpdate(query3);
          
          JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
          setVisible(false);
          new Transactions(rpin).setVisible(true);
        }
        
        catch(Exception e){
        System.out.println(e);   
        }
    }
    
        else{
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
        }
    
    }


   
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
