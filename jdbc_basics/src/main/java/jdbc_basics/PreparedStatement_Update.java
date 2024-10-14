package jdbc_basics;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
public class PreparedStatement_Update 
{
  public static void main(String args[])
  {
	  try {
		  Class.forName("org.postgresql.Driver");
		  System.out.println("Driver Loaded");
		  Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
		  System.out.println("Connection establsh");
		  PreparedStatement ps=con.prepareStatement("insert into employee values(?,?)");
		  ps.setInt(1, 1);
		  ps.setString(2, "ramesh");
		  ps.execute();
		  con.close();
		  
	  }
	  catch(ClassNotFoundException | SQLException e)
	  {
		  e.printStackTrace();
		 // e.printStackTrace();
	  }
  }
}
