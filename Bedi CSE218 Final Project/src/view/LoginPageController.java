package view;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginPageController implements Initializable{

	@FXML
	private Button login;
	@FXML
	private Button cancel;
	@FXML
	private Button createAcount;
	@FXML 
	private Hyperlink createAccountLink;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private ImageView image = new ImageView();
	@FXML
	private Button continueCreateAccount;
	@FXML
	private Set<String> usernameStore = new TreeSet<>();
	
	static String usernameKey;
	
	
	public void userLogin(ActionEvent event) {
		
		
		
		
	}
	
	
	@FXML
	public void passwordEnter(ActionEvent event) throws IOException {
		Parent profileView;
		//if(username.getText().equals(Gui.userSet) && password.getText().equals(Gui.userSet.contains(password)));
		String userName = username.getText();
		String passWord = password.getText();
		Iterator it = Gui.userSet.iterator();
		Users u = (Users) it.next();
		
		
		while(it.hasNext()) {
			
			if(userName.equals(u.getUsername()) && passWord.equals(u.getPassword())) {
				usernameKey = u.getUsername();
				 profileView = FXMLLoader.load(getClass().getResource("AccountPage.fxml"));
				
				Scene profileScene = new Scene(profileView);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(profileScene);
				
				break;
				
				
			}
			u = (Users)it.next();
			
			if(!it.hasNext()) {
				System.out.println("Wrong Username or Password");
			}
			
			
		}
		
		
		
		
	}
	@FXML
	public void loginIn(ActionEvent event) {
		Parent profileView;
		
		if (username.getText().equals("Braulio1") && password.getText().equals("Braulio1")) {
			try {
				profileView = FXMLLoader.load(getClass().getResource("Profile.fxml"));
				
				Scene profileScene = new Scene(profileView);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(profileScene);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else 
			System.out.print("Account not found");
		
		
	}
	@FXML
	
	public void createAccount(ActionEvent event) {
		Parent profileView;
		try {
			profileView = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
			Scene profileScene = new Scene(profileView);
			Stage newAccountWindow = new Stage();
			//Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			newAccountWindow.setScene(profileScene);
			newAccountWindow.setResizable(false);
			newAccountWindow.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("ok");
		try {
			Gui.userSet = AllUsers.userLoad();
			Gui.schoolTable = AllUsers.loadSchools();
			System.out.println(Gui.userSet.toString());
			System.out.println(Gui.schoolTable.get("Boston College"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	
	
	

}
