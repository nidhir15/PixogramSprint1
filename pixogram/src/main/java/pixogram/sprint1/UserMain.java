package pixogram.sprint1;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) throws ValidationException {
		UserRepository ur=new UserRepository();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Add User");
		System.out.println("2.Edit User");
		System.out.println("3.Delete User");
		System.out.println("4.View User");
		System.out.println("5.Login User");
		System.out.println("6.Exit");
		int choice=sc.nextInt();
	/*	switch(choice) {
		case 1:
			System.out.println("Enter your username");
			String username=sc.next();
			System.out.println("Enter your password");
			String password=sc.next();
			System.out.println("Gender");
			String gender=sc.next();
			System.out.println("Enter your State");
			String state=sc.next();
			System.out.println("Enter your emailid");
			String emailid=sc.next();
			System.out.println("Enter your bio");
			String bio=sc.next();
			System.out.println("Enter your role(Admin/User)");
			String role=sc.next();
			Role role1=new Role(role);
			User user=new User(username, password, emailid, gender, state, bio, role1);
			ur.addUser(user);
			break;
		
		case 2:
			System.out.println("Enter your username");
			String username1=sc.next();
			System.out.println("Enter the email to change");
			String email=sc.next();
			ur.editUser(email);
			break;
		
		case 3:
			System.out.println("Enter your username");
			String username2=sc.next();
			ur.deleteUserById(username2);
			break;
		
		case 4:
			System.out.println("Enter your username");
			String username3=sc.next();
			ur.viewUserByName(username3);
			break;
			
		case 5:
			break;
		case 6:
			break;
			
		}*/
	}

}
