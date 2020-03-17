package com.icia.project.dto;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
private String id;
private String password;
private String name;
private String birth;
private String email;
private String emailSecond;
private String files;
private MultipartFile bfile;
public String getFiles() {
	return files;
}
public void setFiles(String files) {
	this.files = files;
}
public MultipartFile getBfile() {
	return bfile;
}
public void setBfile(MultipartFile bfile) {
	this.bfile = bfile;
}
@Override
public String toString() {
	return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", birth=" + birth + ", email=" + email
			+ ", emailSecond=" + emailSecond + ", files=" + files + ", bfile=" + bfile + ", address=" + address
			+ ", addressSecond=" + addressSecond + ", phone=" + phone + ", profiles=" + profiles + "]";
}
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getEmailSecond() {
	return emailSecond;
}
public void setEmailSecond(String emailSecond) {
	this.emailSecond = emailSecond;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAddressSecond() {
	return addressSecond;
}
public void setAddressSecond(String addressSecond) {
	this.addressSecond = addressSecond;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getProfiles() {
	return profiles;
}
public void setProfiles(String profiles) {
	this.profiles = profiles;
}
private String address;
private String addressSecond;
private String phone;
private String profiles;

	
}
