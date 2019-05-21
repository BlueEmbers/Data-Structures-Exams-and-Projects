package control;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class AverageText extends TextField
{
	public AverageText(String prompt) 
	{
		super.setPromptText(prompt);
		super.setAlignment(Pos.CENTER);
		super.setEditable(false);
	}
}


