package com.prx.project.library.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "title", "author", "price", "description", "category", "thumbnail" })
@XmlRootElement(name = "book")
public class Book {

	@XmlAttribute(name = "id", required = true)
	protected String id;
	
	@XmlElement(name = "title")
	protected String title;

	@XmlElement(name = "author")
	protected String author;

	@XmlElement(name = "price")
	protected String price;

	@XmlElement(name = "description")
	protected String description;

	@XmlElement(name = "category")
	protected String category;

	@XmlElement(name = "thumbnail")
	protected String thumbnail;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String price, String description, String category, String thumbnail) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.description = description;
		this.category = category;
		this.thumbnail = thumbnail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}
