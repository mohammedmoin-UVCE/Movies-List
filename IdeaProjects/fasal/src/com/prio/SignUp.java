package com.prio;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1, t2, t3;
    JButton b1, b2;
    SignUp(){
        setBounds(600, 250, 700, 400);

        p1 = new JPanel();
        p1.setBounds(30, 30, 650, 300);
        p1.setLayout( null);
        p1.setBackground(Color.WHITE);
        p1.setForeground(new Color(34, 139, 34));
        p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(p1);

        JLabel l1 = new JLabel("Name");
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(100, 50, 100, 20);
        p1.add(l1);

        t1 = new JTextField();
        t1.setBounds(260, 50, 150, 20);
        p1.add(t1);

        JLabel l2 = new JLabel("UserName");
        l2.setForeground(Color.DARK_GRAY);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(100, 90, 100, 20);
        p1.add(l2);

        t2 = new JTextField();
        t2.setBounds(260, 90, 150, 20);
        p1.add(t2);


        JLabel l3 = new JLabel("Password");
        l3.setForeground(Color.DARK_GRAY);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(100, 130, 100, 20);
        p1.add(l3);

        t3 = new JTextField();
        t3.setBounds(260, 130, 150, 20);
        p1.add(t3);

        b1 = new JButton("Create");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(80, 200, 120, 30);
        b1.addActionListener(this);
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250, 200, 120, 30);
        b2.addActionListener(this);
        p1.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(450, 30, 250, 250);
        p1.add(l6);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String name = t1.getText();
            String userid = t2.getText();
            String password = t3.getText();
            Random ran = new Random();
            int id = (ran.nextInt() % 100);
            try{
                Conn c = new Conn();
                String str = "insert into userdetails values("+id+",'"+name+"','"+userid+"','"+password+"')";
                    c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){

            }
        } else if(ae.getSource()== b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args){
        new SignUp().setVisible(true);
    }
}
