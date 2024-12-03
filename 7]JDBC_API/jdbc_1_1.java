package JDBC_API;
import java.sql.*;

public class jdbc_1_1 {
public static void main (String args [])throws ClassNotFoundException , SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver registered");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/janhavi","root","");
	System.out.println("Connection established");
	//[CDC-1.0/Foundation-1.0]
	//mysql-connector-java-8.0.21
	
	Statement stmt = con.createStatement();
	
	ResultSet rs = stmt.executeQuery("select * from jdbc1");
	System.out.println("Empno\tname\tSalary\tDeptno");
	System.out.println("---------------------------");
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
	}
}
}
 