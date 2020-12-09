package com.capg.sprint.Pixogram;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="comments")
public class Comments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String commentId;
	private String message;
	//ArrayList<String> commentList=new ArrayList<>();
	
	public Comments() {
		
	}

	public Comments(String comment) {
		super();
		this.message = comment;
	}
//
//	public String getCommentId() {
//		return commentId;
//	}
//
//	public void setCommentId(String commentId) {
//		this.commentId = commentId;
//	}
	public String getComment() {
		return message;
	}

	public void setComment(String comment) {
		this.message = comment;
	}
	

	@Override
	public String toString() {
		return "Comments [message=" + message + ", commentList=" + commentList + "]";
	}
	

}
