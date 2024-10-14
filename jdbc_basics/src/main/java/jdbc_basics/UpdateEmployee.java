package jdbc_basics;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UpdateEmployee 
{
  public static void main(String args[])
  {
	  try {
		  Class.forName("org.postgresql.Driver");
		  System.out.println("Driver loaded");
		  Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
		  System.out.println("Connection established");
		  Statement stm=con.createStatement();
		  System.out.println("Statement created");
		  stm.executeUpdate("update employee set name='bhaiya' where id=101");
		  ResultSet rs=stm.executeQuery("select * from employee");
		  
		  while(rs.next())
		  {
			  System.out.println("id: "+rs.getInt("id"));
			  System.out.println("name: "+rs.getString("name"));
			  System.out.println("phone num: "+rs.getLong("phono"));
			 System.out.println("salary: "+rs.getDouble("sal"));
		  }
		  con.close();
		  
	  }
	 catch(ClassNotFoundException | SQLException e)
	  {
		 e.printStackTrace();
	  }
  }
}
