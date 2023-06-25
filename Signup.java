import javax.print.Doc;
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;

import com.sun.tools.jconsole.JConsoleContext;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.*;

public class Signup extends JFrame implements ActionListener {
    int x;
    JTextField nameTextField,fnameTextField,enameTextField,addressTextField,cityTextField,stateTextField,pinTextField,aadharTextField;
    JButton next,back;
    JComboBox cat;
    JRadioButton male,female,married,unmarried;
    JDateChooser dateChooser;
    Signup(){
        setLayout(null);
        Random ran=new Random();
        x=Math.abs(ran.nextInt()) % 1000;

        JPanel jp=new JPanel();
        jp.setBounds(0,0,750,110);
        jp.setBackground(new Color(221, 173, 117));
        jp.setLayout(null);
        add(jp);

        JLabel formno=new JLabel("APPLICATION FORM NO. " + x);
        formno.setFont(new Font("Raleway",Font.BOLD,36));
        formno.setBounds(175,20,600,40);//This works only when setLayout is null..
        jp.add(formno);

        JLabel personDetails=new JLabel("Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(285,70,400,30);//This works only when setLayout is null..

        jp.add(personDetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,130,100,30);//This works only when setLayout is null..
        add(name);

        /*JTextField*/ nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,13));
        nameTextField.setBounds(250,130,400,30);
        add(nameTextField);

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,180,400,30);//This works only when setLayout is null..
        add(fname);

        /*JTextField*/ fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,13));
        fnameTextField.setBounds(250,180,400,30);
        add(fnameTextField);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,230,400,30);//This works only when setLayout is null..
        add(dob);

        /*JDateChooser*/ dateChooser=new JDateChooser();
        dateChooser.setBounds(250,230,400,30);
        dateChooser.setForeground(Color.black);
        dateChooser.setFont(new Font("Raleway",Font.BOLD,15));
        add(dateChooser);//add the jcalender in library..

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,280,400,30);//This works only when setLayout is null..
        add(gender);

        /*JRadioButton*/ male=new JRadioButton("Male");
        male.setBounds(300,280,60,30);
        male.setBackground(Color.white);
        add(male);
        /*JRadioButton*/ female=new JRadioButton("Female");
        female.setBounds(450,280,120,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();//If one is selected the other is deselected..
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email=new JLabel("E-mail:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,330,400,30);//This works only when setLayout is null..
        add(email);

        /*JTextField*/ enameTextField=new JTextField();
        enameTextField.setFont(new Font("Raleway",Font.BOLD,13));
        enameTextField.setBounds(250,330,400,30);
        add(enameTextField);

        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(96,380,400,30);//This works only when setLayout is null..
        add(aadhar);

        aadharTextField =new JTextField();
        aadharTextField.setBounds(250,380,400,30);
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,13));
        add(aadharTextField);

        JLabel Occp=new JLabel("Occupation:");
        Occp.setFont(new Font("Raleway",Font.BOLD,20));
        Occp.setBounds(100,430,400,30);//This works only when setLayout is null..
        add(Occp);

        String[] b={"Employee","Student","Business","Others"};
        cat=new JComboBox(b);
        cat.setBounds(250,430,400,30);
        cat.setBackground(Color.white);
        add(cat);
        

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,480,400,30);//This works only when setLayout is null..
        add(address);

        /*JTextField*/ addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,13));
        addressTextField.setBounds(250,480,400,30);
        add(addressTextField);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,530,400,30);//This works only when setLayout is null..
        add(city);

        /*JTextField*/ cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,13));
        cityTextField.setBounds(250,530,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,580,400,30);//This works only when setLayout is null..
        add(state);

        /*JTextField*/ stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,13));
        stateTextField.setBounds(250,580,400,30);
        add(stateTextField);

        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,630,400,30);//This works only when setLayout is null..
        add(pincode);

        /*JTextField*/ pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,13));
        pinTextField.setBounds(250,630,400,30);
        add(pinTextField);

        /*JButton*/ next=new JButton("Update");
        next.setForeground(Color.black);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(550,700,100,30);
        next.addActionListener(this);
        add(next);

         back=new JButton("Back");
        back.setForeground(Color.black);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBounds(550,750,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/kiss.jpg"));
        Image i2=i1.getImage().getScaledInstance(180,110,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(0,0,170,110);
        jp.add(i4);

        JFileChooser jf=new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        getContentPane().setBackground(Color.white);

        setSize(750,800);
        setLocation(350,20);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Front("").setVisible(true);

        }
        else {
            String formno = "" + x;//coverting x to string;
            String name = nameTextField.getText().toUpperCase();
            String fname = fnameTextField.getText().toUpperCase();
            String dob = ((JTextField) (dateChooser.getDateEditor().getUiComponent())).getText();

            String gender = null;
            if (male.isSelected())
                gender = "Male";
            else
                gender = "Female";
            String email = enameTextField.getText();

            String aadhar = aadharTextField.getText();
            String occupation = (String) cat.getSelectedItem();

            String address = addressTextField.getText().toUpperCase();
            String city = cityTextField.getText().toUpperCase();
            String state = stateTextField.getText().toUpperCase();
            String pin = pinTextField.getText();

            try {
                if (name.equals("")) {//LIke this we can add validations for everyfield...
                    JOptionPane.showMessageDialog(null, "Name is required ");
                    if (ae.getSource() == next)
                        setVisible(true);
                } else if (fname.equals("")) {//LIke this we can add validations for everyfield...
                    JOptionPane.showMessageDialog(null, "Father's name is required ");
                    if (ae.getSource() == next)
                        setVisible(true);
                } else if (address.equals("")) {//LIke this we can add validations for everyfield...
                    JOptionPane.showMessageDialog(null, "Address is required ");
                    if (ae.getSource() == next)
                        setVisible(true);
                } else if (pin.equals("")|| pin.length()!=6) {//LIke this we can add validations for everyfield...
                    JOptionPane.showMessageDialog(null, "Enter Valid Pincode");
                    if (ae.getSource() == next)
                        setVisible(true);
                }else if (email.equals("") || (!email.contains("@"))) {//LIke this we can add validations for everyfield...
                    JOptionPane.showMessageDialog(null, "Enter Valid e-mail");
                    if (ae.getSource() == next)
                        setVisible(true);
                }
                else if (aadhar.equals("") || aadhar.length() != 12) {//LIke this we can add validations for everyfield...
                    JOptionPane.showMessageDialog(null, "AadharNumber is not valid ");
                    if (ae.getSource() == next)
                        setVisible(true);
                } else if (occupation.equals("")) {//LIke this we can add validations for everyfield...
                    JOptionPane.showMessageDialog(null, "Occupation is required ");
                    if (ae.getSource() == next)
                        setVisible(true);
                } else {
                    Conn c = new Conn();//for creating conncection...
                    String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + aadhar + "','" + occupation + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                    c.s.executeUpdate(query);//the query runs in the mysql..
                    setVisible(false);
                    new Front("").setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Signup();
    }

}
