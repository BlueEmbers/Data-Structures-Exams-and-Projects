package view;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import data.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AccountPageController implements Initializable {

	@FXML
	private Label userName;
	@FXML
	private Label name;
	@FXML
	private Label email;
	@FXML
	private Label gpa;
	@FXML
	private Label satM;
	@FXML
	private Label satR;
	@FXML
	private Button search;
	
	@FXML
	public void searchPage(ActionEvent event) {
		Parent profileView;
		try {
			profileView = FXMLLoader.load(getClass().getResource("SearchSchools.fxml"));
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(profileView);
			window.setResizable(false);
			window.setScene(scene);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(LoginPageController.usernameKey);
		Iterator<Users> it = Gui.userSet.iterator();
		Users user = (Users)it.next();
		while(it.hasNext()) {
			if(user.getUsername().equals(LoginPageController.usernameKey)) {
				userName.setText(user.getUsername());
				name.setText(user.getName());
				email.setText(user.getEmail());
				gpa.setText(String.valueOf(user.getGpa()));
				satM.setText(String.valueOf(user.getMathSAT()));
				satR.setText(String.valueOf(user.getReadingSAT()));
			}
			user = (Users)it.next();
		}
		
		
	}

}
