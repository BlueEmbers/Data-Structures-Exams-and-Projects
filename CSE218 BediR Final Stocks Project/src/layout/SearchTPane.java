package layout;

import campos.model.Company;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class SearchTPane extends TabPane {
	private Company c;

	public SearchTPane(Company c) {
		this.c = c;
		Tab tab1 = new Tab("One Stock Search");
		tab1.setContent(new SearchPane(c));
		Tab tab2 = new Tab("Stock Range Picker");
		tab2.setContent(new ComparePane(new SearchPane(c), new SearchPane(c)));
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.getTabs().addAll(tab1, tab2);
	}

	public Company getC() {
		return c;
	}
}
