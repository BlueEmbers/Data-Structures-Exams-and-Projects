package view;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.ModelBag;
import model.User;

public class MySignUpPane {
	private Text welcomeText;
	private Label firstName;
	private Label lastName;
	private Label username;
	private Label password;
	private Label renterpassword;
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField usernameField;
	private PasswordField passwordField;
	private PasswordField rePasswordField;
	private Button createUser;
	private Button cancel;
	private Button clearFields;
	private TextField satMath;
	private TextField satReading;
	private Text firstNameError;
	private Text lastNameError;
	private Text usernameError;
	private Text passwordError;
	private Text satMathError;
	private Text satReadingError;
	private Text repasswordError;
	private Alert alert;
	private User user;

	private VBox box;
	private GridPane pane;

	public MySignUpPane(ModelBag bag) {
		this.alert = new Alert(AlertType.INFORMATION, "New User Created");
		alert.setHeaderText("Welcome!");
		
		this.pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(5);
		pane.setPadding(new Insets(50));
		pane.setStyle("-fx-background-color: #ffffff");

		this.welcomeText = new Text("Create New User");
		welcomeText.setFont(Font.font("System", 20));
		welcomeText.setFill(Paint.valueOf("#0054a4"));

		this.firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		firstNameField.setOnKeyTyped(e ->{
			firstNameError.setOpacity(0);
		});
		this.lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		lastNameField.setOnKeyTyped(e ->{
			lastNameError.setOpacity(0);
		});
		this.usernameField = new TextField();
		usernameField.setPromptText("Username");
		usernameField.setOnKeyTyped(e ->{
			usernameError.setOpacity(0);
		});
		this.passwordField = new PasswordField();
		passwordField.setPromptText("Password");
		passwordField.setOnKeyTyped(e ->{
			passwordError.setOpacity(0);
		});
		this.rePasswordField = new PasswordField();
		rePasswordField.setPromptText("Re-enter Password");
		rePasswordField.setOnKeyTyped(e ->{
			repasswordError.setOpacity(0);
		});
		this.satMath = new TextField();
		satMath.setPromptText("SAT Math Score");
		satMath.setOnKeyTyped(e ->{
			satMathError.setOpacity(0);
		});
		this.satReading = new TextField();
		satReading.setPromptText("SAT Reading Score");
		satReading.setOnKeyTyped(e ->{
			satReadingError.setOpacity(0);
		});

		this.firstNameError = new Text("Please enter a first name.");
		firstNameError.setFont(Font.font("System", 12));
		firstNameError.setFill(Color.RED);
		firstNameError.setOpacity(0);

		this.lastNameError = new Text("Please enter a last name.");
		lastNameError.setFont(Font.font("System", 12));
		lastNameError.setFill(Color.RED);
		lastNameError.setOpacity(0);

		this.usernameError = new Text("Username already exists.");
		usernameError.setFont(Font.font("System", 12));
		usernameError.setFill(Color.RED);
		usernameError.setOpacity(0);

		this.satMathError = new Text("Score must be between 200-800");
		satMathError.setFont(Font.font("System", 12));
		satMathError.setFill(Color.RED);
		satMathError.setOpacity(0);

		this.satReadingError = new Text("Score must be between 200-800");
		satReadingError.setFont(Font.font("System", 12));
		satReadingError.setFill(Color.RED);
		satReadingError.setOpacity(0);

		this.passwordError = new Text("Password must be at least 6 characters long.");
		passwordError.setFont(Font.font("System", 12));
		passwordError.setFill(Color.RED);
		passwordError.setOpacity(0);

		this.repasswordError = new Text("Passwords must match.");
		repasswordError.setFont(Font.font("System", 12));
		repasswordError.setFill(Color.RED);
		repasswordError.setOpacity(0);

		this.createUser = new Button("Create New User");
		this.cancel = new Button("Cancel");
		this.clearFields = new Button("Clear Fields");

		createUser.setStyle("-fx-background-color: #0054a4");
		createUser.setTextFill(Paint.valueOf("#ffffff"));
		createUser.setPrefWidth(200);

		cancel.setStyle("-fx-background-color: #0054a4");
		cancel.setTextFill(Paint.valueOf("#ffffff"));
		cancel.setPrefWidth(200);

		clearFields.setStyle("-fx-background-color: #0054a4");
		clearFields.setTextFill(Paint.valueOf("#ffffff"));
		clearFields.setPrefWidth(200);

		pane.add(welcomeText, 0, 0, 5, 1);
		pane.add(firstNameField, 0, 1);
		pane.add(firstNameError, 0, 2);
		pane.add(lastNameField, 3, 1);
		pane.add(lastNameError, 3, 2);
		pane.add(satMath, 0, 3);
		pane.add(satMathError, 0, 4);
		pane.add(satReading, 3, 3);
		pane.add(satReadingError, 3, 4);
		pane.add(usernameField, 0, 5);
		pane.add(usernameError, 0, 6);
		pane.add(passwordField, 0, 7);
		pane.add(passwordError, 0, 8);
		pane.add(rePasswordField, 3, 7);
		pane.add(repasswordError, 3, 8);
		pane.add(createUser, 0, 9);
		pane.add(clearFields, 3, 9);
		pane.add(cancel, 0, 10);

		this.box = new VBox(400);
		box.setStyle("-fx-background-color: #0054a4");
		box.getChildren().add(pane);

		createUser.setOnAction(e -> {
			if(firstNameField.getText().length() == 0) {
				firstNameError.setOpacity(1);
				return;
			}
			if(lastNameField.getText().length() == 0) {
				lastNameError.setOpacity(1);
				return;
			}
			if(!checkForNonNumbers(satMath.getText())){
				satMathError.setOpacity(1);
				return;
			}
			
			if(!checkForNonNumbers(satReading.getText())){
				satReadingError.setOpacity(1);
				return;
			}
			if((Integer.parseInt(satMath.getText())) > 800 || (Integer.parseInt(satMath.getText()) < 200)) {
				satMathError.setOpacity(1);
				return;
			}
			
			if(Integer.parseInt(satReading.getText()) > 800 || Integer.parseInt(satReading.getText()) < 200) {
				satReadingError.setOpacity(1);
				return;
			}
			
			if(usernameField.getText().length() == 0) {
				usernameError.setOpacity(1);
				return;
			}
			
			if(bag.getUserBag().getMap().containsKey(usernameField.getText())) {
				usernameError.setOpacity(1);
				return;
			}
			if(passwordField.getText().length() < 6 || passwordField.getText().length() > 12) {
				passwordError.setOpacity(1);
				return;
			}
			if(!passwordField.getText().equals(rePasswordField.getText())) {
				repasswordError.setOpacity(1);
				return;
			}

			this.user = new User(firstNameField.getText(), lastNameField.getText(), usernameField.getText(),
					passwordField.getText(), Integer.parseInt(satReading.getText()),
					Integer.parseInt(satMath.getText()));
			bag.getUserBag()
					.addUser(user);
			alert.show();
			
			
		});
		
		clearFields.setOnAction(e -> {
			clearEverything();
		});

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public Text getWelcomeText() {
		return welcomeText;
	}

	public void setWelcomeText(Text welcomeText) {
		this.welcomeText = welcomeText;
	}

	public Label getFirstName() {
		return firstName;
	}

	public void setFirstName(Label firstName) {
		this.firstName = firstName;
	}

	public Label getLastName() {
		return lastName;
	}

	public void setLastName(Label lastName) {
		this.lastName = lastName;
	}

	public Label getUsername() {
		return username;
	}

	public void setUsername(Label username) {
		this.username = username;
	}

	public Label getPassword() {
		return password;
	}

	public void setPassword(Label password) {
		this.password = password;
	}

	public Label getRenterpassword() {
		return renterpassword;
	}

	public void setRenterpassword(Label renterpassword) {
		this.renterpassword = renterpassword;
	}

	public TextField getFirstNameField() {
		return firstNameField;
	}

	public void setFirstNameField(TextField firstNameField) {
		this.firstNameField = firstNameField;
	}

	public TextField getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(TextField lastNameField) {
		this.lastNameField = lastNameField;
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

	public PasswordField getRePasswordField() {
		return rePasswordField;
	}

	public void setRePasswordField(PasswordField rePasswordField) {
		this.rePasswordField = rePasswordField;
	}

	public Button getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Button createUser) {
		this.createUser = createUser;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public Button getClearFields() {
		return clearFields;
	}

	public void setClearFields(Button clearFields) {
		this.clearFields = clearFields;
	}

	public TextField getSatMath() {
		return satMath;
	}

	public void setSatMath(TextField satMath) {
		this.satMath = satMath;
	}

	public TextField getSatReading() {
		return satReading;
	}

	public void setSatReading(TextField satReading) {
		this.satReading = satReading;
	}

	public Text getFirstNameError() {
		return firstNameError;
	}

	public void setFirstNameError(Text firstNameError) {
		this.firstNameError = firstNameError;
	}

	public Text getLastNameError() {
		return lastNameError;
	}

	public void setLastNameError(Text lastNameError) {
		this.lastNameError = lastNameError;
	}

	public Text getUsernameError() {
		return usernameError;
	}

	public void setUsernameError(Text usernameError) {
		this.usernameError = usernameError;
	}

	public Text getPasswordError() {
		return passwordError;
	}

	public void setPasswordError(Text passwordError) {
		this.passwordError = passwordError;
	}

	public Text getSatMathError() {
		return satMathError;
	}

	public void setSatMathError(Text satMathError) {
		this.satMathError = satMathError;
	}

	public Text getSatReadingError() {
		return satReadingError;
	}

	public void setSatReadingError(Text satReadingError) {
		this.satReadingError = satReadingError;
	}

	public Text getRepasswordError() {
		return repasswordError;
	}

	public void setRepasswordError(Text repasswordError) {
		this.repasswordError = repasswordError;
	}

	public VBox getBox() {
		return box;
	}

	public void setBox(VBox box) {
		this.box = box;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}
	
	public boolean checkForNonNumbers(String string) {
		if(string == null || string.length() == 0) {
			return false;
		}
		
		for (int i = 0; i < string.length(); i++) {
			if(!Character.isDigit(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public void clearEverything() {
		firstNameField.clear();
		lastNameField.clear();
		usernameField.clear();
		passwordField.clear();
		rePasswordField.clear();
		satMath.clear();
		satReading.clear();
		firstNameError.setOpacity(0);
		lastNameError.setOpacity(0);
		usernameError.setOpacity(0);
		passwordError.setOpacity(0);
		repasswordError.setOpacity(0);
		satMathError.setOpacity(0);
		satReadingError.setOpacity(0);
	}
}
