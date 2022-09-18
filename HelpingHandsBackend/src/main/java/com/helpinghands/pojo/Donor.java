package com.helpinghands.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donor {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int donorid;

	private String name;
	private String city;
	
	@Column(unique=true)
	private String email;
	
	private String pwd;
	private String phone;
	public int getDonorid() {
		return donorid;
	}
	public void setDonorid(int donorid) {
		this.donorid = donorid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Donor [donorid=" + donorid + ", name=" + name + ", city=" + city + ", email=" + email + ", pwd=" + pwd
				+ ", phone=" + phone + "]";
	}
	
	
}
