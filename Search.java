import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search extends JFrame implements ActionListener {
JButton exit;
public String aadharnumber;
    Search(String aadharnumber){
        this.aadharnumber=aadharnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/flag.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(0,0,600,700);
        add(i4);

        JPanel jp=new JPanel();
        jp.setBounds(0,0,600,73);
        jp.setBackground(new Color(221, 173, 117));
        jp.setLayout(null);
        i4.add(jp);

        JLabel l=new JLabel("AADHAR DETAILS");
        l.setBounds(190,30,300,40);
        l.setFont(new Font("System",Font.BOLD,25));
        jp.add(l);






        JLabel det=new JLabel();
        i4.add(det);

        exit=new JButton("Back");
        exit.addActionListener(this);
        exit.setBounds(400,620,130,30);
        exit.setFont(new Font("Raleway",Font.BOLD,14));
        i4.add(exit);

        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from signup where aadhar='"+aadharnumber+"'");
        while(rs.next()){
      det.setText(det.getText()+"<html>"+"Form NO. "+rs.getString("formno")+"<br><br>"+"Name: "+rs.getString("name")+"<br><br>"+"F.Name: "+rs.getString("fname")+"<br><br>"+"DOB: "+rs.getString("dob")+"<br><br>"+"Gender: "+rs.getString("gender")+"<br><br>"+"E-mail: "+rs.getString("email")+"<br><br>"+"Aadhar NO: "+rs.getString("aadhar")+"<br><br>"+"Occupation: "+rs.getString("occupation")+"<br><br>"+"Address: "+rs.getString("address")+"<br><br>"+"City: "+rs.getString("city")+"<br><br>"+"Pincode: "+rs.getString("pin")+"<br><br>"+"State: "+rs.getString("state")+"<html>");
        }
        }catch (Exception e){
            System.out.println(e);
        }
        det.setFont(new Font("System",Font.BOLD,15));
        det.setBounds(50,120,400,500);



        getContentPane().setBackground(Color.white);
        setSize(600,700);
        setLocation(400,40);
        setUndecorated(true);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Front("").setVisible(true);
    }
    public static void main(String[] args) {
        new Search("");
    }

}
