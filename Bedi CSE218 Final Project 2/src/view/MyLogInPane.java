package view;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.ModelBag;
import model.User;

public class MyLogInPane {
	
	private GridPane pane;
	private Button signInButton;
	private Button signUpButton;
	private TextField usernameField;
	private PasswordField passwordField;
	private Text usernameErrorText;
	private Text passwordErrorText;
	private Text signInText;
	private VBox signInBox;
	private VBox signUpBox;
	private Image suffolkLogo;
	private ImageView suffolkLogoView;
	private Text welcomeText;
	private Text welcomeMessageText;
	private ModelBag bag;
	private User user;
	private Alert alert1;
	
	public MyLogInPane(ModelBag bag) {
		String nameString = "";
		this.pane = new GridPane();
		pane.setHgap(1);
		pane.setVgap(4);
		pane.setPadding(new Insets(40));
		pane.setStyle("-fx-background-color: #0054a4");
		
		this.alert1 = new Alert(AlertType.INFORMATION, "Welcome!");
		alert1.setHeaderText("Welcome!");
		
//******************************************************TEXTS
		
		this.signInText = new Text("\n\n\t       Sign In\n");
		signInText.setFont(Font.font("System", FontWeight.BOLD, 20));
		signInText.setFill(Paint.valueOf("#0054a4"));
		
		this.welcomeText = new Text("Welcome to SuffolkTransfer");
		welcomeText.setFont(Font.font("System", 20));
		welcomeText.setFill(Paint.valueOf("ffffff"));
		
		this.welcomeMessageText = new Text("Your guide to transferring from Suffolk County Community College to a four-year institution.\n");
		welcomeMessageText.setFont(Font.font("System", 14));
		welcomeMessageText.setFill(Paint.valueOf("ffffff"));
		welcomeMessageText.setWrappingWidth(300);
		
		this.passwordErrorText = new Text("Incorrect password.  Please try again.\n");
		passwordErrorText.setFont(Font.font("System", 12));
		passwordErrorText.setFill(Color.RED);
		passwordErrorText.setOpacity(0);
		
		this.usernameErrorText = new Text("Username does not exist.  Please try again.");
		usernameErrorText.setFont(Font.font("System", 12));
		usernameErrorText.setFill(Color.RED);
		usernameErrorText.setOpacity(0);
		

//*****************************************************TEXTFIELDS
		
		this.usernameField = new TextField();
		usernameField.setPrefWidth(30);
		usernameField.setPromptText("username");
		usernameField.setOnKeyTyped(e -> {
			usernameErrorText.setOpacity(0);
		});
		
		this.passwordField = new PasswordField();
		passwordField.setPrefWidth(30);
		passwordField.setPromptText("password");
		passwordField.setOnKeyTyped(e -> {
			passwordErrorText.setOpacity(0);
		});
		
//*****************************************************BUTTONS
			
		this.signInButton = new Button("Sign In");
		signInButton.setStyle("-fx-background-color: #0054a4");
		signInButton.setTextFill(Color.WHITE);
		signInButton.setPrefWidth(300);
		
		this.signUpButton = new Button("Sign Up");
		signUpButton.setStyle("-fx-background-color: #ffffff");
		signUpButton.setTextFill(Paint.valueOf("#0054a4"));
		signUpButton.setPrefWidth(200);
		
		
		this.suffolkLogo = new Image("file:large.png");
		this.suffolkLogoView = new ImageView();
		suffolkLogoView.setImage(suffolkLogo);
		suffolkLogoView.setFitWidth(400);
		suffolkLogoView.setPreserveRatio(true);
		suffolkLogoView.setSmooth(true);
		suffolkLogoView.setCache(true);
		
		this.signInBox = new VBox(10);
		signInBox.setPadding(new Insets(30));
		signInBox.setMaxSize(300, 400);
		signInBox.setMinSize(300, 400);
		this.signUpBox = new VBox(10);
		signUpBox.setPadding(new Insets(10));
		signUpBox.setMaxSize(400, 400);
		signUpBox.setMinSize(400, 400);
		
		signInBox.setStyle("-fx-background-color: #ffffff");
		signUpBox.setStyle("-fx-background-color: #0054a4");
		
		signInBox.getChildren().addAll(signInText, usernameField, usernameErrorText, passwordField, passwordErrorText, signInButton);
		signUpBox.getChildren().addAll(suffolkLogoView, welcomeText, welcomeMessageText, signUpButton);
		
		pane.add(signUpBox, 0, 0);
		pane.add(signInBox, 1, 0);		

		
		signInButton.setOnAction(e -> {
			if(usernameField.getText().length() == 0) {
				usernameErrorText.setOpacity(1);
				return;
			}
			if(!bag.getUserBag().getMap().containsKey(usernameField.getText())) {
				usernameErrorText.setOpacity(1);
				return;
			}
			if(!bag.getUserBag().getUser(usernameField.getText()).getPassword().equals(passwordField.getText())){
				passwordErrorText.setOpacity(1);
				return;
			}
			this.user = bag.getUserBag().getUser(usernameField.getText());
			alert1.show();
			
		});
		
		
	}


