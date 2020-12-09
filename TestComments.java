package com.capg.sprint.Pixogram;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestComments {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY=Persistence
			.createEntityManagerFactory("capdb");

	public static void main(String[] args) {
		
		addComment("This is a test comment");
		addComment("This is a test comment2");
		addComment("This is a test comment3");
		getComment(1);
		getAllComments();

		ENTITY_MANAGER_FACTORY.close();

	}

	public static void addComment(String message) {
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		try {
			et=em.getTransaction();
			et.begin();
			Comments comment=new Comments();
			comment.setComment(message);
			em.persist(comment);
			et.commit();
		}
		catch(Exception e) {
			if(et!=null)
				et.rollback();
			e.printStackTrace();
			
		}
		finally {
			em.close();
		}
	}
	
	public static void getComment(int id) {
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query="SELECT c FROM comments c WHERE c.commentid = : id";
		
		TypedQuery<Comments> tq= em.createQuery(query, Comments.class);
		tq.setParameter("commentid", id);
		Comments comment=null;
		try {
			comment=tq.getSingleResult();
			System.out.println(comment.getCommentId()+" "+
					comment.getComment());
		}catch(NoResultException e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		
	}
	

	public static void getAllComments() {
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery="SELECT c from comments WHERE c.commentid IS NOT NULL";

		TypedQuery<Comments> tq= em.createQuery(strQuery, Comments.class);
		List<Comments> comms;
		try {
			comms=tq.getResultList();
			comms.forEach(comm->System.out.println(comm.getCommentId()+" "+comm.getComment()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
}
