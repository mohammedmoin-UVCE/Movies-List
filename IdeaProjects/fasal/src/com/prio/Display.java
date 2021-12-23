package com.prio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Display extends JFrame implements ActionListener {
    static int id;
    JLabel l1,l2,l3,l4;
    JButton b1;
    Display(String str,int id)
    {
        super("Movie Page");
        this.id=id;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        String[] movies=str.split("}");

            String[] arr=movies[0].split(",");
            String[] la=arr[0].split(":");
            if(la[1].equals("\"False\""))
            {
                JOptionPane.showMessageDialog(null,"movie Not Found");

            }
            else {
                l1 = new JLabel(la[1].substring(2));
                l2 = new JLabel(la[2]);
            }
            String[] lb=arr[1].split(":");
            l3=new JLabel(lb[0]);
            l4=new JLabel(lb[1]);

        setBounds(400,200,400,300);
        l1.setBounds(50+50,50,50,20);
        l2.setBounds(150,50,150,20);
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

        new Display("",0).setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            System.out.println(l2.getText());
            String s="insert into movies values("+id+","+l2.getText()+","+l4.getText()+");";
            Conn c=new Conn();
            try {
                c.s.executeUpdate(s);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                this.setVisible(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
