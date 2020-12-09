package pixogram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String rolename;
	
	public Role() {
		
	}
	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + "]";
	}
	
	
	

}
