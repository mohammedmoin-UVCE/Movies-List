package com.prio;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Movies extends JFrame {
    JTable t1;
    String[] x={"title","year"};
    String[][] y=new String[40][2];

    Movies(String s) throws SQLException {
        super("MovieList");
        setSize(515,550);
        setLocation(150,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        t1=new JTable(y,x);
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery(s);
        System.out.println(s);
        int i=0,j=0;
        while(rs.next())
        {
            y[i][j++]=rs.getString("title");
            y[i][j++]=rs.getString("year");
            i++;
            j=0;
        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 20, 500, 550);
        add(sp);
    }

    public static void main(String[] args) throws SQLException {
        new Movies("").setVisible(true);
    }
}
