package pixogram;

import static org.junit.Assert.*;

import org.junit.Test;

import pixogram.sprint1.Role;
import pixogram.sprint1.User;
import pixogram.sprint1.UserRepository;


public class TestUser {
	
	Role role=new Role("Admin");
	//Role role2=new Role("Admin");
	User user= new User("riyag", "riya@", "riya@gmail.com", "female", "punjab", "Aries", role);
	User user2= new User("riyagupta", "riya123", "riya@123gmail.com", "female", "punjab", "Scorpio", role);
	UserRepository ur=new UserRepository();

	@Test
	public void testAdd() {
		ur.addUser(user);
		ur.addUser(user2);
	}
	
	//@Test
	public void testView() {
		ur.viewUserByName(user);
	}
	
	//@Test
	public void testEdit() {
		ur.editUser(user);
	}
	
	
	//@Test
	public void testDel() {
		ur.deleteUserById();
	}
}
