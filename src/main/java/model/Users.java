package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Userr")
public class Users {
	@Id
	private String id;
	private String Password;
	private String Email;
	private String Fullname;
	private boolean Admin = false;
	@OneToMany(mappedBy = "user")
	private List<Favorites> favorites;

	public Users() {

	}
	
	
	
	public Users(String id, String password, String email, String fullname, boolean admin) {
		this.id = id;
		Password = password;
		Email = email;
		Fullname = fullname;
		Admin = admin;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = admin;
	}

	public List<Favorites> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}

}
