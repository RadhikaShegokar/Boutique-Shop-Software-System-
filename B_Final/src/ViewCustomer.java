import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;

public class ViewCustomer
{
	static JFrame f=new JFrame("Database Records");
	static DefaultTableModel dtmCustomer;
	static JTable tbCustomer;
	static JScrollPane jspTable;

	static void populateArray (String rows[][])
	{
		JPanel jpShow = new JPanel ();

		int row = 0;
		int total = 0;

		f.setSize (1920,1080);
		f.setLocationRelativeTo(null);

		tbCustomer = makeTable (rows);
		jspTable = new JScrollPane (tbCustomer);
		jspTable.setBounds (0,0, 1920, 1080);
		jspTable.setBackground(Color.yellow);

		jpShow.add (jspTable);
		jpShow.setLayout (null);
		jpShow.setBackground(Color.YELLOW);


		f.getContentPane().add (jpShow);
		f.setBackground(Color.YELLOW);
        f.setAlwaysOnTop(true);
		f.setVisible (true);
	}

	private static JTable makeTable (String rowData[][])
	{
		String cols[] = {"Product ID", "Product Name", "Price","Quatity","Company"};

		dtmCustomer  = new DefaultTableModel (rowData, cols);

		tbCustomer = new JTable (dtmCustomer)
		{
			public boolean isCellEditable (int iRow, int iCol)
			{
				return false;	//Disable All Columns of Table.
			}
		};
		(tbCustomer.getColumnModel().
		getColumn(0)).setPreferredWidth (80);

		(tbCustomer.getColumnModel().getColumn(1)).setPreferredWidth (100);
		(tbCustomer.getColumnModel().getColumn(2)).setPreferredWidth (100);
		tbCustomer.setRowHeight (25);
		tbCustomer.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		return tbCustomer;
	
	}

}
