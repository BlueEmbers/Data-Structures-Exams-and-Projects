package eventHandler;

import java.util.LinkedList;

import InsertOutputPackage.DataSaver;
import Utilities.AlertFactory;
import campos.model.Company;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ExitHandler<T extends Event> implements EventHandler<T>
{
	private LinkedList<Company> companyBag;
	
	public ExitHandler(LinkedList<Company> companyBag) 
	{
		this.companyBag = companyBag;
	}
	
	@Override
	public void handle(T event) 
	{
		boolean flag = AlertFactory.emitExit();
		if (flag)
		{
			DataSaver.saveCompanyBag(companyBag);
			Platform.exit();
		} 
		else 
		{
			event.consume();
		}
	}
}
