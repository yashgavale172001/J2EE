package jdbc_basics;
import java.util.Scanner;
import java.sql.*;
//we can add multiple statements inside table using batch method
public class addBatch2 
{
  public static void main(String args[])
  {
	  Scanner sc=new Scanner(System.in);
	  try {
		  Class.forName("org.postgresql.Driver");
		  Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
		  PreparedStatement ps=con.prepareStatement("insert into student values(?,?)");
		  System.out.println("Enter number of rows you want to enter");
		  int a=sc.nextInt();
		  for(int i=0;i<a;i++)
		  {
			  System.out.println("Enter id");
			  ps.setInt(1, sc.nextInt());
			  System.out.println("Enter name");
			  ps.setString(2, sc.next());
			  ps.addBatch();
			  ps.executeBatch(); // without writing this we cannot add,we can add data by executing addBatch method and after that execute the executeBatch method
			  //ps.execute(); //by only writting this we can also add data multiple times
		  }
		  con.close();
	  }
	  catch(ClassNotFoundException | SQLException e)
	  {
		  e.printStackTrace();
	  }
  }
}
