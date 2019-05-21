package control;

import javafx.scene.control.TextField;

public class ValueTextFields extends TextField
{
	public ValueTextFields() 
	{
		super("0.0");
		super.textProperty().addListener((observable, oldValue, newValue) -> {
			try 
			{
				Double.parseDouble(newValue);
				setStyle("");
			}
			catch (NumberFormatException e)
			{
				setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
			}
		});
	}
	
	public double getValue() {
		return Double.parseDouble(getText());
	}
}
