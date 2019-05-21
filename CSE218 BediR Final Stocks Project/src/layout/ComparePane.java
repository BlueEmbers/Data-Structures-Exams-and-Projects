package layout;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import Utilities.FXUtil;
import campos.model.Company;
import campos.model.Stock;
import control.AverageText;
import control.DateChooser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ComparePane extends BorderPane {
	private Label lblAvg;
	private AverageText tfOpen, tfHigh, tfLow, tfClose, tfVolume;
	private DateChooser oldestDatePicker;
	private DateChooser latestDatePicker;
	private Company c;

	public ComparePane(SearchPane oldStockPane, SearchPane lateStockPane) {
		this.lblAvg = new Label("Average:");
		this.tfOpen = new AverageText("Open Value");
		this.tfHigh = new AverageText("High Value");
		this.tfLow = new AverageText("Low Value");
		this.tfClose = new AverageText("Close Value");
		this.tfVolume = new AverageText("Volume");
		this.oldestDatePicker = oldStockPane.getDatePicker();
		this.latestDatePicker = lateStockPane.getDatePicker();
		this.oldestDatePicker.addEventHandler(ActionEvent.ACTION, new StockRangePickerHandler());
		this.latestDatePicker.addEventHandler(ActionEvent.ACTION, new StockRangePickerHandler());
		this.c = oldStockPane.getC();
		this.setLeft(oldStockPane);
		this.setCenter(getCenterPane());
		this.setRight(lateStockPane);
		this.setPadding(FXUtil.DEFAULT_INSETS);
	}
	
	public GridPane getCenterPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setPadding(FXUtil.DEFAULT_INSETS);
		gridPane.setVgap(75);
		gridPane.addColumn(0, lblAvg, tfOpen, tfHigh, tfLow, tfClose, tfVolume);
		return gridPane;
	}
	
	private class StockRangePickerHandler implements EventHandler<ActionEvent> {
		private LocalDate oldDate;
		private LocalDate lateDate;
		private double avgOpen, avgHigh, avgLow, avgClose;
		private int avgVolume;
		
		@Override
		public void handle(ActionEvent e) {
			oldDate = oldestDatePicker.getValue();
			lateDate = latestDatePicker.getValue();
			if (oldDate.compareTo(lateDate) < 0) { // Is oldDate older than lateDate?
				calcAveragePrices();
			}
		}
		
		public void calcAveragePrices() {
			Map<LocalDate, Stock> subMap = c.getStockMap().subMap(oldDate, lateDate.plusDays(1));			
			Set<LocalDate> dateSet = subMap.keySet();
			
			avgOpen = 0; avgHigh = 0; avgLow = 0; avgClose = 0; avgVolume = 0;
			
			for (LocalDate localDate : dateSet) {
				Stock stock = subMap.get(localDate);
				avgOpen += stock.getOpenValue();
				avgHigh += stock.getHighValue();
				avgLow += stock.getLowValue();
				avgClose += stock.getCloseValue();
				avgVolume += stock.getVolume();
				System.out.println(stock);
			}
			
			avgOpen /= subMap.size();
			avgHigh /= subMap.size();
			avgLow /= subMap.size();
			avgClose /= subMap.size();
			avgVolume /= subMap.size();

			displayAvgValues();
			
//			System.out.println();
//			System.out.println("Average Open Value: " + avgOpenValue);
//			System.out.println("Average High Value: " + avgHighValue);
//			System.out.println("Average Low Value: " + avgLowValue);
//			System.out.println("Average Close Value: " + avgCloseValue);
//			System.out.println("Average Volume: " + avgVolume);
//			System.out.println();
		}
		
		public void displayAvgValues() {
			lblAvg.setText("Average: (" + oldDate + " - " + lateDate + ")");
			tfOpen.setText(String.format("%-10.2f", avgOpen));
			tfHigh.setText(String.format("%-10.2f", avgHigh));
			tfLow.setText(String.format("%-10.2f", avgLow));
			tfClose.setText(String.format("%-10.2f", avgClose));
			tfVolume.setText(String.format("%-10d", avgVolume));
		}
	}
}
