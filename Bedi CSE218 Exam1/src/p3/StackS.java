package p3;

public class StackS 
{
	LinkedList list;

	public StackS()
	{
		list = new LinkedList();
	}

	public void insertFirst(Student student)
	{
		list.insertFirst(student);
	}

	public Student pop()
	{
		return list.deleteFirst().getKeyData();
	}

	public boolean isEmpty() 
	{
		return list.isEmpty();
	}

}