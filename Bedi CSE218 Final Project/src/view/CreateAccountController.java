package view;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import data.AllUsers;
import data.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController implements Initializable{
	@FXML 
	private Button continueCreateAccount;
	@FXML
	private TextField userName;
	@FXML
	private PasswordField password;
	//@FXML
	//private TreeSet<Users> allUsers = new TreeSet<>();
	
	@FXML 
	public void continueCreateAccount(ActionEvent event) {
		Users u1 = new Users(userName.getText(), password.getText());
		Gui.userSet.add(u1);
		System.out.println(Gui.userSet.toString());
		data.AllUsers.userSave(Gui.userSet);
		try {
			Gui.userSet = AllUsers.userLoad();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Parent profileView;
		
		try {
			profileView = FXMLLoader.load(getClass().getResource("Profile.fxml"));
			
			Scene profileScene = new Scene(profileView);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setResizable(false);
			window.setScene(profileScene);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	
	
	

}
