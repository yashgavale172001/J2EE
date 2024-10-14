package jdbc_basics;
import java.sql.*;
import java.util.Scanner;
public class printdata 
{
  public static void main(String args[])
  {
	  Scanner sc=new Scanner(System.in);
	  try {
		  Class.forName("org.postgresql.Driver");
		  Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
		  PreparedStatement ps=con.prepareStatement("select * from student order by id");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			 // System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getLong("phono")+" "+rs.getDouble("sal"));
			  System.out.println(rs.getInt("id")+" "+rs.getString("name"));
		  }
		  con.close();
	  }
	  catch(ClassNotFoundException | SQLException e)
	  {
		  e.printStackTrace();
	  }
  }
}
