package view;



import java.util.Hashtable;
import java.util.TreeSet;

import data.AllUsers;
import data.Schools;
import data.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application{
	
 static TreeSet<Users> userSet = new TreeSet<>();
 static Hashtable<String, Schools> schoolTable = new Hashtable<>();

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		

		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		stage.setTitle("College Transfer Management System");
		Scene scene = new Scene(root);
		//URL loginCss = new URL("LoginCSS.css");
		scene.getStylesheets().add(Gui.class.getResource("LoginCSS.css").toExternalForm());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}

}
