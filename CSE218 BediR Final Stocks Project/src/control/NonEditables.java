package control;

import javafx.scene.control.TextField;

public class NonEditables extends TextField {
	public NonEditables() {
		super.setEditable(false);
	}
}
