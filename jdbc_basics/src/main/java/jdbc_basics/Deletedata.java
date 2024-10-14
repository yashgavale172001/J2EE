package jdbc_basics;
import java.sql.*;
import java.util.Scanner;
public class Deletedata 
{
  public static void main(String args[])
  { 
	  Scanner sc=new Scanner(System.in);
	  try {
		  Class.forName("org.postgresql.Driver");
		  Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
		//  PreparedStatement ps=con.prepareStatement("delete from student");
		  PreparedStatement ps=con.prepareStatement("delete from student where id=?");
		  ps.setInt(1, sc.nextInt());
		  System.out.println("Deleted");
		  ps.execute();
		  con.close();
	  }
	  catch(ClassNotFoundException | SQLException e)
	  {
		  e.printStackTrace();
	  }
  }
}
