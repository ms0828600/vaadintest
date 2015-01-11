package at.martin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnector {

	private static EntityManager entityManager = null;
	
	private DBConnector() { }
	
	public static EntityManager getInstance() {
		if (entityManager == null) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("customManager");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
}
