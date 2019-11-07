package uoc.ded.practica;

public class User {

	private String name;
	private String surname;
	private String idUser;
	
	public User(String idUser, String name, String surname) {
		this.idUser  = idUser;
		this.name    = name;
		this.surname = surname;
	}
	
	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}
	
	public String getIdUser() {
		return this.idUser;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

}
