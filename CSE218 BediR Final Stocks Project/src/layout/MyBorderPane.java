package layout;

import java.util.LinkedList;

import Utilities.FXUtil;
import campos.model.ChosenOnes;
import campos.model.Company;
import control.MyMenuBar;
import javafx.scene.layout.BorderPane;

public class MyBorderPane extends BorderPane {	
	public MyBorderPane(LinkedList<Company> list) {
		super(FXUtil.loadBackground(), new MyMenuBar(list), null, null, null);
		this.setStyle("-fx-background-color: #909000;");
		ChosenOnes.setRoot(this);
	}
}
