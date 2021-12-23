package com.prio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Display extends JFrame implements ActionListener {
    String id;
    JTable t1;
    JLabel l1,l2,l3,l4;
    JButton b1;
    Display(String str,String id)
    {
        super("Movie Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        String[] movies=str.split("}");

            String[] arr=movies[0].split(",");
            String[] la=arr[0].split(":");
            l1=new JLabel(la[1].substring(2));
            l2=new JLabel(la[2]);

            String[] lb=arr[1].split(":");
            l3=new JLabel(lb[0]);
            l4=new JLabel(lb[1]);

        setBounds(400,200,300,300);
        l1.setBounds(50+50,50,50,20);
        l2.setBounds(150,50,50,20);
        l3.setBounds(50+50,100,50,20);
        l4.setBounds(150,100,50,20);
        add(l1);
        add(l3);
        add(l2);
        add(l4);

        b1=new JButton("ADD TO MOVIELIST");
        b1.setBounds(80,150,150,40);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);
    }


    public static void main(String[] args) {
        new Display("","").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String s="insert into movies values("+l2.getText()+","+l4.getText()+") where id="+id;
            Conn c=new Conn();
            try {
                c.s.executeQuery(s);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
