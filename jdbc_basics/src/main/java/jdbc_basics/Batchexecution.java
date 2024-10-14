package jdbc_basics;
import  java.sql.*;
import java.util.Scanner;
public class Batchexecution 
{
  public static void main(String args[])
  {
	  Scanner sc=new Scanner(System.in);
	  try {
		  Class.forName("org.postgresql.Driver");
		  Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
		  PreparedStatement ps=con.prepareStatement("select * from employee");
		 // PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
		  System.out.println("Enter id");
		  ps.setInt(1,sc.nextInt());
		  System.out.println("Enter name");
		  ps.setString(2,sc.next());
		  System.out.println("Enter Mobile number");
		  ps.setLong(3,sc.nextLong());
		  System.out.println("Enter salary");
		  ps.setDouble(4,sc.nextDouble());
		  ps.addBatch();
		  ps.execute();
		//  System.out.println("Enter id");
//		  ps.addBatch("insert into employee values(?,?,?,?)"); //we cannot use batch like this
//		  System.out.println("Enter id");
//		  ps.setInt(1,sc.nextInt());
//		  System.out.println("Enter name");
//		  ps.setString(2,sc.next());
//		  System.out.println("Enter Mobile number");
//		  ps.setLong(3,sc.nextLong());
//		  System.out.println("Enter salary");
//		  ps.setDouble(4,sc.nextDouble());
//		  con.close();
	  }
	  catch(ClassNotFoundException | SQLException e)
	  {
		  e.printStackTrace();
	  }
  }
}
