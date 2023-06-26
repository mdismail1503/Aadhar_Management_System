import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.ResultSet;

public class Search extends JFrame implements ActionListener {
JButton exit,print;
JTextArea ja;
public String aadharnumber;
    Search(String aadharnumber){
        this.aadharnumber=aadharnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/aaff.jpg"));
        Image i2=i1.getImage().getScaledInstance(290,220,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel jl=new JLabel(i3);
        jl.setBounds(340,125,275,200);
        add(jl);

        ja=new JTextArea();
        ja.setBounds(0,74,350,650);
        add(ja);

        JPanel jend=new JPanel();
        jend.setBounds(600,0,60,73);
        jend.setBackground(new Color(67, 5, 28, 206));
        jend.setLayout(null);
        add(jend);

        JPanel jp=new JPanel();
        jp.setBounds(0,0,600,73);
        jp.setBackground(new Color(221, 173, 117));
        jp.setLayout(null);
        add(jp);

        JLabel l=new JLabel("Mera Aadhaar, Meri Pehchan..".toUpperCase());
        l.setBounds(120,30,550,40);
        l.setFont(new Font("System",Font.BOLD,25));
        l.setForeground(new Color(67, 5, 28, 206));
        jp.add(l);

        exit=new JButton("Done");
        exit.addActionListener(this);
        exit.setBounds(400,770,130,30);
        exit.setFont(new Font("Raleway",Font.BOLD,14));
        add(exit);

        print=new JButton("Print");
        print.addActionListener(this);
        print.setBounds(400,730,130,30);
        print.setFont(new Font("Raleway",Font.BOLD,14));
        add(print);
        print.addActionListener(
                e -> {
                    try {
                        ja.print();
                    }
                    catch (java.awt.print
                                   .PrinterException a) {
                        System.err.format(
                                "NoPrinter Found",
                                a.getMessage());
                    }
                });
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from signup where aadhar='"+aadharnumber+"'");
        while(rs.next()){
      ja.setText("  AADHAR DETAILS : \n\n  Form NO. "+rs.getString("formno")+"\n\n"+"  Name: "+rs.getString("name")+"\n\n"+"  F.Name: "+rs.getString("fname")+"\n\n"+"  DOB: "+rs.getString("dob")+"\n\n"+"  Gender: "+rs.getString("gender")+"\n\n"+"  E-mail: "+rs.getString("email")+"\n\n"+"  Aadhar NO: "+rs.getString("aadhar")+"\n\n"+"  Occupation: "+rs.getString("occupation")+"\n\n"+"  Address: "+rs.getString("address")+"\n\n"+"  City: "+rs.getString("city")+"\n\n"+"  Pincode: "+rs.getString("pin")+"\n\n"+"  State: "+rs.getString("state"));
        }
        }catch (Exception e){
            System.out.println(e);
        }
        ja.setFont(new Font("System",Font.BOLD,20));

        getContentPane().setBackground(Color.white);
        setSize(660,830);
        setLocation(400,30);
        setUndecorated(true);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==exit){
        setVisible(false);
        new Front("").setVisible(true);}
    }
    public static void main(String[] args) {
        new Search("");
    }

}
