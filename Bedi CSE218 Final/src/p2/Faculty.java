package p2;

public class Faculty extends Person
{
	private String name;
	private double salary;
	public Faculty(String name, double salary) 
	{
		super(name);
		this.salary = salary;
	}
	
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Faculty [" + getName() + ", salary=" + salary + "]";
	}
	
	

}