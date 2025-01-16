import javax.swing.*;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainWindow extends JFrame implements ActionListener{
    private JFrame f;
    JLabel l1,l2,l3;
    JPanel p;
	JTextField t1,t2;
	JButton b1,b2;
	Font f1,f2;
	
	public MainWindow() {
		f1=new Font("Calibri",Font.PLAIN,55);
		f2=new Font("Calibri",Font.PLAIN,20);
    	f = new JFrame("LOGIN");
	    f.setVisible(true);
		f.setSize(1920,1080);
		f.setLayout(null);
		/*p = new JPanel();
		p.setVisible(true);
		p.setSize(1920,1080);
		p.setLayout(null);*/
		
	 f.setContentPane(new JLabel(new ImageIcon("C:\\7.jpeg")));
     
		l1 = new JLabel("Vastra Collection ");
		l1.setBounds(420,80,600, 50);
		l1.setVisible(true);
		l1.setFont(f1);
		
		l2 = new JLabel("Username ");
		l2.setBounds(450, 180, 100, 30);
		l2.setFont(f2);
		
		
		l3 = new JLabel("Password ");
		l3.setBounds(450, 250, 100, 30);
		l3.setFont(f2);
		
		
		t1=new JTextField();
		t1.setBounds(550, 180, 170, 30);
		t1.setVisible(true);
		
		t2=new JTextField();
		t2.setBounds(550,250, 170, 30);
		t2.setVisible(true);
		

		b1 = new JButton("login");
		b1.setBounds(450, 350, 100, 40);
		b1.addActionListener(this);
		
		b2 = new JButton("change");
		b2.setBounds(650, 350, 100, 40);
		b2.addActionListener(this);
		
		t1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char c = ke.getKeyChar();
				if(Character.isDigit(c)) // || (c == KeyEvent.VK_BACK_SPACE))))
				{
					f.getToolkit().beep();
					ke.consume();
				}
			}
		});
		t2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char c = ke.getKeyChar();
				if(!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					f.getToolkit().beep();
					ke.consume();
				}
			}
		});
	    	 f.add(l1);
			f.add(l2);
			f.add(l3);
			f.add(t1);
			f.add(t2);
			f.add(b1);
			f.add(b2);
			/*p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(t1);
			p.add(t2);
			p.add(b1);
			p.add(b2);*/
            f.add(p);
	      // f.setVisible(true);
	}
		
		public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
	    {  
			
	    if(ae.getSource()==b1)
	    {
	        String username = t1.getText();        //get user entered username from the textField1  
	        String password = t2.getText();        //get user entered pasword from the textField2  
	          
	        //check whether the credentials are authentic or not  
	        if (username.equals("VastraCollection") && password.equals("123")) {  //if authentic, navigate user to a new page  
	              
	          
	           page pa = null;
	           try {
	        	   pa = new page();
	        	   } catch (IOException e) {
	        	   // TODO Auto-generated catch block
	        	   e.printStackTrace();
	        	   }
	        	   pa.setVisible(true); 
	           
	        }
	        else
	            {
	        	JOptionPane.showMessageDialog(f, "enter valid username and password",
						"Error !!!", JOptionPane.ERROR_MESSAGE);
	            }
        
	        }  
	    if(ae.getSource()==b2)
	        {  
	        	changep c = new changep();
                c.setVisible(true);   
	             
	        } 
	    }
	    
       
   public static void main(String[] args) {
        new MainWindow(); // Create an instance of the MainWindow class
    }


}