	public Button getSignInButton() {
		return signInButton;
	}


	public void setSignInButton(Button signInButton) {
		this.signInButton = signInButton;
	}


	public Button getSignUpButton() {
		return signUpButton;
	}


	public void setSignUpButton(Button signUpButton) {
		this.signUpButton = signUpButton;
	}


	public TextField getUsernameField() {
		return usernameField;
	}


	public void setUsernameField(TextField usernameField) {
		this.usernameField = usernameField;
	}


	public PasswordField getPasswordField() {
		return passwordField;
	}


	public void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}


	public Text getUsernameErrorText() {
		return usernameErrorText;
	}


	public void setUsernameErrorText(Text usernameErrorText) {
		this.usernameErrorText = usernameErrorText;
	}


	public Text getPasswordErrorText() {
		return passwordErrorText;
	}


	public void setPasswordErrorText(Text passwordErrorText) {
		this.passwordErrorText = passwordErrorText;
	}


	public Text getSignInText() {
		return signInText;
	}


	public void setSignInText(Text signInText) {
		this.signInText = signInText;
	}


	public VBox getSignInBox() {
		return signInBox;
	}


	public void setSignInBox(VBox signInBox) {
		this.signInBox = signInBox;
	}


	public VBox getSignUpBox() {
		return signUpBox;
	}


	public void setSignUpBox(VBox signUpBox) {
		this.signUpBox = signUpBox;
	}


	public Image getSuffolkLogo() {
		return suffolkLogo;
	}


	public void setSuffolkLogo(Image suffolkLogo) {
		this.suffolkLogo = suffolkLogo;
	}


	public ImageView getSuffolkLogoView() {
		return suffolkLogoView;
	}


	public void setSuffolkLogoView(ImageView suffolkLogoView) {
		this.suffolkLogoView = suffolkLogoView;
	}


	public Text getWelcomeText() {
		return welcomeText;
	}


	public void setWelcomeText(Text welcomeText) {
		this.welcomeText = welcomeText;
	}


	public Text getWelcomeMessageText() {
		return welcomeMessageText;
	}


	public void setWelcomeMessageText(Text welcomeMessageText) {
		this.welcomeMessageText = welcomeMessageText;
	}


	public ModelBag getBag() {
		return bag;
	}


	public void setBag(ModelBag bag) {
		this.bag = bag;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Alert getAlert1() {
		return alert1;
	}


	public void setAlert1(Alert alert1) {
		this.alert1 = alert1;
	}


	public GridPane getPane() {
		return pane;
	}


	public void setPane(GridPane pane) {
		this.pane = pane;
	}
	
	public void clearEverything() {
		usernameField.clear();
		passwordField.clear();
		usernameErrorText.setOpacity(0);
		passwordErrorText.setOpacity(0);
	}

}
