package control;

import java.util.LinkedList;

import Utilities.MenuFactory;
import campos.model.Company;
import javafx.scene.control.MenuBar;

public class MyMenuBar extends MenuBar {
	public MyMenuBar(LinkedList<Company> list) {
		super.getMenus().addAll(new MenuFactory(list).loadMenus());
	}
}
