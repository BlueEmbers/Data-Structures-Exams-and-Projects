package mainStage;

import java.util.LinkedList;

import InsertOutputPackage.DataLoader;
import campos.model.Company;
import eventHandler.ExitHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import layout.MyBorderPane;

public class MyStage extends Stage {
	public static final String TITLE = "Stock prices of 20 years";
	private LinkedList<Company> companyBag;
	private MyBorderPane root;

	public MyStage() {
		this.companyBag = DataLoader.loadCompanyBag();
		this.root = new MyBorderPane(companyBag);
	///	ImgUtil.loadStageIcon(this);
		this.setTitle(TITLE);
		this.setScene(new Scene(root, 1000, 800));
		this.setOnCloseRequest(new ExitHandler<WindowEvent>(companyBag));
	}
}
