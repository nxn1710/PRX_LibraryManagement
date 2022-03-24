package com.prx.project.library.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id" ,"email", "password", "fullName", "gender", "age", "phone", "address" })
@XmlRootElement(name = "staff")
public class Staff {

	@XmlElement(name = "id", required = true)
	protected String id;
	@XmlElement(name = "email")
	protected String email;
	@XmlElement(name = "password")
	protected String password;
	@XmlElement(name = "fullName")
	protected String fullName;
	@XmlElement(name = "gender")
	protected String gender;
	@XmlElement(name = "age")
	protected String age;
	@XmlElement(name = "phone")
	protected String phone;
	@XmlElement(name = "address")
	protected String address;
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}

	

}
