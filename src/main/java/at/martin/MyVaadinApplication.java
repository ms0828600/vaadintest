package at.martin;

import at.martin.entity.Person;

import com.vaadin.Application;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {
	private Window window;
	private GridLayout gridLayout;

	@Override
	public void init() {
		
		DBConnector connector = new DBConnector();
		Person p = new Person();
		p.setFirstName("Martin");
		p.setFamilyName("Schliefellner");
		
		connector.getEntityManager().getTransaction().begin();
		connector.getEntityManager().persist(p);
		connector.getEntityManager().getTransaction().commit();
		
		
		window = new Window("My Vaadin Application");
		setMainWindow(window);

		window.setSizeFull();

		// GridLayout
		gridLayout = new GridLayout(1, 2);
		gridLayout.setSizeFull();

		window.addComponent(gridLayout);

		createTabSheet();
		
		

	}

	private void createTabSheet() {
		TabSheet tabSheet = new TabSheet();
		tabSheet.setSizeFull();
		
		tabSheet.addTab(new com.vaadin.ui.Label("Test1"), "Tab 1");
		tabSheet.addTab(new com.vaadin.ui.Label("Test2"), "Tab 2");

		gridLayout.addComponent(tabSheet);
	}

}
