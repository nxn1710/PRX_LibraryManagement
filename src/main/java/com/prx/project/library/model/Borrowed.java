package com.prx.project.library.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "borrowedTime", "returnDeadline", "totalPrice", "member", "books" })
@XmlRootElement(name = "borrowed")
public class Borrowed {
	
	@XmlAttribute(name = "id", required = true)
	private String id;
	
	@XmlElement(name = "borrowedTime")
	private String borrowedTime;
	
	@XmlElement(name = "returnDeadline")
	private String returnDeadline;
	
	@XmlElement(name = "totalPrice")
	private float totalPrice;
	
	@XmlElement(name = "member")
	private Member member;
	
	@XmlElement(name = "book_list")
	private BookList books;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBorrowedTime() {
		return borrowedTime;
	}

	public void setBorrowedTime(String borrowedTime) {
		this.borrowedTime = borrowedTime;
	}

	public String getReturnDeadline() {
		return returnDeadline;
	}

	public void setReturnDeadline(String returnDeadline) {
		this.returnDeadline = returnDeadline;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public BookList getBooks() {
		return books;
	}

	public void setBooks(BookList books) {
		this.books = books;
	}
	
	public int getNumberOfBook() {
		if (books.getBook() == null) {
			return 0;
		}
		return books.getBook().size();
	}
	
	
	

}
