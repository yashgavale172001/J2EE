package jdbc_basics;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TakingUserInput 
{
  public static void main(String args[])
  {
	  Scanner sc=new Scanner(System.in);
	  try {
		  Class.forName("org.postgresql.Driver");
		  Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
		  //PreparedStatement ps=con.prepareStatement("insert into student values(?,?)");
		  PreparedStatement ps=con.prepareStatement("select * from student order by id ");
//		  System.out.println("Enter how many inputs yout want to enter in table");
//		  int n=sc.nextInt();
//		  for(int i=0;i<n;i++)
//		  {
//			  System.out.println("Enter id");
//			  ps.setInt(1, sc.nextInt());
//			  System.out.println("Enter name");
//			  ps.setString(2, sc.next());
//		  }
		  //ps.execute();
		// ResultSet rs=ps.getResultSet();
		 ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {
			 System.out.print("id: "+rs.getInt("id")+" ");
			 System.out.println("name: "+rs.getString("name"));
		 }
		 con.close();
	  }
	  catch(ClassNotFoundException | SQLException e)
	  {
		  e.printStackTrace();
	  }
  }
}
