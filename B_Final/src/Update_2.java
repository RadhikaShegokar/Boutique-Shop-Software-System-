import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update_2 implements ActionListener
{

	JTextField tu2,tu3,tu4,tu5, tf1;
	JLabel l ;
	JLabel l1 ,l2, l3, l4, l5,l6;
	JTextField tu1=new JTextField();
	JButton up,c;
	JFrame u=new JFrame();
	
	Update_2(String id,String name,String price,String qty,String com)
	{
		
	tu1 = new JTextField(id);
	tu1.setBounds(550,80,170,20);

	tu2 = new JTextField(name);
	tu2.setBounds(550,130,170,20);

	tu3 = new JTextField(price);
	tu3.setBounds(550,230,170,20);

	tu4 = new JTextField(qty);
	tu4.setBounds(550,280,170,20);

	tu5 = new JTextField(com);
	tu5.setBounds(550,180,170,20);

	up=new JButton("Update");
	up.setBounds(450,450,100,30);
	up.setForeground(Color.black);
	up.setFont(new Font("SansSerif",Font.BOLD,15));
	up.setBorderPainted(true);
	up.setContentAreaFilled(false);
	up.setOpaque(false);
	up.addActionListener(this);
	
	c=new JButton("Cancel");
	c.setBounds(650,450,100,30);
	c.setForeground(Color.black);
	c.setFont(new Font("SansSerif",Font.BOLD,15));
	c.setBorderPainted(true);
	c.setContentAreaFilled(false);
	c.setOpaque(false);
	c.addActionListener(this);


	l1=new JLabel("ID :");
	l1.setBounds(450,80,100,20);
	l1.setFont(new Font("SansSerif",Font.BOLD,15));
	l1.setForeground(Color.black);

	l2=new JLabel(" Name :");
	l2.setBounds(450,130,100,30);
	l2.setFont(new Font("SansSerif",Font.BOLD,15));
	l2.setForeground(Color.black);

	l3=new JLabel("Price:");
	l3.setBounds(450,230, 100,30);	
	l3.setFont(new Font("SansSerif",Font.BOLD,15));
	l3.setForeground(Color.black);

	l4=new JLabel("Quantity :");
	l4.setBounds(450,280, 100,20);
	l4.setFont(new Font("SansSerif",Font.BOLD,15));
	l4.setForeground(Color.black);

    l5=new JLabel("Company :");
	l5.setBounds(450,180,100,20);
	l5.setFont(new Font("SansSerif",Font.BOLD,15));
	l5.setForeground(Color.black);
	
	l6=new JLabel("PRODUCT UPDATION");
	l6.setBounds(500,350,300,50);
	l6.setFont(new Font("SansSerif",Font.BOLD,20));
	l6.setForeground(Color.black);
	
	//u.setContentPane(new JLabel(new ImageIcon("C:\\3rd Frame Yellow.jpg")));
	
	u.add(l1);
	u.add(l2);
	u.add(l3);
	u.add(l4);
	u.add(l5);
	u.add(l6);
	u.add(tu1);
	u.add(tu2);
	u.add(tu3);
	u.add(tu4);
	u.add(tu5);
	u.add(up);
	u.add(c);
	u.setLocation(500,500);
	u.setSize(1920,1080);
	u.setLayout(null);
	u.setLocationRelativeTo(u);
	u.setVisible(true);
  }

	
	public void actionPerformed(ActionEvent e) {
		
		Object obj=e.getSource();
	    
		if(obj==up)
		{
		  try
		  {
			DAO db=new DAO();
			Connection conn=db.getConnection();
		    String selectQuery = "update addItem set Name=?, Price=?, Quantity=?, Company=? where id=? ";    	    
			PreparedStatement preparedStatement = null;
			preparedStatement = conn.prepareStatement(selectQuery);
			
			preparedStatement.setString(1,tu2.getText());
			preparedStatement.setString(2,tu3.getText());
			preparedStatement.setString(3,tu4.getText());
			preparedStatement.setString(4,tu5.getText());
		    preparedStatement.setString(5,tu1.getText());
		    preparedStatement.executeUpdate();
		    conn.close();
		    
		    JOptionPane.showMessageDialog(u,"Updated Successfully !!");
		    u.dispose();
		  }
		  catch(Exception e1)
		  {
			  System.out.println(e1);
		  }
			
		}
		else if( e.getSource()==c)
		{
			u.dispose();
		}
		}
	}
		



