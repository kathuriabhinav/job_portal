package job_portal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class admin {
    admin(){
        JFrame f;
        JButton b1,b2,b3;

        f=new JFrame("ADMIN MENU");

        b1=new JButton("REGISTER");
        b2=new JButton("LOGIN");

        f.setSize(900,700);

        b1.setBounds(300,200,250,90);
        b2.setBounds(300,300,250,90);
        f.add(b1);
        f.add(b2);

        Font font1=new Font("Verdana",Font.BOLD,18);
        b1.setFont(font1);
        b2.setFont(font1);

        f.setLayout(null);
        f.setVisible(true);

        b1.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)
            {
                new register_admin();
            }
        });

        b2.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e3)
            {
                new login_admin();
            }
       });
	    
    }    

    private static class register_admin {

        public register_admin() {
            JFrame f1=new JFrame("REGISTRATION PAGE");
        
            JLabel l1=new JLabel ("NAME *");
            JTextField t1=new JTextField("",45);

            JLabel l2=new JLabel ("PASSWORD *");
            JPasswordField t2=new JPasswordField("",13);

            JLabel l2b=new JLabel ("CONFIRM PASSWORD *");
            JPasswordField t2b=new JPasswordField("",13);

            JLabel l3 = new JLabel ("EMAIL ID *");
            JLabel l = new JLabel(" ");
            JTextField t3=new JTextField("",40);

            JLabel l4=new JLabel ("CONTACT NO. *");
            JTextField t4=new JTextField("",10);

            JLabel l70=new JLabel(" ");
            JLabel l80=new JLabel(" ");

            JButton b4=new JButton ("REGISTER");

            Font font=new Font("Verdana",Font.BOLD,16);

            f1.setSize(900,700);

            l1.setBounds(50,50,100,50);
            t1.setBounds(350,50,470,50);
            l2.setBounds(50,120,150,50);
            t2.setBounds(350,120,470,50);
            l2b.setBounds(50,190,250,50);
            t2b.setBounds(350,190,470,50);
            l3.setBounds(50,260,150,50);
            t3.setBounds(350,260,470,50);
            l4.setBounds(50,330,180,50);
            t4.setBounds(350,330,470,50);
            l.setBounds(50,311,205,12);
            l70.setBounds(50,241,210,12);
            l80.setBounds(50,445,160,12);
            b4.setBounds(400,500,250,70);

            l1.setFont(font);
            t1.setFont(font);
            l2.setFont(font);
            t2.setFont(font);
            l2b.setFont(font);
            t2b.setFont(font);
            l3.setFont(font);
            t3.setFont(font);
            l4.setFont(font);
            t4.setFont(font);
            b4.setFont(font);

            l70.setForeground(Color.red);
            l80.setForeground(Color.red);
            l.setForeground(Color.red);

            f1.setLayout(null);

            f1.add(l1);
            f1.add(t1);
            f1.add(l2);
            f1.add(t2);
            f1.add(l2b);
            f1.add(t2b);
            f1.add(l3);
            f1.add(l);
            f1.add(t3);
            f1.add(l4);
            f1.add(t4);
            f1.add(b4);
            f1.add(l70);
            f1.add(l80);

            f1.setVisible(true);

            b4.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e4)
                {
                    l.setText(" ");
                    l70.setText(" ");
                    l80.setText(" ");
                    String x =t2.getText();
                    String y =t2b.getText();

                    if(x.equals(y))
                    {
                        new do_register(t1.getText(),t2.getText(),t3.getText(),t4.getText(),3);
                        if(do_register.main(new String[0])==1) {
                                l.setText("** EMAIL ALREADY REGISTERED **");
                        }else {

                            f1.setVisible(false);
                            JFrame f5=new JFrame("REGISTRATION STATUS");
                            JLabel b6=new JLabel("Registered Succesfully");
                            f5.setSize(500,400);
                            JButton b20=new JButton ("Okay");
                            b20.setBounds(200, 170, 70, 30);
                            f5.add(b20);
                            b6.setBounds(170, 120, 200, 30);
                            f5.add(b6);
                            f5.setLayout(null);
                            f5.setVisible(true);
                            b20.addActionListener(new ActionListener(){

                                public void actionPerformed(ActionEvent e14)
                                {
                                        f5.setVisible(false);
                                }
                            });
                        }
                    }
                    else
                    {
                        l70.setText("** ENTER THE SAME PASSWORD **");
                    }
                }
            });
        }
    }

    private static class login_admin {

        public login_admin() {
            JFrame f6=new JFrame("LOGIN PAGE");
            JTextField t9=new JTextField("",45);

            JLabel l10=new JLabel("ENTER EMAIL ID");
            JLabel l100=new JLabel(" ");
            JPasswordField t10=new JPasswordField("",30);

            JLabel l11=new JLabel("ENTER PASSWORD");

            JButton b7=new JButton("LOGIN");

            Font font5=new Font("Verdana",Font.BOLD,18);

            f6.setSize(1400,750);

            l10.setBounds(150,150,300,70);
            l100.setBounds(1000,350,300,70);
            t9.setBounds(480,150,600,60);
            l11.setBounds(150,240,300,70);
            t10.setBounds(480,240,600,70);
            b7.setBounds(1000,600,300,60);

            l10.setFont(font5);
            t9.setFont(font5);
            l11.setFont(font5);
            t10.setFont(font5);
            b7.setFont(font5);

            f6.add(l11);
            f6.add(l10);
            f6.add(l100);
            f6.add(t9);
            f6.add(t10);
            f6.add(b7);
            f6.setLayout(null);
            f6.setVisible(true);
        
	     b7.addActionListener( new ActionListener() {
	    	 
	        public void actionPerformed(ActionEvent e1)
	        {
                    new login(t9.getText(),t10.getText(),3);
                    if(login.main(new String[0])==1) {
                        // after login work
                    }
                }
            });
        }
    }
}
