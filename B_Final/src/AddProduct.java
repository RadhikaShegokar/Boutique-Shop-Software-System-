 import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AddProduct implements ItemListener, ActionListener {
	//private static String size = null;
	//private static String Address = null;
//	private static final String Email = null;
	//private static final String Contact= null;
		JFrame f;
		JCheckBox jcb;
		CheckboxGroup cbg;
		JCheckBox cb5, cb6, cb7;
		JLabel l1, l2, l3, l4, l5, l6, l7;
		TextField textID, textName, textCom, textP ,textQ;
		JButton b1, b2;
		Font f1, f2, f3;
		String size;
		int State = 0;
		JPanel p;
		int i=0,j=0,k=0;
		JFrame u=new JFrame();
		
		AddProduct() {
			f1 = new Font("Calibri", Font.PLAIN, 30);
			f2 = new Font("Calibri", Font.PLAIN, 20);
			f3 = new Font("Calibri", Font.PLAIN, 15);

			f = new JFrame();
			f.setVisible(true);
			f.setSize(1921,1080);//600, 900
			f.setLayout(null);
			p = new JPanel();
			p.setSize(1921,1080);//590, 890
			p.setLayout(null);
			//f.setContentPane(new JLabel(new ImageIcon("C:\\main page0 (2).jpg")));
			
			l1 = new JLabel("Add Product");
			l1.setFont(f1);
			l1.setBounds(490, 20, 350, 40);
			l1.setVisible(true);

			l2 = new JLabel("Product ID:");
			l2.setFont(f2);
			l2.setBounds(450, 80, 100, 20);

			l3 = new JLabel("Name");
			l3.setFont(f2);
			l3.setBounds(450, 130, 100, 20);

			l4 = new JLabel("Price");
			l4.setFont(f2);
			l4.setBounds(450, 230, 100, 20);

			l5 = new JLabel("Qty");
			l5.setFont(f2);
			l5.setBounds(450, 280, 100, 20);

			l6 = new JLabel("Company");
			l6.setFont(f2);
			l6.setBounds(450, 180, 100, 20);
			
			l7 = new JLabel("size");
			l7.setFont(f2);
			l7.setBounds(450, 330, 100, 20);
		
			

			textID = new TextField();
			textID.setBounds(550, 79, 170, 20);
			textID.setVisible(true);

			textName = new TextField();
			textName.setBounds(550, 129, 170,20);
			//t2.add(jp);

			textP = new TextField();
			textP.setBounds(550, 229, 170, 20);
			
			textQ = new TextField();
			textQ.setBounds(550, 279, 170, 20);

			textCom = new TextField();
			textCom.setBounds(550, 179, 170, 20);

			cbg = new CheckboxGroup(); // CheckBox Grouping
			cb5 = new JCheckBox("Small");
			cb5.setBounds(550, 330, 80, 20);
			cb5.setFont(f3);
			cb5.addItemListener(this);

			cb6 = new JCheckBox("Medium");
			cb6.setBounds(550, 370, 80, 20);
			cb6.setFont(f3);
			cb6.addItemListener(this);

			cb7 = new JCheckBox("Large");
			cb7.setBounds(550, 410, 80, 20);
			cb7.setFont(f3);
			cb7.addItemListener(this);

			b1 = new JButton("Save");
			b1.setBounds(450, 500, 80, 30);
			b1.addActionListener(this);
			b1.setEnabled(true);

			b2 = new JButton("Cancel");
			b2.setBounds(630, 500, 80, 30);
			b2.addActionListener(this);
			b2.setEnabled(true);

			textID.addKeyListener(new KeyAdapter()
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
			textName.addKeyListener(new KeyAdapter()
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

			textP.addKeyListener(new KeyAdapter()
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
			textQ.addKeyListener(new KeyAdapter()
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
			
			textCom.addKeyListener(new KeyAdapter()
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


			// Labels
			p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(l4);
			p.add(l5);
			p.add(l6);
			p.add(l7);
			
			// Text Area
			p.add(textID);
			p.add(textName);
			p.add(textP);
			p.add(textQ);
			p.add(textCom);
			// CheckBoxes
			
			p.add(cb5);
			p.add(cb6);
			p.add(cb7);
			p.add(b1);
			p.add(b2);
			f.add(p);
			
		}
		public static void main(String[] args) {
			new AddProduct();
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
	    if(obj==b1)
	{
	    	

		if(textID.getText().equals("")||textName.getText().equals("")||textP.getText().equals("")||textQ.getText().equals("")||textCom.getText().equals(""))
		{
			JOptionPane.showMessageDialog(u,"Enter Details","Empty field", JOptionPane.PLAIN_MESSAGE);
		
		}
		else{
		try
		{
			DAO db=new DAO();
			Connection conn=db.getConnection();
			
	
			String id=textID.getText();
		
			String name=textName.getText();

			String cost=textP.getText();
			
			String quantity=textQ.getText();
		
		    String company=textCom.getText();
		    
		    String size="";
		    
		    if(cb5.isSelected())
		    	size= cb5.getText();
		    if(cb6.isSelected())
		    	size+=" "+cb6.getText();
		    if(cb7.isSelected())
		    	size+=" "+cb7.getText();
		    //String size=textS.getText();
			
				
				
				    String insertQuery = "insert into additem values(?,?,?,?,?,?)";
				    PreparedStatement preparedStatement;
					
				    preparedStatement = conn.prepareStatement(insertQuery);
				    preparedStatement.setString(1,id+"");
				    preparedStatement.setString(2,name);
				    preparedStatement.setString(3,cost);
				    preparedStatement.setString(4,quantity);
				    preparedStatement.setString(5,company);
				    preparedStatement.setString(6,size);
				    preparedStatement.executeUpdate();
				    conn.close();
				    System.out.println("Data  Successfully Inserted !!!");
				    JOptionPane.showMessageDialog(u,"Added Sucessfully");
				    
				    
				    textID.setText(null);textName.setText(null);textCom.setText(null);textP.setText(null);textQ.setText(null);
		
			}
		
		catch(Exception e1)
		{
			System.out.println(e1);
		}}}


	    else if (e.getSource()==b2){
		u.dispose();
}
	}
	    public void displayInfo() {
			output();
			String ID, Name, Company, Price, Qty;
			ID = textID.getText();
			Name = textID.getText();
			Company = textCom.getText();
			Price = textP.getText().toString();
			Qty =textQ.getText().toString();
			//Qty =textQ.getText().toString();

			JOptionPane.showMessageDialog(f, "ID : " + ID + "\nName : " + Name + "\nCompany : "
					+ Company + "\nPrice : " + Price + "\nQty : " + Qty
					+ "\nSize : " + size, "RECORD : ",
					JOptionPane.PLAIN_MESSAGE);

		}
		public void output(){
			if (i == 1)
				size = "Small";
			
			if (j == 1)
				size = "Mediam";
			
			if (k == 1)
				size = "Large";
			
			if (i == 1 && j == 1)
				size = "Small and Large";
		
			if (i == 1 && k == 1)
				size = "Small and Mediam";
			
			if (j == 1 && k == 1)
				size = "Mediam and Large";
			
			if (i == 1 && k == 1 && j == 1)
				size = "Small, Mediam and Large";
			
			if (i == 0 && k == 0 && j == 0)
				size = "None";
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			if (cb5.isSelected())
				i=1;
			else i=0;
			
			if (cb6.isSelected())
				j=1;
			else j=0;
			
			if (cb7.isSelected())
				k=1;
			else k=0;
			
			if (cb7.isSelected() && cb5.isSelected()){
				i=1;k=1;
			} else if (cb7.isSelected() && cb6.isSelected()){
				j=1;k=1;
			} else if (cb5.isSelected() && cb6.isSelected()){
				i=1;j=1;
			} else if (cb5.isSelected() && cb6.isSelected() && cb7.isSelected()){
				i=1;j=1;k=1;
			} 
		}


	
	private void submitCheck() {
		String id, name, Company, Price, Qty;
		id = textID.getText();
		name = textID.getText();
		Company = textName.getText();
		Price = textP.getText().toString();
		Qty =textQ.getText().toString();
			if (id.isEmpty() || name.isEmpty() || Company.isEmpty() || Price.isEmpty() || Qty.isEmpty() || name == null){
			JOptionPane.showMessageDialog(f, "Mandatory Fields Are Not Provided ....",
					"Error !!!", JOptionPane.ERROR_MESSAGE);
		} else 
			displayInfo();
	}
}
		