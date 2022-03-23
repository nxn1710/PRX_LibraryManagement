package com.prx.project.library.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"title", "year", "language", "pages", "available", "thumbnail", "description", "categoryName" })
@XmlRootElement(name = "book")
public class Book {

	@XmlElement(name = "title")
	protected String title;
	@XmlElement(name = "year")
	protected Date year;
	@XmlElement(name = "language")
	protected String language;
	@XmlElement(name = "pages")
	protected Integer pages;
	@XmlElement(name = "available")
	protected Integer available;
	@XmlElement(name = "thumbnail")
	protected String thumbnail;
	@XmlElement(name = "description")
	protected String description;
	@XmlElement(name = "categoryName")
	protected String categoryName;
	
	public Book() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	

}
