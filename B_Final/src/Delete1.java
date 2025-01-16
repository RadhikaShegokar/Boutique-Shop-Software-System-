import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Delete1 implements ActionListener{


	JButton b1,b2;
	JTextField tf1;
	JLabel l1,l2;
	String Pid;
	JFrame f1=new JFrame();
	Delete1()
	{
		
		
		l1=new JLabel(" PRODUCT  DELETE ");
		l1.setBounds(780,300, 400,50);
		l1.setFont(new Font("SansSerif",Font.BOLD,30));
		
		l2=new JLabel("Product-ID :");
		l2.setBounds(730,420, 200,30);
		l2.setFont(new Font("SansSerif",Font.BOLD,25));
	  	
		tf1 = new JTextField();
		tf1.setBounds(940,420,200,30);
		
		b1=new JButton("Delete");
		b1.setBounds(760,510,130,35);
			
		b1.setBorderPainted(false);
	    b1.setContentAreaFilled(false);
	    b1.setOpaque(false);
			
		b2=new JButton("Cancel");
		b2.setBounds(980,510,130,35);
	        
		b2.setBorderPainted(false);
	    b2.setContentAreaFilled(false);
	    b2.setOpaque(false);
			
		b1.setFont(new Font("SansSerif",Font.BOLD,25));
		b2.setFont(new Font("SansSerif",Font.BOLD,25));
			
		b1.addActionListener(this);
		b2.addActionListener(this);
		    
		f1.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Sakshi\\Downloads\\2nd Frame Skin Colour.jpg")));

		f1.add(tf1);
		f1.add(l1);
		f1.add(l2);
		f1.add(b1);
		f1.add(b2);
		    
		f1.setSize(1920,1080);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
		    
	}

	public void actionPerformed(ActionEvent e1) 
	{	
	
	
				 if(e1.getSource()==b1)
					 
				 {
					 
					 if(tf1.getText().equals(""))
						{
							JOptionPane.showMessageDialog(f1,"Enter Product_id.","Empty field", JOptionPane.PLAIN_MESSAGE);
						
						}
				 
					 else{
						 try{
							Pid=tf1.getText();
						    System.out.println(Pid);
							DAO db=new DAO();
							Connection conn=db.getConnection();
							System.out.println(Pid);
							//Product_Id =tf1.getText();
							
						    String deleteQuery = "delete from additem where Product_Id=?";
							PreparedStatement preparedStatement;
							
							preparedStatement = conn.prepareStatement(deleteQuery);
							preparedStatement.setString(1, Pid+"");
							
							JOptionPane.showMessageDialog(f1,"Deleted Successfully");
							//val=JOptionPane.showConfirmDialog(f1,"Do u want to delete ?","title",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
								conn.close();
							int count = preparedStatement.executeUpdate();
							
							if(count==0)		
					   		   System.out.println("No Recored Found with Product Id= !!!"+Pid);
							else
							   System.out.println("Total "+count + " Records Deleted !!!");
						 	}
			 
				
						 catch(Exception e2)
						 {
							 System.out.println(e2);
		
						 }
					 	}
				 	}
	
	if (e1.getSource()==b2){

		 System.out.println();
	f1.dispose();	
	 }
}
}
