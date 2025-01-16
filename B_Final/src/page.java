
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// Main frame (start)
import javax.swing.JTextField;

public class page extends JFrame implements ActionListener{
	JFrame u;
	JButton b1,b2,b3,b4,b5;
	JPanel p1;
	JLabel l1,pic;
	Font f1;
	Timer tm;
    int x = 0;
    
    String[] list = { "C:\\7.jpeg",//0
    				  "C:\\2.jpeg",//1
    				  "C:\\3.jpeg",//2
    				  "C:\\4.jpeg",//3
    				  "C:\\5.jpeg",//4
    				  "C:\\6.jpg",//5  
    				};
		
	public page() throws IOException
	{
		
		super("Java SlideShow");
        pic = new JLabel();
        pic.setBounds(0,0,1920, 1080);

        //Call The Function SetImageSize
        SetImageSize(5);
        //set a timer
        tm = new Timer(5000,new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                x = 0; 
            }
        });
        u = new JFrame();
		u.setVisible(true);
		u.setSize(600, 600);
		u.setLayout(null);
		f1 = new Font("Arial", Font.BOLD, 35);

		
		p1=new  JPanel();
		p1.setLayout(new FlowLayout());

		l1 = new JLabel("OPERATION WINDOW");
		l1.setBounds(400,50,450,40);
		l1.setFont(f1);
		l1.setVisible(true);
		b1 = new JButton("ADD PRODUCT");
		b1.setBounds(400, 120, 380, 40);
		
		b2 = new JButton("DELETE PRODUCT");
		b2.setBounds(400, 190, 380, 40);
		b3 = new JButton("SEARCH PRODUCT");
		b3.setBounds(400, 260, 380, 40);
        b4 = new JButton("MODIFY PRODUCT");
		b4.setBounds(400, 340, 380, 40);
        b5 = new JButton("DISPLAY ALL");
		b5.setBounds(400, 420, 380, 40);

     		
		
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    b5.addActionListener(this);
		
	 	u.add(b1);
	 	u.add(b2);
	 	u.add(b3);
	 	u.add(b4);
  		u.add(b5);
  		u.add(l1);
  		
  		u.add(pic);
        tm.start();
		    
  		u.setLocationRelativeTo(null);
	  	u.setSize(1921,1080);
  		u.setLayout(null);
       // u.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //u.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //u.setUndecorated(true);
  		u.setLocationRelativeTo(null);
  		u.setVisible(true);
		
	}
	
	 //create a function to resize the image 
    public void SetImageSize(int i){
         ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

	public static void main(String[] args) throws IOException 
	{
		new page();
	}
	
	public void actionPerformed(ActionEvent e) {
	
		Object obj=e.getSource();
		
		if(obj==b1)
			new AddProduct();
		else
			if(obj==b2)
				new delete();
		else
			if(obj==b3)
				new Search();
		else
			if(obj==b4)
				new Update();
		else
			if(obj==b5)
				DisplayAllRecords1.display();
		
	   }
}
