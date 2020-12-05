package pixogram.sprint1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pixogram.sprint1.User;

public class UserRepository {
	
	private EntityManager em;

	 {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test");
	
//		Create EntityManager
		em = emf.createEntityManager();
	}
	 
	 public void addUser(User user) {
		 em.getTransaction().begin();
		 em.persist(user);
		 em.getTransaction().commit(); 
	 }
	 
	 public List<User> viewUserByName(User user) {
		 TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
			//query.setParameter("nameparam", "riya");
			List<User> users = query.getResultList();
			//System.out.println(user1);	
		   return users;	 
	 }
	 
	 public void deleteUserById() {
		 em.getTransaction().begin();
		 User foundUser=em.find(User.class, 3);
		em.remove(foundUser);
		em.getTransaction().commit();
		//return user;
	 }
	 
	 public User editUser(User user) {
		 em.getTransaction().begin();
		 user.setEmail("riya@23gmail.com");
			//User foundUser = em.find(User.class, 6);
		em.merge(user);
		em.getTransaction().commit();
			return user;
	 }


}
