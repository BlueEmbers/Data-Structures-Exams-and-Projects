package demoPackage;

import javafx.application.Application;
import javafx.stage.Stage;
import mainStage.MyStage;

public class App extends Application
{
	@Override
	public void start(Stage stage)
	{
		stage = new MyStage();
		stage.show();
	}
	
	public static void main(String[] args) throws Exception 
	{
		launch(args);
	}
}
