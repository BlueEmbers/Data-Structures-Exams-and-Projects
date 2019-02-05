package p2;

import java.util.Collections;

public class PersonBag
{
	
	private Person[] personArray = new Person[10];
	
	int nElems = 0;
	
	public void insertPerson(Person person)
	{
		if (personArray[nElems] == null)
		{
		personArray[nElems] = person;
		nElems++;
		}
	}
	

	public void display() 
	{
		for (int i = 0; i < nElems; i++) 
		{
			System.out.println(personArray[i]);

		}
	}
	
	public void sort()
	{
		/* Collections.sort method is sorting the 
        elements of ArrayList in ascending order. */
		Collections.sort(personArray, Collections.reverseOrder());
  
        // Let us print the sorted list 
        System.out.println("List after the use of" + 
                           " Collection.sort() :\n" + personArray); 
	}
	
}