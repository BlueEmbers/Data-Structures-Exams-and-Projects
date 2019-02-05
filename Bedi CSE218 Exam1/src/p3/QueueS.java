package p3;

public class QueueS 
{
	DoublyLinkedList list;

	public QueueS() 
	{
		list = new DoublyLinkedList();
	}

	public void insertLast(Student student) 
	{
		list.insertLast(student);
	}

	public Student removeFirst() 
	{
		return list.removeFirst().getKeyData();
	}

	public boolean isEmpty() 
	{
		return list.first == null;
	}

}