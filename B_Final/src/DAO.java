import java.sql.Connection;
import java.sql.DriverManager;

public class DAO 
{
	String username="root";
	
	String password="tiger";
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
	                    
	public Connection getConnection()
	{
	  Connection conn=null;
      try
	  {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,username,password);
	  }
	  catch (Exception e) 
	  {
		System.out.println("Unable to connect Database");
	  }
      return conn;
    }
}
