package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Car;
import model.RegularSpaces;
import model.Motorcycle;
import model.Pedestrian;
import model.Person;
import model.Ticket;
import model.TicketBag;
import model.Truck;
import view.BuyTicketPane;
import view.StartPane;

public class BuyTicketController {

	private double truckCost = 10.0;
	private double carCost = 7.00;
	private double bikeCost = 4.00;
	private double regularSpaceCost = 0;
	private double pedestrianCost = 3.00;
	private double costOfBill;
	private int counter = 1;

	public BuyTicketController(StartPane startPane, BuyTicketPane buyTicketPane, RegularSpaces regularSpaces, TicketBag ticketBag, Stage mainStage) {

		buyTicketPane.getOrderTicket().setOnAction(e -> {
			isFull(regularSpaces);
			checkVehicle(buyTicketPane, regularSpaces);
			alertBill(buyTicketPane, regularSpaces, ticketBag);
			regularSpaces.printStoredSpaces();

			mainStage.setScene(startPane.getScene());
			mainStage.show();
			

		});

		// takes the user to the start menu
		buyTicketPane.getExitButton().setOnAction(e -> {
			mainStage.setScene(startPane.getScene());
			mainStage.show();
		});

	}

	public void checkVehicle(BuyTicketPane buyTicketPane, RegularSpaces regularSpace) {
		if (buyTicketPane.getCombo1().getValue() == "CAR") {
			createCar(buyTicketPane, regularSpace);
		} else if (buyTicketPane.getCombo1().getValue() == "TRUCK") {
			createTruck(buyTicketPane, regularSpace);
		}
	}

	public void checkParkingSpace(BuyTicketPane buyTicketPane, RegularSpaces regularSpace) {
		if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
			checkVehicle(buyTicketPane, regularSpace);
		}
	}

	public void createCar(BuyTicketPane buyTicketPane, RegularSpaces regularSpace) {

		isFull(regularSpace);
		Car c = new Car(buyTicketPane.getLicensePlate(), buyTicketPane.getColorField(), carCost);
		if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
			regularSpace.addVehicle(c.getLicensePLate());
		}
	}

	public void createTruck(BuyTicketPane buyTicketPane, RegularSpaces regularSpace) {

		isFull(regularSpace);
		Truck t = new Truck(buyTicketPane.getLicensePlate(), buyTicketPane.getColorField(), truckCost);
		if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
			regularSpace.addVehicle(t.getLicensePLate());
		}

	}
	
	public void createMotorcycle(BuyTicketPane buyTicketPane, RegularSpaces regularSpace) {

		isFull(regularSpace);
		Motorcycle b = new Motorcycle(buyTicketPane.getLicensePlate(), buyTicketPane.getColorField(), bikeCost);
		if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
			regularSpace.addVehicle(b.getLicensePLate());
		}

	}
	
	public void createPedestrian(BuyTicketPane buyTicketPane, RegularSpaces regularSpace) {

		isFull(regularSpace);
		Pedestrian p = new Pedestrian(buyTicketPane.getLicensePlate(), buyTicketPane.getColorField(), pedestrianCost);
		if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
			regularSpace.addVehicle(p.getName());
		}

	}

	public boolean isFull(RegularSpaces regularSpace) {
		if (regularSpace.isFullRegular() == true) {
			alertWarning();

		} 
		return false;
	}

	public void alertWarning() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("OOPS");
		alert.setContentText("There are not enough regular spaces on the boat, please try again later");
		alert.showAndWait();
	}
	
	@FunctionalInterface
	interface Chargeable 
	{ 
	    int charge(int x); 
	} 

	public boolean alertBill(BuyTicketPane buyTicketPane, RegularSpaces regularSpace,
			TicketBag ticketBag) 
	{
		

		costOfBill = 0;
//		private double truckCost = 10.0;
//		private double carCost = 7.0;
//		private double bikeCost = 4.0;
		

			if (buyTicketPane.getCombo1().getValue() == "CAR") 
			{
			//	costOfBill = costOfBill + (carCost);
				 int a = 7; 
				  
			        // lambda expression to define the calculate method 
			        Chargeable s = (int x)->x; 
			  
			        // parameter passed and return type must be 
			        // same as defined in the prototype 
			        costOfBill = s.charge(a); 
			}  
			else if (buyTicketPane.getCombo1().getValue() == "TRUCK")
			{
		//		costOfBill = costOfBill + (truckCost);
				int b = 10; 
				  
		        // lambda expression to define the calculate method 
		        Chargeable s = (int x)->x; 
		  
		        // parameter passed and return type must be 
		        // same as defined in the prototype 
		        costOfBill = s.charge(b); 
			}
			else if (buyTicketPane.getCombo1().getValue() == "Motorcycle")
			{
			//	costOfBill = costOfBill + (bikeCost);
				 int c = 6; 
				  
			        // lambda expression to define the calculate method 
			        Chargeable s = (int x)->x; 
			  
			        // parameter passed and return type must be 
			        // same as defined in the prototype 
			        costOfBill = s.charge(c); 
			}
			else if (buyTicketPane.getCombo1().getValue() == "Motorcycle")
			{
			//	costOfBill = costOfBill + (bikeCost);
				 int c = 6; 
				  
			        // lambda expression to define the calculate method 
			        Chargeable s = (int x)->x; 
			  
			        // parameter passed and return type must be 
			        // same as defined in the prototype 
			        costOfBill = s.charge(c); 
			}
			else if (buyTicketPane.getCombo1().getValue() == "Pedestrian")
			{
			//	costOfBill = costOfBill + (bikeCost);
				 int d = 3; 
				  
			        // lambda expression to define the calculate method 
			        Chargeable s = (int x)->x; 
			  
			        // parameter passed and return type must be 
			        // same as defined in the prototype 
			        costOfBill = s.charge(d); 
			}
			if (buyTicketPane.getCombo2().getValue() == "Ferry ride")
			{
				costOfBill = costOfBill;
			} 
			if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
				costOfBill = costOfBill + regularSpaceCost;
			}

			if (isFull(regularSpace) == false) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("Congratulations, Your ticket number is: " + counter + "\n "
						 + buyTicketPane.getCombo1().getValue() + " " +  buyTicketPane.getColorField() +"\n"
						+ "License plate number: " + buyTicketPane.getLicensePlate()
						+ "\nis now on " + buyTicketPane.getCombo2().getValue());
				alert.setContentText("The cost of your ticket is $" + costOfBill);
				alert.showAndWait();
				createTicket(buyTicketPane, buyTicketPane.getLicenseField().getText(), ticketBag, counter, carCost);
				counter++;
//				ticketBag.printStoredSpaces();
				
			}
			return false;
		}
			 
	
	public void createTicket(BuyTicketPane buyTicketPane, String ticketFieldSelect, TicketBag ticketBag, int counter,
			double cost) {
		ticketFieldSelect = buyTicketPane.getLicenseField().getText();
		Ticket t = new Ticket(ticketFieldSelect, counter, cost);
		ticketBag.addTicket(t);
	}

}
