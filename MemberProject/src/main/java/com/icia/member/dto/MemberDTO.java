package com.icia.member.dto;

public class MemberDTO {

	private String id;
	private String password;
	private String gender;
	private String phone;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", gender=" + gender + ", phone=" + phone + ", email="
				+ email + "]";
	}
	
	
	
	
}
