package com.prx.project.library.OjFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.prx.project.library.model.Book;
import com.prx.project.library.model.BookList;

@XmlRegistry
public class BookFactory {
	private final static QName title_QNAME = new QName("", "title");
	private final static QName author_QNAME = new QName("", "author");
	private final static QName price_QNAME = new QName("", "price");
	private final static QName description_QNAME = new QName("", "description");
	private final static QName category_QNAME = new QName("", "category");
	private final static QName thumbnail_QNAME = new QName("", "thumbnail");

	public BookFactory() {
	}

	public BookList createBookList() {
		return new BookList();
	}

	public Book createBook() {
		return new Book();
	}

	@XmlElementDecl(namespace = "", name = "title")
	public JAXBElement<String> createTitle(String value) {
		return new JAXBElement<String>(title_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "author")
	public JAXBElement<String> createAuthor(String value) {
		return new JAXBElement<String>(author_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "price")
	public JAXBElement<String> createPrice(String value) {
		return new JAXBElement<String>(price_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "description")
	public JAXBElement<String> createDescription(String value) {
		return new JAXBElement<String>(description_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "category")
	public JAXBElement<String> createCategory(String value) {
		return new JAXBElement<String>(category_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "thumbnail")
	public JAXBElement<String> createThumbnail(String value) {
		return new JAXBElement<String>(thumbnail_QNAME, String.class, null, value);
	}

}
