package control;

import java.time.LocalDate;

import Utilities.AlertFactory;
import campos.model.Stock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import layout.InsertPane;

public class InsertButton extends Button 
{
	private InsertPane pane;
	
	public InsertButton(InsertPane pane)
	{
		super("Insert");
		this.pane = pane;
		super.setOnAction(new InsertHandler());
	}
	
	private class InsertHandler implements EventHandler<ActionEvent> 
	{
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Inserting to " + pane.getC().getName() + "...");
			try 
			{
				LocalDate date = pane.getDatePicker().getValue();
				double openValue = pane.getTfOpenValue().getValue();
				double highValue = pane.getTfHighValue().getValue();
				double lowValue = pane.getTfLowValue().getValue();
				double closeValue = pane.getTfCloseValue().getValue();
				int volume = (int) pane.getTfVolume().getValue();
				Stock stock = new Stock(date, openValue, highValue, lowValue, closeValue, volume);
				pane.getC().getStockMap().put(stock.getLocalDate(), stock);
				AlertFactory.emitInfo("Insert", "Successfully added stock on " + date, "");
			}
			catch (NumberFormatException e) 
			{
				AlertFactory.emitError("Please write numbers only");
			}
		}
	}
}
