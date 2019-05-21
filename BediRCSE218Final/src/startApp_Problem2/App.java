package startApp_Problem2;

import controller.BuyTicketController;
import controller.StartController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.RegularSpaces;
import model.TicketBag;
import model.Vehicle;
import view.BuyTicketPane;
import view.StartPane;

public class App extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	// READ THIS!!!!!!!!. INTERFACE ABSTRACT CHARGEABLE FUNCTION IS LOCATED IN PACKAGE CONTROLLER CLASS BUYTICKETCONTROLLER. IT IS IMPLEMENTED!!!

	public void start(Stage mainStage) throws Exception {
		
		
		//create the bags to store info
		RegularSpaces regularParking = new RegularSpaces(0);
		TicketBag ticketBag = new TicketBag(null);
		
		//create the panes
		BuyTicketPane buyTicket = new BuyTicketPane();
		StartPane start = new StartPane();
		
		//create the controllers
		BuyTicketController buyTicketController = new BuyTicketController(start, buyTicket, regularParking, ticketBag,mainStage);
		StartController startController = new StartController(start, buyTicket,ticketBag, mainStage);
		
		//start the program
		Scene scene = start.getScene();
		mainStage.setScene(scene);
		mainStage.show();

	}
}
