package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.College;
import model.ModelBag;
import model.User;
import org.controlsfx.control.textfield.TextFields;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import impl.org.controlsfx.autocompletion.SuggestionProvider;

public class MyMainPane {

	private VBox vBox;
	private GridPane pane;
	ObservableList<College> list;
	private TableView<College> table;
	private MenuBar menubar;
	private Menu file;
	private Menu signout;
	private Menu exit;
	private MenuItem updateData;
	private MenuItem signoutItem;
	private MenuItem exitItem;
	private TextField searchField;
	private TextArea results;
	private Text userName;
	private Button searchButton;
	private ModelBag modelBag;
	private User user;
	private Set<String> chosenNameSet;
	private Set<String> searchedNameSet;
	private Map<String, JsonNode> map;

	public MyMainPane(User user, ModelBag modelBag) {
		this.user = user;
		String username = user.getUsername();
		this.modelBag = modelBag;
		this.vBox = new VBox();
//********************************************************************MENUS

		this.menubar = new MenuBar();
		this.file = new Menu("File");
		this.updateData = new MenuItem("Update College Data");
		file.getItems().add(updateData);

		this.signout = new Menu("Sign Out");
		this.signoutItem = new MenuItem("Sign Out");
		signout.getItems().add(signoutItem);

		this.exit = new Menu("Exit");
		this.exitItem = new MenuItem("Exit Program");
		exit.getItems().add(exitItem);

		menubar.getMenus().addAll(file, signout, exit);

//*******************************************************************TABLEVIEW

		TableColumn<College, String> nameColumn = new TableColumn<>("Name");
		// nameColumn.setMinWidth(400);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<College, String> idColumn = new TableColumn<>("ID");
		// idColumn.setMinWidth(100);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn<College, String> cityColumn = new TableColumn<>("City");
		// cityColumn.setMinWidth(200);
		cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
		TableColumn<College, String> stateColumn = new TableColumn<>("State");
		// stateColumn.setMinWidth(50);
		stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
		TableColumn<College, String> zipColumn = new TableColumn<>("Zip");
		// zipColumn.setMinWidth(100);
		zipColumn.setCellValueFactory(new PropertyValueFactory<>("zip"));
		TableColumn<College, String> outCostColumn = new TableColumn<>("Out-of-State Cost");
		// outCostColumn.setMinWidth(200);
		outCostColumn.setCellValueFactory(new PropertyValueFactory<>("outCost"));
		TableColumn<College, String> inCostColumn = new TableColumn<>("In-State Cost");
		// inCostColumn.setMinWidth(200);
		inCostColumn.setCellValueFactory(new PropertyValueFactory<>("inCost"));
		TableColumn<College, String> mathLowColumn = new TableColumn<>("Math SAT 25th Percentile");
		// mathLowColumn.setMinWidth(100);
		mathLowColumn.setCellValueFactory(new PropertyValueFactory<>("mathLow"));
		TableColumn<College, String> mathHiColumn = new TableColumn<>("Math SAT 75th Percentile");
		// mathHiColumn.setMinWidth(100);
		mathHiColumn.setCellValueFactory(new PropertyValueFactory<>("mathHi"));
		TableColumn<College, String> readingLowColumn = new TableColumn<>("Reading SAT 25th Percentile");
		// readingLowColumn.setMinWidth(100);
		readingLowColumn.setCellValueFactory(new PropertyValueFactory<>("readLow"));
		TableColumn<College, String> readingHiColumn = new TableColumn<>("Reading SAT 75th Percentile");
		// readingHiColumn.setMinWidth(100);
		readingHiColumn.setCellValueFactory(new PropertyValueFactory<>("readHi"));
		TableColumn<College, String> chanceColumn = new TableColumn<>("Chance of Acceptance");
		chanceColumn.setCellValueFactory(new PropertyValueFactory<>("chance"));

		this.table = new TableView<>();
		table.getColumns().addAll(idColumn, nameColumn, cityColumn, stateColumn, zipColumn, inCostColumn, outCostColumn,
				mathLowColumn, mathHiColumn, readingLowColumn, readingHiColumn, chanceColumn);
		table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
		

//*****************************************************		

		this.searchField = new TextField();

		searchField.setPromptText("Enter school name");
		TextFields.bindAutoCompletion(searchField, modelBag.getCollegeBag().getSchoolNameSet());

		this.searchButton = new Button("Search");

		searchButton.setOnAction(e -> {
			findChosenOnes(searchField.getText());
			this.list = FXCollections.observableArrayList(getListed());
			this.table.setItems(list);
		});
		
		updateData.setOnAction(e -> {
			try {
				modelBag.getCollegeBag().fillHashMap();
			} catch (JsonGenerationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Success");
		});

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(table);
		scrollPane.setMaxWidth(800);

		this.userName = new Text("User: " + username);
		userName.setFont(Font.font("System", 20));
		userName.setFill(Paint.valueOf("ffffff"));

		this.pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(40));
		pane.setStyle("-fx-background-color: #0054a4");
		pane.add(searchField, 0, 0, 3, 1);
		pane.add(searchButton, 3, 0);
		pane.add(userName, 5, 0);
		pane.add(scrollPane, 0, 3, 6, 4);

		vBox.getChildren().addAll(menubar, pane);
	}
	
	

