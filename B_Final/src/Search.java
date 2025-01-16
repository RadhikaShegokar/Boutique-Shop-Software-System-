import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Search implements ActionListener{

	 JButton b1,b2,s;
	 JTextField tu1,tu2,tu3,tu4,tu5, tf1;
	 JLabel l1,l2;
	 String product;

		JFrame f1=new JFrame();

		JFrame u=new JFrame();
	
	 String Pid;
	 static String rows[][] = new String [100][5];

		static int row=0;
	{		
		
	
		l1=new JLabel("PRODUCT    SEARCH");
		l1.setBounds(500,300, 400,50);
		l1.setFont(new Font("SansSerif",Font.BOLD,30));
		
		l2=new JLabel("Product-ID :");
		l2.setBounds(480,420, 200,30);
		l2.setFont(new Font("SansSerif",Font.BOLD,25));
	  	
		tf1 = new JTextField();
		tf1.setBounds(630,420,200,30);
		    
		tu1 = new JTextField();
		tu1.setBounds(200,79,200,30);

		tu2 = new JTextField();
		tu2.setBounds(200,129,200,30);

		tu3 = new JTextField();
		tu3.setBounds(200,179,200,30);

		tu4 = new JTextField();
		tu4.setBounds(200,229,200,30);

		tu5 = new JTextField();
		tu5.setBounds(200,279,200,30);

		b1=new JButton("Search");
		b1.setBounds(480,510,130,35);
		b1.setFont(new Font("SansSerif",Font.BOLD,25));
			
		b1.setBorderPainted(false);
	    b1.setContentAreaFilled(false);
	    b1.setOpaque(false);
			
		b2=new JButton("Cancel");
		b2.setBounds(680,510,130,35);
		b2.setFont(new Font("SansSerif",Font.BOLD,25));
	        
		b2.setBorderPainted(false);
	    b2.setContentAreaFilled(false);
	    b2.setOpaque(false);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		    
		//f1.setContentPane(new JLabel(new ImageIcon("C:\\2nd Frame Skin Colour.jpg")));

		f1.add(tf1);
		f1.add(l1);
		f1.add(l2);
		f1.add(b1);
		f1.add(b2);
		   
		f1.getContentPane().setBackground(Color.WHITE);
		f1.setSize(1920,1080);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
		    
	}

	
	

	public void actionPerformed(ActionEvent e) 
	{
		Object obj=e.getSource();
		try
		{
		  if(obj==b1)
		  {
			 if(tf1.getText().equals(""))
					JOptionPane.showMessageDialog(f1,"Enter Product_id.","Empty field", JOptionPane.PLAIN_MESSAGE);
			 else
			 {
					String id=tf1.getText();
					boolean flag=false;
				    DAO db=new DAO();
					Connection conn=db.getConnection();
							
				    String selectQuery = "select * from  additem"+"";
				    	    	    
				    PreparedStatement preparedStatement = 
				    	conn.prepareStatement(selectQuery);

				    ResultSet result = preparedStatement.executeQuery();
				      	      
				    while (result.next())
			        {	
					   if((result.getString(1).equalsIgnoreCase(id)))
					   {
						   flag=true;
						   
						   tu1.setText(result.getString(1));
						   tu2.setText(result.getString(2));
						   tu3.setText(result.getString(3));
						   tu4.setText(result.getString(4));
						   tu5.setText(result.getString(5));
                           break;
					   }
				    }
			      if(flag==false)
			      {
			    	  JOptionPane.showMessageDialog(f1,"No Record Found.","No field", JOptionPane.PLAIN_MESSAGE); 
			      }
			     else
			      {
					JLabel l ;
					JLabel l1 ,l2, l3, l4, l5,l6;
				
					String Pid = null;
					
					s=new JButton("ok");
					s.setBounds(1400,800,150,30);
					s.setForeground(Color.black);
					s.setFont(new Font("SansSerif",Font.BOLD,18));
					s.setBorderPainted(true);
					s.setContentAreaFilled(false);
					s.setOpaque(false);
					s.addActionListener(this);

					l1=new JLabel(" ID :");
					l1.setBounds(100,80,100,20);
					l1.setFont(new Font("SansSerif",Font.BOLD,18));
					l1.setForeground(Color.black);

					l2=new JLabel("Name :");
					l2.setBounds(100,130,100,20);
					l2.setFont(new Font("SansSerif",Font.BOLD,18));
					l2.setForeground(Color.black);

					l3=new JLabel("Price:");
					l3.setBounds(100,180, 100,20);	
					l3.setFont(new Font("SansSerif",Font.BOLD,18));
					l3.setForeground(Color.black);

					l4=new JLabel("Quantity :");
					l4.setBounds(100,230, 100,20);
					l4.setFont(new Font("SansSerif",Font.BOLD,18));
					l4.setForeground(Color.black);

				    l5=new JLabel("Company :");
					l5.setBounds(100,280,100,20);
					l5.setFont(new Font("SansSerif",Font.BOLD,18));
					l5.setForeground(Color.black);
					
					l6=new JLabel("PRODUCT DETAILS");
					l6.setBounds(150,20,350,40);
					l6.setFont(new Font("SansSerif",Font.BOLD,20));
					l6.setForeground(Color.black);
					
					u.setContentPane(new JLabel(new ImageIcon("C:\\main page0 (4).jpg")));
					
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
					u.add(s);
					u.setLocation(500,500);
					u.setSize(1920,1080);
					u.setLayout(null);
					u.setLocationRelativeTo(u);
					u.setVisible(true);
				
			 }
		}
	}

		  else if(e.getSource()==s ){
			tf1.setText("");
			u.setVisible(false);
		}
		  else if(e.getSource()==b2 ){
			tf1.setText("");
			f1.setVisible(false);
		}
		 
		 
	}
		catch(Exception ed )
		{
			System.out.println(ed);
		}
	

}

}