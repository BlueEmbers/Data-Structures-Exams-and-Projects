package p3;

public class Link 
{
	private Student keyData;
	private Link next;

	public Link(Student keyData) 
	{
		this.keyData = keyData;
		next = null;
	}

	public Student getKeyData() 
	{
		return keyData;
	}

	public void setdData(Student keyData) 
	{
		this.keyData = keyData;
	}

	public Link getNext() 
	{
		return next;
	}

	public void setNext(Link next) 
	{
		this.next = next;
	}

	public void displayLink() 
	{
		System.out.println(keyData + " ");
	}
}
