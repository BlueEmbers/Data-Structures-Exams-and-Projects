package p3;

public class LinkedList
{
	private Link first;

	public LinkedList() 
	{
		first = null;
	}

	public void insertFirst(Student dData) 
	{
		Link newLink = new Link(dData);
		newLink.setNext(first);
		first = newLink;
	}

	public Link deleteFirst()
	{
		Link temp = first;
		first = first.getNext();
		return temp;
	}

	public Link find(Student key)
	{
		Link current = first;
		while (current.getKeyData() != key) 
		{
			if (current.getNext() == null) 
			{
				return null;
			} 
			else
			{
				current = current.getNext();
			}
		}
		return current;
	}

	public boolean isEmpty()
	{
		return first == null;
	}
}
