package dto;





public class memberDTO {
private String id;
private String password;
private String name;
private String birth;
private String gender;
private String email;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBirth() {
	return birth;
}
public void setBirth(String birth) {
	this.birth = birth;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}



public memberDTO() {
	
}

public memberDTO(String id, String password, String name, String birth, String gender, String email) {
	super();
	this.id = id;
	this.password = password;
	this.name = name;
	this.birth = birth;
	this.gender = gender;
	this.email = email;
}


	
	
	
	
	
	
	
}
