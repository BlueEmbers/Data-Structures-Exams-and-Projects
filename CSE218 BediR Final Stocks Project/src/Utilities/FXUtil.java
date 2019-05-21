package Utilities;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import campos.model.Company;
import campos.model.Stock;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FXUtil 
{
	public static final Insets DEFAULT_INSETS = new Insets(10);
	
	public static VBox asVBox(Node...nodes)
	{
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		for (Node e : nodes)
			vBox.getChildren().add(e);
		return vBox;
	}
	
	public static HBox asHBox(Node...nodes)
	{
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		for (Node e : nodes)
			hBox.getChildren().add(e);
		return hBox;
	}
	
	public static DatePicker loadInsertDatePicker() 
	{
		DatePicker datePicker = new DatePicker(LocalDate.now());
		datePicker.setEditable(false);
		datePicker.setDayCellFactory(e -> new DateCell()
		{
			public void updateItem(LocalDate date, boolean empty)
			{
	            super.updateItem(date, empty);
	            LocalDate today = LocalDate.now();
	            setDisable(empty || date.compareTo(today) < 0 );
	        }
		});
		return datePicker;
	}
	
	public static DatePicker loadSearchDatePicker()
	{
		DatePicker datePicker = new DatePicker(LocalDate.now());
		datePicker.setEditable(false);
		return datePicker;
	}
	
	public static StackPane loadBackground() 
	{
		StackPane pane = new StackPane();
		pane.setPadding(new Insets(50, 200, 50, 200));
		return pane;
	}
}
