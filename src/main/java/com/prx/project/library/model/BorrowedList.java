package com.prx.project.library.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "borrowed" })
@XmlRootElement(name = "borrowed_list")
public class BorrowedList {

	@XmlElement(name = "borrowed")
	protected List<Borrowed> borrowed;

	public List<Borrowed> getBorrowedList() {
		return borrowed;
	}

	public void setBorrowedList(List<Borrowed> borrowedList) {
		this.borrowed = borrowedList;
	}

}
