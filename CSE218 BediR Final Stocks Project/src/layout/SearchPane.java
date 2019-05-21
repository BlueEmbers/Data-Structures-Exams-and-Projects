package layout;

import Utilities.FXUtil;
import campos.model.Company;
import control.DateChooser;
import control.MyLabel;
import control.NonEditables;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SearchPane extends GridPane {
	protected Company c;
	private DateChooser datePicker;
	protected TextField tfOpenValue, tfHighValue, tfLowValue, tfCloseValue, tfVolume;

	public SearchPane(Company c) {
		this.c = c;
		this.datePicker = new DateChooser(this);
		tfOpenValue = new NonEditables();
		tfHighValue = new NonEditables();
		tfLowValue = new NonEditables();
		tfCloseValue = new NonEditables();
		tfVolume = new NonEditables();
		displayControls();
	}
	
	private void displayControls() {
		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(FXUtil.DEFAULT_INSETS);
		this.setHgap(50);
		this.setVgap(60);
		
		this.add(new MyLabel("Look up a data for: " + c.getName() + " (" + c.getSymbol() + ")", Font.font(20)), 0, 0, 2, 1);
		this.addRow(1, new Label("Date:"), FXUtil.asHBox(datePicker));
		this.addRow(2, new Label("Open Value:"), tfOpenValue);
		this.addRow(3, new Label("High Value:"), tfHighValue);
		this.addRow(4, new Label("Low Value:"), tfLowValue);
		this.addRow(5, new Label("Close Value:"), tfCloseValue);
		this.addRow(6, new Label("Volume:"), tfVolume);
		tfOpenValue.setFont(new Font ("ALGERIAN", 20));
		tfHighValue.setFont(new Font ("ALGERIAN", 20));
		tfLowValue.setFont(new Font ("ALGERIAN", 20));
		tfCloseValue.setFont(new Font ("ALGERIAN", 20));
		tfVolume.setFont(new Font ("ALGERIAN", 20));
	}
	
	public Company getC() {
		return c;
	}
	
	public DateChooser getDatePicker() {
		return datePicker;
	}

	public TextField getTfOpenValue() {
		return tfOpenValue;
	}

	public TextField getTfHighValue() {
		return tfHighValue;
	}

	public TextField getTfLowValue() {
		return tfLowValue;
	}

	public TextField getTfCloseValue() {
		return tfCloseValue;
	}

	public TextField getTfVolume() {
		return tfVolume;
	}
}
