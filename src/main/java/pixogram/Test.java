package pixogram;

import java.io.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Test {

	public static void main(String[] args) throws Exception{

		//private EntityManager entityManager;
		
			/* Create EntityManagerFactory */
			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory("test");
		
//			Create EntityManager
			EntityManager entityManager = entityManagerFactory.createEntityManager();

		
		
		File file=new File("E:\\images\\lily.jpg");
		Content content = new Content("nidhi@gmail.com",file,"lily","E:\\images\\cat.jpg",0,0);
			
			//em.persist
		entityManager.getTransaction().begin();
		entityManager.persist(content);
		entityManager.getTransaction().commit();
		
		

	}
}