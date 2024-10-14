package jdbc_basics;
import java.sql.*;

public class addBatch3 
{
   public static void main(String args[])
   {
	   try {
		   Class.forName("org.postgresql.Driver");
		   Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
		  // PreparedStatement ps=con.prepareStatement("");
		   Statement stm=con.createStatement();
		   stm.addBatch("insert into student values(67,'manju')");
		   stm.addBatch("insert into student values(69,'ganju')");
		   stm.addBatch("update student set name='arman' where id=45");
		   stm.addBatch("delete from student where id=98");
		   System.out.println("Done");
		   stm.executeBatch();
		   con.close();
	   }
	   catch(ClassNotFoundException | SQLException e)
	   {
		   e.printStackTrace();
	   }
   }
}