	private void findChosenOnes(String text) {
		chosenNameSet = modelBag.getCollegeBag().getSchoolNameSet().stream().filter(school -> school.startsWith(text))
				.collect(Collectors.toSet());

	}

	public ArrayList<College> getListed() {
		ArrayList<College> array = new ArrayList<>();
		findChosenOnes(searchField.getText());
		chosenNameSet.stream().forEach(one -> {
			College college = modelBag.getCollegeBag().getCollegeMap().get(one);
			if(!college.getMathHi().equals("null")) {
				college.setChance(generateChance(college));
			}else {
				college.setChance("");
			}
			array.add(college);
		});
		return array;
	}

	public VBox getvBox() {
		return vBox;
	}

	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public TableView<College> getTable() {
		return table;
	}

	public void setTable(TableView<College> table) {
		this.table = table;
	}

	public MenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(MenuBar menubar) {
		this.menubar = menubar;
	}

	public Menu getFile() {
		return file;
	}

	public void setFile(Menu file) {
		this.file = file;
	}

	public Menu getSignout() {
		return signout;
	}

	public void setSignout(Menu signout) {
		this.signout = signout;
	}

	public Menu getExit() {
		return exit;
	}

	public void setExit(Menu exit) {
		this.exit = exit;
	}

	public MenuItem getUpdateData() {
		return updateData;
	}

	public void setUpdateData(MenuItem updateData) {
		this.updateData = updateData;
	}

	public MenuItem getSignoutItem() {
		return signoutItem;
	}

	public void setSignoutItem(MenuItem signoutItem) {
		this.signoutItem = signoutItem;
	}

	public MenuItem getExitItem() {
		return exitItem;
	}

	public void setExitItem(MenuItem exitItem) {
		this.exitItem = exitItem;
	}

	public TextField getSearchField() {
		return searchField;
	}

	public void setSearchField(TextField searchField) {
		this.searchField = searchField;
	}

	public TextArea getResults() {
		return results;
	}

	public void setResults(TextArea results) {
		this.results = results;
	}

	public ModelBag getModelBag() {
		return modelBag;
	}

	public void setModelBag(ModelBag modelBag) {
		this.modelBag = modelBag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<String> getChosenNameSet() {
		return chosenNameSet;
	}

	public void setChosenNameSet(Set<String> chosenNameSet) {
		this.chosenNameSet = chosenNameSet;
	}

	public String generateChance(College college) {

		int userMath = user.getSatMath();
		System.out.println(userMath);
		int userReading = user.getSatReading();
		System.out.println(userReading);
		int tally = 0;
		String result = "";
		System.out.println(college.getMathLow());
		System.out.println(college.getMathHi());
		System.out.println(college.getReadHi());
		System.out.println(college.getReadLow());
		if (college.getMathHi() == null || college.getMathLow() == null || college.getReadHi() == null
				|| college.getReadHi() == null) {
			return result;
		}
		if(Double.parseDouble(college.getMathLow()) < userMath){
			tally++;
		}
		if(Double.parseDouble(college.getMathHi()) < userMath){
			tally++;
		}
		if(Double.parseDouble(college.getReadLow()) < userReading){
			tally++;
		}
		if(Double.parseDouble(college.getReadHi()) < userReading){
			tally++;
		}
		switch(tally) {
		case 0: result = "Poor";
		break;
		case 1: result = "Fair";
		break;
		case 2: result = "Good";
		break;
		case 3: result = "Very Good";
		break;
		case 4: result = "Excellent";
		break;
		}
		return result;

	}
}
