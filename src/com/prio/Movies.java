package com.prio;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Movies extends JFrame {
    JTable t1;
    String[] x={"title","year"};
    String[][] y=new String[40][2];

    Movies(String s) throws SQLException {

        t1=new JTable(y,x);
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery(s);
        t1.setModel(DbUtils.resultSetToTableModel(rs));

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 100, 700, 650);
        add(sp);
    }

    public static void main(String[] args) throws SQLException {
        new Movies("").setVisible(true);
    }



}
