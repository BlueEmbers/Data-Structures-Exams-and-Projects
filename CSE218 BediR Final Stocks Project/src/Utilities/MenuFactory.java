package Utilities;

import java.util.LinkedList;

import campos.model.Company;
import campos.model.MenuEnum;
import eventHandler.CompanyChooserHandler;
import eventHandler.ExitHandler;
import eventHandler.OperationHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class MenuFactory 
{
	private LinkedList<Company> companyBag;
	
	public MenuFactory(LinkedList<Company> companyBag) 
	{
		this.companyBag = companyBag;
	}
	
	public ObservableList<Menu> loadMenus()
	{
		ObservableList<Menu> list = FXCollections.observableArrayList();
		list.add(loadMenu(MenuEnum.Stocks));
		list.add(loadMenu(MenuEnum.Edit));
		return list;
	}
	
	public Menu loadMenu(MenuEnum menuEnum) {
		Menu menu = new Menu(menuEnum.toString());
		switch (menu.getText().toUpperCase()) {
		case "STOCKS":
			impViewItems(menu);
			break;
		case "EDIT":
			impOpItems(menu);
			break;
		}
		return menu;
	}

	private void impFileItems(Menu menu) {
		MenuItem miExit = new MenuItem("Exit");
		miExit.setOnAction(new ExitHandler<ActionEvent>(companyBag));
		menu.getItems().addAll(miExit);
	}
	
	private void impViewItems(Menu menu) {
		ToggleGroup t1 = new ToggleGroup();
		
		RadioMenuItem miAmzn = new RadioMenuItem("Amazon");
		miAmzn.setOnAction(new CompanyChooserHandler(miAmzn, companyBag));
		miAmzn.setToggleGroup(t1);
		
		RadioMenuItem miAppl = new RadioMenuItem("Apple");
		miAppl.setOnAction(new CompanyChooserHandler(miAppl, companyBag));;
		menu.getItems().addAll(miAmzn, miAppl);
		miAppl.setToggleGroup(t1);
	}

	private void impOpItems(Menu menu) {
		MenuItem miInsert = new MenuItem("Insert");
		miInsert.setOnAction(new OperationHandler(miInsert.getText()));

		MenuItem miSearch = new MenuItem("Search");
		miSearch.setOnAction(new OperationHandler(miSearch.getText()));
		menu.getItems().addAll(miInsert, miSearch);
	}
}
