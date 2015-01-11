package at.martin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnector {

	private EntityManager entityManager;
	
	public DBConnector() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("customManager");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
}
