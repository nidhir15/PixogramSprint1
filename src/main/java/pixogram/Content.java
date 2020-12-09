package pixogram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.*;

@Entity
public class Content {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int content_id;
	String email;
	File content;
	String caption;
	String filepath;
	int like;
	int dislike;
	
	public Content() {
		super();
	}
	
	public Content(String email, File content, String caption, String filepath, int like, int dislike) {
		super();
		this.email = email;
		this.content = content;
		this.caption = caption;
		this.filepath = filepath;
		this.like = like;
		this.dislike = dislike;
	}



	public Content(String email) {
		super();
		this.email = email;
	}
	
	public Content(int content_id, String caption) {
		super();
		this.content_id = content_id;
		this.caption = caption;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public File getContent() {
		return content;
	}

	public void setContent(File content) {
		this.content = content;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	@Override
	public String toString() {
		return "Content [content_id=" + content_id + ", email=" + email + ", content=" + content + ", caption="
				+ caption + ", filepath=" + filepath + ", like=" + like + ", dislike=" + dislike + "]";
	}

	

	
	
	
	
	
}
