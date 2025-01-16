
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class window2 implements ActionListener{
	JFrame u;
	JPanel p;
	JLabel l1;
	JButton b1,b2,b3,b4,b5;
	Font f1;
	window2()
	{
		u = new JFrame();
		u.setVisible(true);
		u.setSize(600, 600);
		u.setLayout(null);
		f1 = new Font("Arial", Font.BOLD, 22);
		
		p= new JPanel();
		p.setSize(600,600);
		p.setLayout(null);
		p.setBackground(Color.white);
		
		l1 = new JLabel("OPERATION WINDOW");
		l1.setBounds(150,50,350,40);
		l1.setFont(f1);
		l1.setVisible(true);
		b1 = new JButton("ADD PRODUCT");
		b1.setBounds(110, 100, 350, 40);
		b2 = new JButton("DELETE PRODUCT");
		b2.setBounds(110, 180, 350, 40);
		b3 = new JButton("SEARCH PRODUCT");
		b3.setBounds(110, 260, 350, 40);
        b4 = new JButton("MODIFY PRODUCT");
		b4.setBounds(110, 340, 350, 40);
        b5 = new JButton("DISPLAY ALL");
		b5.setBounds(110, 420, 350, 40);

       p.add(l1);
       p.add(b1);
       p.add(b2);
       p.add(b3);
       p.add(b4);
       p.add(b5);
       u.add(p);

}
	public static void main(String[] args) {
		new window2();
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
   
		
	   }		
		
	}




