package com.prx.project.library.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "staff_list")
@XmlType(name = "", propOrder = { "staff" })
public class StaffList {

	@XmlElement(name = "staff", required = true)
	protected List<Staff> staff;

	public List<Staff> getStaffs() {
		return staff;
	}

	public void setStaffs(List<Staff> staff) {
		this.staff = staff;
	}

}
