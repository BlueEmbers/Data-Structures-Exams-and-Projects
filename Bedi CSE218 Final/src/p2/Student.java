package p2;

public class Student  extends Person
{
	private String name;
	private double gpa;
	
	public Student(String name, double gpa) 
	{
		super(name);
		this.gpa = gpa;
	}
	
	public double getGpa() 
	{
		return gpa;
	}
	public void setGpa(double gpa) 
	{
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "Students [name = " + getName() + ", gpa = " + gpa + "]";
	}
	

}