package InsertOutputPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import campos.model.Company;

public class DataSaver implements Constants 
{
	public static void main(String[] args) 
	{
		LinkedList<Company> companyList = DataLoader.loadParsedCompanyData();
		saveCompanyBag(companyList); 
	}
	
	public static void saveCompanyBag(LinkedList<Company> bag)
	{
		writeObject(bag, COMPANY_BAG);
	}

	public static void writeObject(Object o, String trgt) 
	{
		File file = new File(trgt);
		try 
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(o);
			oos.close();
			System.out.println("Written to " + file);

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
