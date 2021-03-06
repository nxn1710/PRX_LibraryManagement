package com.prx.project.library.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "name", "gender", "phone", "age", "email", "address" })
@XmlRootElement(name = "member")
public class Member {

	@XmlAttribute(name = "id", required = true)
	protected String id;
	@XmlElement(name = "name")
	protected String name;
	@XmlElement(name = "gender")
	protected String gender;
	@XmlElement(name = "phone")
	protected String phone;
	@XmlElement(name = "age")
	protected Integer age;
	@XmlElement(name = "email")
	protected String email;
	@XmlElement(name = "address")
	protected String address;

	public Member() {
		super();
	}

	public Member(String id, String name, String gender, String phone, Integer age, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.age = age;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
