package controller;

import javafx.stage.Stage;
import model.TicketBag;
import view.BuyTicketPane;
import view.StartPane;

public class StartController {

	public StartController(StartPane startPane,BuyTicketPane buyTicketPane,TicketBag tickets, Stage stage) {
		startPane.getBuyTicket().setOnAction(e ->
		{
			stage.setScene(buyTicketPane.getScene());
			stage.show();
		});
	}
}
