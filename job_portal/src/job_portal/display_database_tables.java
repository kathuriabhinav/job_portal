/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job_portal;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static job_portal.login.JDBC_DRIVER;

public class display_database_tables{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/job_portal";
    static final String USER = "root";
    static final String PASS = "root"; 
    String[] columnNames = {"email_id", "person_id", "name", "contact_no"};
    String n = "",e = "",p = "",c = "";
    JFrame frame1;
    
    display_database_tables()
    {
        JFrame f;
        JButton b1,b2,b3;

        f=new JFrame("ADMIN MENU");

        b1=new JButton("Company");
        b2=new JButton("Jobseekers");
        b3=new JButton("Admin");

        f.setSize(900,700);
        
        JLabel l = new JLabel("Choose which database details you need");
        l.setBounds(200,100,600,50);
        
        b1.setBounds(300,200,250,90);
        b2.setBounds(300,300,250,90);
        b3.setBounds(300,400,250,90);
        f.add(l);
        f.add(b1);
        f.add(b2);
        f.add(b3);

        Font font1=new Font("Verdana",Font.BOLD,18);
        l.setFont(font1);
        b1.setFont(font1);
        b2.setFont(font1);
        b3.setFont(font1);

        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);

        b1.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)
            {
                add_table("company");
            }
        });

        b2.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e3)
            {
                add_table("jobseeker");
            }
        });

        b3.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e3)
            {
                add_table("admin");
            }
        });
    }

    private void add_table(String tablename) 
    {
        frame1 = new JFrame("Database Search Result");
        frame1.setSize(900,700);
        Font font=new Font("Verdana",Font.BOLD,18);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            pst = conn.prepareStatement("select * from "+tablename+"");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                e = rs.getString("email_id");
                p = rs.getString("person_id");
                n = rs.getString("name");
                c = rs.getString("contact_no");
                model.addRow(new Object[]{n, e, p, c});
                i++;
            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
