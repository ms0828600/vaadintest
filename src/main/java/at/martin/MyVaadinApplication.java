package at.martin;

import java.util.List;

import javax.persistence.EntityManager;

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
		
		// fill db with persons
		EntityManager em = DBConnector.getInstance();
		List<Person> list = FillDB.generatePersons();
		System.out.println("SIZE = " + list.size());
		em.getTransaction().begin();
		for (Person p : list) {
			em.persist(p);
		}
		em.getTransaction().commit();
		
		
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
