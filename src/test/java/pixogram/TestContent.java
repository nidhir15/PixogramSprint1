package pixogram;

import java.io.File;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import java.io.IOException;
import java.net.*;


import pixogram.Content;
import pixogram.ContentRepositary;

public class TestContent {
	Content content=new Content();
	ContentRepositary repo = new ContentRepositary();
	Scanner scan=new Scanner(System.in);
	@Test
	public void selectOption() throws Exception{
		System.out.println("Select option  1.Add Content   2.View Content  3.Edit Caption");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			System.out.println("Enter email");
			scan.nextLine();
			String email=scan.nextLine();
			
			System.out.println("Enter filepath");
			String filepath=scan.nextLine();
			//scan.nextLine();
			System.out.println("Enter caption");
			String caption=scan.nextLine();
			boolean isImage=isImageFile(filepath);
			boolean isVideo=isVideoFile(filepath);
			if(isImage||isVideo) {
				File file=new File(filepath);
				int like=0;
				int dislike=0;
				content=new Content(email,file,caption,filepath,like,dislike);
				addContentFromUser();
			}
			else {
				System.out.println("Not image or video....Try Again!!!");
			}
			break;
		case 2:
			System.out.println("Enter user's email for content view");
			scan.nextLine();
			email=scan.nextLine();
			content=new Content(email);
			viewContentToUser();
			System.out.println("Enter content_id for full description");
			break;
		
			
			
		}
	}
	//ContentReopsitary contentRepositary=new ContentReopsitary();
	public void addContentFromUser() throws Exception{
		repo.addContent(content);
		
	}
	public void viewContentToUser() {
		repo.viewContentByEmail(content);
	}
	
	public static boolean isImageFile(String filepath) {
	    String Type = URLConnection.guessContentTypeFromName(filepath);
	    return Type != null && Type.startsWith("image");
	}
	public static boolean isVideoFile(String filepath) {
	    String mimeType = URLConnection.guessContentTypeFromName(filepath);
	    return mimeType != null && mimeType.startsWith("video");
	}
}
