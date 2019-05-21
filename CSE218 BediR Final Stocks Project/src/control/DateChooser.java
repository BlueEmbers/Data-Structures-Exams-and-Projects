package control;

import java.time.LocalDate;

import Utilities.AlertFactory;
import campos.model.Company;
import campos.model.Stock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import layout.SearchPane;

public class DateChooser extends DatePicker 
{
	private SearchPane pane;
	private Company c;
	
	public DateChooser(SearchPane stockSearchPane) 
	{
		super(LocalDate.now());
		this.setEditable(false);
		this.pane = stockSearchPane;
		this.c = stockSearchPane.getC();
		this.setOnAction(new StockDatePickerHandler());
	}
	
	private class StockDatePickerHandler implements EventHandler<ActionEvent> 
	{
		private Stock s;
		
		@Override
		public void handle(ActionEvent e) 
		{
			LocalDate key = pane.getDatePicker().getValue();
			s = c.getStockMap().get(key);
			
			if (s != null) 
				displayStockData();
			else
				AlertFactory.emitError("No stock price was listed on " + key);
		}
		
		public void displayStockData() {
			pane.getTfOpenValue().setText(s.getOpenValue() + "");
			pane.getTfHighValue().setText(s.getHighValue() + "");
			pane.getTfLowValue().setText(s.getLowValue() + "");
			pane.getTfCloseValue().setText(s.getCloseValue() + "");
			pane.getTfVolume().setText(s.getVolume() + "");
			
			Stock firstStock = c.getStockMap().firstEntry().getValue();
			if (s.compareTo(firstStock) == 0)
				AlertFactory.emitCompanyWentPublic(firstStock, c);
		}
	}
}
