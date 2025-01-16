import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update implements ActionListener{
	JFrame u;
    JButton b1,b2;
    JTextField tf1;
    JTextField tu1,tu2,tu3,tu4,tu5;
    JLabel l,lb,lab ;
    JLabel l1 ,l2, l3, l4,l5;
    JPanel  p1,p2;
    String itemId;

	JFrame f=new JFrame();
       
	Update()
	{

		//f.setContentPane(new JLabel(new ImageIcon()));
		
		lb=new JLabel("PRODUCT    UPDATE");
		lb.setBounds(780,300, 400,50);
		lb.setFont(new Font("SansSerif",Font.BOLD,30));
		lb.setForeground(Color.black);

		
		l=new JLabel("ID");
		l.setBounds(730,420, 200,30);
		l.setFont(new Font("SansSerif",Font.BOLD,25));
		l.setForeground(Color.black);
	
		tf1 = new JTextField();
		tf1.setBounds(940,420,200,30);
		itemId=tf1.getText();
	    
		b1=new JButton("Update");
		b1.setBounds(760,510,130,35);
		b1.setForeground(Color.black);
        b1.setBorderPainted(true);
        b1.setContentAreaFilled(false);
        b1.setOpaque(false);
        
		b2=new JButton("Cancel");
		b2.setBounds(980,510,130,35);
		b2.setForeground(Color.black);
        b2.setBorderPainted(true);
        b2.setContentAreaFilled(false);
        b2.setOpaque(false);
		
		b1.setFont(new Font("SansSerif",Font.PLAIN,25));
		b2.setFont(new Font("SansSerif",Font.PLAIN,25));
		
		b1.addActionListener(this);
	    b2.addActionListener(this);
	    
	   // f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\2nd Frame Skin Colour.jpg")));
	    f.add(tf1);
	    f.add(l);
	    f.add(lb);
	    f.add(b1);
	    f.add(b2);
	    
	    //f.setBackground(new Color(0,0,0,0));
	    f.setSize(1920,1080);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	   
	}
	   

	
	public void actionPerformed(ActionEvent e) 
	{	
		try
		{
		if(e.getSource()==b1)
		{
			if(tf1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(f,"Enter Product_id","Empty Field",JOptionPane.PLAIN_MESSAGE);
			}
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
			      	   
			    String idno,name,price,qty,com;
			    
			    while (result.next())
		        {	
				   if((result.getString(1).equalsIgnoreCase(id)))
				   {
					   flag=true;
					   
					   idno=result.getString(1);
					   name=result.getString(2);
					   price=result.getString(3);
					   qty=result.getString(4);
					   com=result.getString(5);
					   conn.close();
					   new Update_2(idno,name,price,qty,com);
					   break;
					 
				   }
			    }
		      if(flag==false)
		      {
		    	  JOptionPane.showMessageDialog(f,"No Record Found."); 
		      }


			}  tf1.setText(null);
		}
		else if(e.getSource()==b2){
			f.dispose();
		}
//		
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
}
	
