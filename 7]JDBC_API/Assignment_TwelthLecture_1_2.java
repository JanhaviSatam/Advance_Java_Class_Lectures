package servletFirst;

import java.sql.*;
import java.util.*;

public class Assignment_TwelthLecture_1_2 {

    static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver registered");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/janhavi", "root", "");
        System.out.println("Connection established");
        return con;
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);

        
        Assignment_TwelthLecture_1_3 emp = new Assignment_TwelthLecture_1_3();

        System.out.println("Enter empno:");
        emp.setEmpno(sc.nextInt());
        System.out.println("Enter name:");
        emp.setName(sc.next());
        System.out.println("Enter sal:");
        emp.setSalary(sc.nextInt());
        System.out.println("Enter deptno:");
        emp.setDeptno(sc.nextInt());

        
        insertEmployee(emp);

        display();
        update(emp);
        System.out.println(delete() + " records deleted");
        display();
    }

    static void insertEmployee(Assignment_TwelthLecture_1_3 emp) throws SQLException, ClassNotFoundException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement("insert into jdbc1(empno, name, sal, deptno) values (?, ?, ?, ?)");

        ps.setInt(1, emp.getEmpno());
        ps.setString(2, emp.getName());
        ps.setInt(3, emp.getSalary());
        ps.setInt(4, emp.getDeptno());

        int status = ps.executeUpdate();
        if (status > 0) {
            System.out.println("Employee inserted successfully.");
        } else {
            System.out.println("Employee insertion failed.");
        }
    }

    static void display() throws SQLException, ClassNotFoundException {
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("select * from jdbc1");

        System.out.println("Empno\tName\tSalary\tDeptno");
        System.out.println("------------------------------");
        while (res.next()) {
            System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getInt(3) + "\t" + res.getInt(4));
        }
    }

    static void update(Assignment_TwelthLecture_1_3  emp) throws SQLException, ClassNotFoundException {
        Connection con = connect();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter deptno:");
        int dept = sc.nextInt();
        System.out.println("Enter new salary:");
        emp.setSalary(sc.nextInt()) ;

        PreparedStatement pm = con.prepareStatement("update jdbc1 set sal=? where deptno=?");
        pm.setInt(1, emp.getSalary());
        pm.setInt(2, dept);
        int no = pm.executeUpdate();
        System.out.println(no + " records updated");
    }

    static int delete() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter empno to delete:");
        int empno = sc.nextInt();

        Connection con = connect();
        PreparedStatement pm = con.prepareStatement("delete from jdbc1 where empno=?");
        pm.setInt(1, empno);
        return pm.executeUpdate();
    }
}
