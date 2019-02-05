package p3;

public class DoublyLinkedList 
{
	public Link first;
	public Link last;

	public DoublyLinkedList()
	{
		first = null;
		last = null;
	}

	public Link removeFirst()
	{
		Link temp = first;
		if (first.getNext() == null)
		{
			last = null;
		}
		first = first.getNext();
		return temp;
	}

	public void insertFirst(Student studentData) 
	{
		Link newLink = new Link(studentData);
		if (isEmpty()) 
		{
			last = newLink;
		}
		newLink.setNext(first);
		first = newLink;
	}

	public void insertLast(Student studentData)
	{
		Link newLink = new Link(studentData);
		if (isEmpty()) 
		{
			first = newLink;
		} 
		else 
		{
			last.setNext(newLink);
		}
		last = newLink;
	}

	public boolean isEmpty()
	{
		return first == null;
	}
}
