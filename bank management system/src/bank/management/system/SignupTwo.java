
package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    
    JTextField panTextField,aadharTextField;
    JButton next;
    
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String formno;
    SignupTwo(String formno){
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
         JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(100,140,100,30);
        add(Religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
       
        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,190,200,30);
        add(Category);
        
        String valcategory [] = {"General","OBC","SC","ST"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100,240,200,30);
        add(Income);
        
        
        String incomecategory [] = {"Null","<1,50,000","2,50,000","<5,00,0000","upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        
        JLabel Educational = new JLabel("Educational");
        Educational.setFont(new Font("Raleway",Font.BOLD,20));
        Educational.setBounds(100,290,200,30);
        add(Educational);
        
        String educationalValues [] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","others"};
        education = new JComboBox(educationalValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway",Font.BOLD,20));
        Qualification.setBounds(100,315,200,30);
        add(Qualification);
        
        
        
        JLabel Occupation = new JLabel("Occupational:");
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);
        
        String OccupationalValues [] = {"Salaried","Self-Employed","Bussiness","Student","Retired","others"};
        occupation = new JComboBox(OccupationalValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorCitizen.setBounds(100,540,200,30);
        add(seniorCitizen);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel existing = new JLabel(" Existing Account:");
         existing.setFont(new Font("Raleway",Font.BOLD,20));
         existing.setBounds(95,590,200,30);
        add( existing);
        
         eyes = new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
    getContentPane().setBackground(Color.WHITE);
    
    setSize(850,800);
    setLocation(350,10);
    setVisible(true);
    
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String Religion = (String)religion.getSelectedItem();
        String Category = (String)category.getSelectedItem();
        String Income = (String)income.getSelectedItem();
        String Education = (String)education.getSelectedItem();
        String Occupation = (String)occupation.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "YES";
        }
        else{
            seniorCitizen = "NO";
        }
        String existingAccount = null;
        
        if(eyes.isSelected()){
            existingAccount = "YES";
        }
        else if(eno.isSelected()){
            existingAccount = "NO";
        }
        
        String Pan = panTextField.getText();
        String Aadhar = aadharTextField.getText();
        
        try{
         
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+Religion+"','"+Category+"','"+Income+"','"+Education+"','"+Occupation+"','"+seniorCitizen+"','"+existingAccount+"','"+Pan+"','"+Aadhar+"') ";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);
         }
        catch(Exception e){
            System.out.println(e);
        }
    }
   
    

public static void main(String args[]){
    new SignupTwo("");
}
}
