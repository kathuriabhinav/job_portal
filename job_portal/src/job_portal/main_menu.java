package job_portal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class main_menu {
    main_menu()	{
            
        JFrame f;
        JButton b1,b2,b3;

        f=new JFrame("MAIN MENU");

        b1=new JButton("Company");
        b2=new JButton("Jobseekers");
        b3=new JButton("Admin");

        f.setSize(900,700);

        b1.setBounds(300,200,250,90);
        b2.setBounds(300,300,250,90);
        b3.setBounds(300,400,250,90);
        f.add(b1);
        f.add(b2);
        f.add(b3);

        Font font1=new Font("Verdana",Font.BOLD,18);
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
                new company();
            }
        });

        b2.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e3)
            {
                new jobseeker();
            }
        });

        b3.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e3)
            {
                new admin();
            }
        });
    }
}
