package com.prio;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    static int id;

    JTextField t1;
    JButton b1;
    Project(int id) {
        super("MovieLibrary");

        this.id = id;

        setSize(1920, 1030);

        /* Adding background image */
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/Library.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1400, 780, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);


        b1=new JButton("Search");
        b1.setBounds(1050,150,150,30);
        b1.setBackground(Color.green);
        b1.setForeground(Color.white);
        l1.add(b1);

        t1=new JTextField();
        t1.setBounds(500,150,500,30);
        l1.add(t1);
        b1.addActionListener(this);


    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String s=t1.getText();
            try {
                Api a=new Api(s);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
    public static void main(String[] args) {
        new Project(id).setVisible(true);
    }


}