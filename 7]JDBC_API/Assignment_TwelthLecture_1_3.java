package servletFirst;



	public class  Assignment_TwelthLecture_1_3 {
	    private int empno;
	    private String name;
	    private int salary;
	    private int deptno;

	    
	    public Assignment_TwelthLecture_1_3() {}

	    public Assignment_TwelthLecture_1_3(int empno, String name, int salary, int deptno) {
	        this.empno = empno;
	        this.name = name;
	        this.salary = salary;
	        this.deptno = deptno;
	    }

	    
	    public int getEmpno() {
	        return empno;
	    }

	    public void setEmpno(int empno) {
	        this.empno = empno;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getSalary() {
	        return salary;
	    }

	    public void setSalary(int salary) {
	        this.salary = salary;
	    }

	    public int getDeptno() {
	        return deptno;
	    }

	    public void setDeptno(int deptno) {
	        this.deptno = deptno;
	    }

	    @Override
	    public String toString() {
	        return "Employee{" +
	                "empno=" + empno +
	                ", name='" + name + '\'' +
	                ", salary=" + salary +
	                ", deptno=" + deptno +
	                '}';
	    }
	}

	
	
	

