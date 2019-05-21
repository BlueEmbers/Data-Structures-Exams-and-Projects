package eventHandler;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import layout.InsertPane;
import layout.SearchTPane;
import Utilities.AlertFactory;
import campos.model.ChosenOnes;
import campos.model.Company;

public class OperationHandler implements EventHandler<ActionEvent>
{
	private String name;
	
	public OperationHandler(String name)
	{
		this.name = name.toUpperCase();
	}
	
	@Override
	public void handle(ActionEvent event) 
	{
		switch(name)
		{
		case "INSERT":
			toInsertPane();
			break;
		case "SEARCH":
			toSearchPane();
			break;
		}
	}
	
	public void toInsertPane()
	{
		Company c = ChosenOnes.company;
		if (c != null)
		{
			ChosenOnes.root.setCenter(new InsertPane());
		} 
	}
	
	public void toSearchPane() 
	{
		Company c = ChosenOnes.company;
		if (c != null) 
		{
			ChosenOnes.root.setCenter(new SearchTPane(c));
		}
	}
}
