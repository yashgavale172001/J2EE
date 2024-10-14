package jdbc_basics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCSteps 
{
  public static void main(String args[])
  {
	  try {
		  Class.forName("org.postgresql.Driver");
		  Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
		  Statement stm=con.createStatement();
//		  stm.execute("insert into employee values(101,'yash',7276590778,700000)");
//		  stm.execute("insert into employee values(102,'mangesh',727785454,6465456)");
//		  stm.execute("insert into employee values(103,'sandesh',5689643322,123456789)");
//		  stm.execute("insert into employee values(104,'gaurav',8010354375,6644443334)");
		  //ResultSet rs=stm.executeQuery("")
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
