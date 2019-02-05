package p3;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Gui 
{
	public Pane mainPane = new GridPane();
	private VBox mainBox = new VBox(20);
	
	StackS stack = new StackS();
	QueueS queue = new QueueS();
	
	private HBox txtfldBox = new HBox(20);
	private TextField txtfldName = new TextField();
	private TextField txtfldGpa = new TextField();
	
	private HBox btnBox1 = new HBox(30);
	private HBox btnBox2 = new HBox(25);
	private Button btnSPush = new Button();
	private Button btnSPop = new Button();
	private Button btnQInsert = new Button();
	private Button btnQRemove = new Button();
	
	private HBox lblBox = new HBox(20);
	private Label removeLabel = new Label();
	
	public Gui()
	{
		buildControls();
		buildPane();
	}
	
	private void buildControls() 
	{
		txtfldName.setPromptText("Name");
		txtfldGpa.setPromptText("GPA");
		btnSPush.setText("STACK PUSH");
		btnSPop.setText("STACK POP");
		btnQInsert.setText("QUEUE INSERT");
		btnQRemove.setText("QUEUE REMOVE");
		
		btnSPush.setOnAction(e -> 
		{
			stack.insertFirst(new Student(txtfldName.getText(), Double.parseDouble(txtfldGpa.getText())));
			txtfldName.clear();
			txtfldGpa.clear();
		});
		
		btnSPop.setOnAction(e -> 
		{ 
			removeLabel.setText(stack.pop().getName() + " has been removed.");
			txtfldName.clear();
			txtfldGpa.clear();
		});
		
		btnQInsert.setOnAction(e -> 
		{
			queue.insertLast(new Student(txtfldName.getText(), Double.parseDouble(txtfldGpa.getText())));
			txtfldName.clear();
			txtfldGpa.clear();
		});
		
		btnQRemove.setOnAction(e -> 
		{
			removeLabel.setText(queue.removeFirst().getName() + " has been removed.");
		});
	}
	
	private void buildPane() 
	{
		txtfldBox.getChildren().addAll(txtfldName, txtfldGpa);
		btnBox1.getChildren().addAll(btnSPush, btnSPop);
		btnBox2.getChildren().addAll(btnQInsert, btnQRemove);
		
		txtfldBox.setAlignment(Pos.CENTER_RIGHT);
		btnBox1.setAlignment(Pos.CENTER);
		btnBox2.setAlignment(Pos.CENTER);
		
		lblBox.getChildren().add(removeLabel);
		
		mainBox.getChildren().addAll(txtfldBox, btnBox1, btnBox2, lblBox);
		mainBox.setAlignment(Pos.CENTER);
		
		mainPane.getChildren().add(mainBox);
	}
	
}