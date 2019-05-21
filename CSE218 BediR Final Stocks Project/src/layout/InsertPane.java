package layout;

import Utilities.FXUtil;
import campos.model.ChosenOnes;
import campos.model.Company;
import control.InsertButton;
import control.MyLabel;
import control.ValueTextFields;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InsertPane extends BorderPane {
	private Company c;
	private DatePicker datePicker;
	private ValueTextFields tfOpenValue, tfHighValue, tfLowValue, tfCloseValue, tfVolume;
	private Button btInsert;
	
	public InsertPane() {
		initControls();
		displayControls();
	}
	
	public Company getC() {
		return c;
	}
	
	public DatePicker getDatePicker() {
		return datePicker;
	}

	public ValueTextFields getTfOpenValue() {
		return tfOpenValue;
	}

	public ValueTextFields getTfHighValue() {
		return tfHighValue;
	}

	public ValueTextFields getTfLowValue() {
		return tfLowValue;
	}

	public ValueTextFields getTfCloseValue() {
		return tfCloseValue;
	}

	public ValueTextFields getTfVolume() {
		return tfVolume;
	}
	
	public void clearAll() {
		tfOpenValue.clear();
		tfHighValue.clear();
		tfLowValue.clear();
		tfCloseValue.clear();
		tfVolume.clear();
	}

	private void initControls() {
		c = ChosenOnes.company;
		datePicker = FXUtil.loadInsertDatePicker();
		tfOpenValue = new ValueTextFields();
		tfHighValue = new ValueTextFields();
		tfLowValue = new ValueTextFields();
		tfCloseValue = new ValueTextFields();
		tfVolume = new ValueTextFields();
		btInsert = new InsertButton(this);
	}
	
	private void displayControls() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setPadding(FXUtil.DEFAULT_INSETS);
		gridPane.setHgap(50);
		gridPane.setVgap(60);
		gridPane.add(new MyLabel("Inserting Data to: " + c.getName() + " (" + c.getSymbol() + ")", Font.font(20)), 0, 0, 2, 1);
		gridPane.addRow(1, new Label("Date:"), FXUtil.asHBox(datePicker));
		gridPane.addRow(2, new Label("Open Value:"), tfOpenValue);
		gridPane.addRow(3, new Label("High Value:"), tfHighValue);
		gridPane.addRow(4, new Label("Low Value:"), tfLowValue);
		gridPane.addRow(5, new Label("Close Value:"), tfCloseValue);
		gridPane.addRow(6, new Label("Volume:"), tfVolume);
		tfOpenValue.setFont(new Font ("ALGERIAN", 20));
		tfHighValue.setFont(new Font ("ALGERIAN", 20));
		tfLowValue.setFont(new Font ("ALGERIAN", 20));
		tfCloseValue.setFont(new Font ("ALGERIAN", 20));
		tfVolume.setFont(new Font ("ALGERIAN", 20));
		
		VBox vBox = FXUtil.asVBox(btInsert);
		vBox.setPadding(FXUtil.DEFAULT_INSETS);
		super.setBottom(vBox);
		super.setCenter(gridPane);
	}
}
