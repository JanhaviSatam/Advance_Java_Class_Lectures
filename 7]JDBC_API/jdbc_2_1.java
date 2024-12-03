package JDBC_API;

import java.sql.*;
import java.util.*;
public class jdbc_2_1 {
	
	static Connection connect() throws ClassNotFoundException , SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver registered");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/janhavi","root","");
		 System.out.println("Connection established");
		
		return con;
	}
	
	
	public static  void main(String args[])throws ClassNotFoundException , SQLException
	{
		 Scanner sc = new Scanner(System.in);
		 Connection con = connect();
		 Statement stmt = con.createStatement();
		 System.out.println("Enter deptno:");
		 int deptno = sc.nextInt();
		 System.out.println("Enter Sal:");
		 int sal = sc.nextInt();
		 
		//--------------------------------update-------------------------------------------------
		 PreparedStatement pmt = con.prepareStatement("update jdbc1 set sal=? where deptno=?");
		 pmt.setInt(1, sal);
		 pmt.setInt(2, deptno); 
		 int no=pmt.executeUpdate();
		 System.out.println(no+" records are updated");
		 
		 
		 display();
		 
		 System.out.println(delete()+"records deleted");
		 display();
	}
	
	static void  display() throws SQLException , ClassNotFoundException
	{
		Connection con = connect();
		Scanner sc = new Scanner(System.in);
		Statement stmt = con.createStatement();
		System.out.println("Enter deptno:");
		int deptno = sc.nextInt();
		
		//ResultSet res = stmt.executeQuery("select * from jdbc1 where deptno="+deptno);
		ResultSet res = stmt.executeQuery("select * from jdbc1");
		
		System.out.println("Empno\tName\tSalary\tDeptno");
		System.out.println("------------------------------");
		while(res.next())
		{
			System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3)+"\t"+res.getInt(4));
		}
	}
	
	
	static int delete()throws SQLException , ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		Connection con = connect();
		Statement stmt = con.createStatement();
		System.out.println("enter empno:");
		int empno = sc.nextInt();
		
		PreparedStatement pm = con.prepareStatement("delete from jdbc1 where empno=?");
		
		pm.setInt(1, empno);
		int no=pm.executeUpdate();
		
		return no;
	}
	
}
