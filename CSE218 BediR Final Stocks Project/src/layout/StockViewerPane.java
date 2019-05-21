package layout;

import java.time.LocalDate;

import Utilities.FXUtil;
import campos.model.Company;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.BorderPane;

@Deprecated
public class StockViewerPane extends BorderPane
{

	private LineChart<LocalDate, Number> lineChart;
	
	public StockViewerPane(Company c)
	{
		displayControls();
	}
	
	private void displayControls()
	{
		this.setPadding(FXUtil.DEFAULT_INSETS);
		this.setCenter(lineChart);
	}
}
