package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CollegeBag;
import model.ModelBag;
import model.User;
import model.UserBag;

public class deploy extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		CollegeBag cBag = new CollegeBag();
		UserBag uBag = new UserBag();
		
		ModelBag mBag = new ModelBag(uBag, cBag); 
		
		MyLogInPane loginPane = new MyLogInPane(mBag);
		Scene loginScene = new Scene(loginPane.getPane());
		MySignUpPane signupPane = new MySignUpPane(mBag);
		Scene signupScene = new Scene(signupPane.getBox());
		
		signupPane.getCancel().setOnAction(e -> {
			loginPane.clearEverything();
			primaryStage.setScene(loginScene);
			primaryStage.show();
		});
		
		signupPane.getAlert().setOnCloseRequest(e -> {
			MyMainPane mainPane = new MyMainPane(signupPane.getUser(), mBag);
			Scene mainScene = new Scene(mainPane.getvBox());
			primaryStage.setScene(mainScene);
			primaryStage.show();
		});
		
		loginPane.getAlert1().setOnCloseRequest(e -> {
			MyMainPane mainPane = new MyMainPane(loginPane.getUser(), mBag);
			mainPane.getSignoutItem().setOnAction(f -> {
				loginPane.clearEverything();
				primaryStage.setScene(loginScene);
				primaryStage.show();
			});
			Scene mainScene = new Scene(mainPane.getvBox());
			primaryStage.setScene(mainScene);
			primaryStage.show();
		});
		
		loginPane.getSignUpButton().setOnAction(e -> {
			signupPane.clearEverything();
			primaryStage.setScene(signupScene);
			primaryStage.show();
		});
		
		
	
		primaryStage.setScene(loginScene);
		primaryStage.show();
		
	}

}
