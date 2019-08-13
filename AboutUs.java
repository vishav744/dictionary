
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.awt.*;
public class AboutUs extends JFrame{
	JLabel l1=new JLabel("Dictionary Java Version 1.6");
	JLabel l2=new JLabel("Dictionary Text Copyright");
	JLabel l3=new JLabel("Mr.Arun Sharma");
	JLabel l4=new JLabel("LR Institute of management");
	JLabel l5=new JLabel("Support");
	JLabel l6=new JLabel("Email:arunprasar@gmail.com");
	JLabel l7=new JLabel("Phone:+919418888226");
	public AboutUs(){
		setLayout(null);
		l1.setBounds(90,20,350,25);
		l1.setFont(new Font("Arial",Font.BOLD,13));
		l1.setForeground(Color.BLUE);
		this.add(l1);
		l2.setBounds(100,60,200,25);
		l2.setFont(new Font("Arial",Font.PLAIN,13));
		l2.setForeground(Color.BLUE);
		this.add(l2);
		l3.setBounds(125,100,200,25);
		l3.setFont(new Font("Arial",Font.PLAIN,13));
		l3.setForeground(Color.BLUE);
		this.add(l3);
		l4.setBounds(80,140,200,25);
		l4.setFont(new Font("Arial",Font.PLAIN,13));
		l4.setForeground(Color.BLUE);
		this.add(l4);
		l5.setBounds(135,180,200,25);
		l5.setFont(new Font("Arial",Font.PLAIN,13));
		l5.setForeground(Color.BLUE);
		this.add(l5);
		l6.setBounds(90,220,200,25);
		l6.setFont(new Font("Arial",Font.PLAIN,13));
		l6.setForeground(Color.BLUE);
		this.add(l6);
		l7.setBounds(95,260,200,25);
		l7.setFont(new Font("Arial",Font.PLAIN,13));
		l7.setForeground(Color.BLUE);
		this.add(l7);


		setSize(350,350);
		setTitle("About Us");
		setVisible(true);
		this.setResizable(false);
		setLocation(300,100);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
					dispose();
				}
			});
	}



}