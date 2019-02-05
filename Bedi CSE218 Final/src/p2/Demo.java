package p2;

import java.util.Arrays;
import java.util.Collections;

public class Demo 
{
	public static void main(String[] args) 
	{
		
		Faculty f1 = new Faculty("CHEN", 100000);
		Faculty f2 = new Faculty("FULTON", 70000);
		Student s1 = new Student("Raj Bedi" , 4.0);
		Student s2 = new Student("WanWan Xu" , 3.5);

		PersonBag personBag = new PersonBag();
		
		personBag.insertPerson(f1);
		personBag.insertPerson(f2);
		personBag.insertPerson(s1);
		personBag.insertPerson(s2);

		personBag.display();
		personBag.sort();
		// Check sort in personBag

 
		
	}
}
