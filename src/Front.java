import sun.misc.SignalHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.ImageGraphicAttribute;
import java.sql.ResultSet;

public class Front extends JFrame implements ActionListener{
    JButton jb1,jb2,jb3,jb4;
    JTextField t1;
    String aadharnumber,x;

    Front(String aadharnumber){
        this.aadharnumber=aadharnumber;

        setLayout(null);

        ImageIcon i6=new ImageIcon(ClassLoader.getSystemResource("icons/paint.jpg"));
        Image i7=i6.getImage().getScaledInstance(600,500,Image.SCALE_DEFAULT);
        ImageIcon i8=new ImageIcon(i7);
        JLabel i9=new JLabel(i8);
        i9.setBounds(0,0,600,500);
        add(i9);

        JLabel a=new JLabel("Aadhar Database System");
        a.setFont(new Font("System",Font.BOLD,33));
        a.setBounds(190,60,400,38);
        a.setForeground(new Color(20, 71, 72));
        i9.add(a);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/aadhar.png"));
        Image i2=i1.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(30,30,150,100);
        i9.add(i4);

        JLabel adhar=new JLabel("Aadhar Number : ");
        adhar.setFont(new Font("Raleway",Font.BOLD,25));
        adhar.setForeground(new Color(62, 94, 212));
        adhar.setBounds(70,200,300,30);
        i9.add(adhar);

        jb3=new JButton("Search");
        jb3.addActionListener(this);
        jb3.setFont(new Font("Raleway",Font.BOLD,13));
        jb3.setBounds(90,370,400,30);
        i9.add(jb3);

         t1= new JTextField();
        t1.setBounds(290,200,220,30);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Raleway",Font.ITALIC,20));
        add(t1);

         jb1=new JButton("Sign up");
        jb1.setFont(new Font("Raleway",Font.BOLD,13));
        jb1.addActionListener(this);
        jb1.setBounds(70,300,130,30);
        i9.add(jb1);

         jb2=new JButton("Clear");
        jb2.setFont(new Font("Raleway",Font.BOLD,13));

        jb2.setBounds(400,300,130,30);
        jb2.addActionListener(this);
        i9.add(jb2);



        jb4=new JButton("Exit");
        jb4.addActionListener(this);
        jb4.setFont(new Font("Raleway",Font.BOLD,13));
        jb4.setBounds(450,450,130,30);
        i9.add(jb4);




        setSize(600,500);
        setLocation(400,150);
        getContentPane().setBackground(new Color(255, 255, 255, 255));
        setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
         aadharnumber=t1.getText();
        if(ae.getSource()==jb2){
            t1.setText("");
        }
        else if(ae.getSource()==jb1){ //sign up
          setVisible(false);
          new Signup().setVisible(true);
        }
        else if(ae.getSource()==jb3){
            if(aadharnumber.equals("") || aadharnumber.length()!=12){
                JOptionPane.showMessageDialog(null,"Aadhar number should be entered properly");

            }else
            {
                 try
                 {
                    JLabel det=new JLabel();
                    Conn conn=new Conn();
                    ResultSet rs=conn.s.executeQuery("select * from signup where aadhar='"+aadharnumber+"'");
                    while(rs.next())
                    {
                        det.setText("ism");
                    }
                    String str=det.getText();
                    if(str.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Not found");
                        }
                        else
                        {
                            setVisible(false);
                            new Search(aadharnumber).setVisible(true);
                        }
                }
                catch (Exception e){
                    System.out.println(e);
                }

            }
        }
        else if(ae.getSource()==jb4)
        {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
new Front("");

    }
}


