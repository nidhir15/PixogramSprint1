package pixogram;

import java.util.List;

import javax.persistence.*;


import pixogram.Content;
public class ContentRepositary {
	private EntityManager em;

	{/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("test");
	
//		Create EntityManager
		em = emf.createEntityManager();
	}
	public void addContent(Content content) throws Exception{
		//em.persist
		em.getTransaction().begin();
		em.persist(content);
		em.getTransaction().commit();
			
	}
	public void viewContentByEmail(Content content) {
		 TypedQuery<Content> query = em.createQuery("SELECT c FROM Content c where c.email=:user_email", Content.class);
		 query.setParameter("user_email", content.email);
			List<Content> contents = query.getResultList();	
		   System.out.println(contents);	
		   
			
	 }
	 /*public void deleteUserById() {
		 em.getTransaction().begin();
		 User foundUser=em.find(User.class, 3);
		em.remove(foundUser);
		em.getTransaction().commit();
		//return user;
	 }
	 
	public void editContentCaption(Content content) {
		 em.getTransaction().begin();
		 
		 Query query = em.createQuery("UPDATE Content c SET c.caption =:new_caption "
	              + "WHERE c.content_id = :id", Content.class);
	      query.setParameter("new_caption", content.caption);
	      query.setParameter("id", content.content_id);
	      int rowsUpdated = query.executeUpdate();
	      System.out.println("entities Updated: " + rowsUpdated);
	      em.getTransaction().commit();
	      
	 }*/
	public void testFindCommentsById() {
		TypedQuery<Comments> query = em.createQuery("SELECT u FROM Comments u where u.commentId=:idparam", Comments.class);
		query.setParameter("idparam", 2);
		List<Comments> comments = query.getResultList();
		System.out.println(comments);
	}
}
