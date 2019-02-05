package p3;

public class Student
{
	private String id;
	private String name;
	private double gpa;

	public static int idInc = 0;

	public Student(String name, double gpa)
	{
		this.name = name;
		this.gpa = gpa;
		this.id = Integer.toString(idInc++);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getGpa() 
	{
		return gpa;
	}

	public void setGpa(double gpa)
	{
		this.gpa = gpa;
	}

	public String getId()
	{
		return id;
	}
}