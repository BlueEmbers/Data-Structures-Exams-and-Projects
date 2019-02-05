package p3;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;

public class Demo extends Application
{

	public static void main(String[] args) 
	{
		launch(args);
	}

//	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Pane pane = new Gui().mainPane;
		Scene gui = new Scene(pane, 250, 200);
		primaryStage.setScene(gui);
		primaryStage.show();
	}
}
