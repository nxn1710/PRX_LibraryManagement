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
	private final static QName year_QNAME = new QName("", "year");
	private final static QName language_QNAME = new QName("", "language");
	private final static QName pages_QNAME = new QName("", "pages");
	private final static QName available_QNAME = new QName("", "available");
	private final static QName thumbnail_QNAME = new QName("", "thumbnail");
	private final static QName description_QNAME = new QName("", "description");
	private final static QName categoryName_QNAME = new QName("", "categoryName");

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

	@XmlElementDecl(namespace = "", name = "year")
	public JAXBElement<String> createYear(String value) {
		return new JAXBElement<String>(year_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "language")
	public JAXBElement<String> createLanguage(String value) {
		return new JAXBElement<String>(language_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "pages")
	public JAXBElement<String> createPages(String value) {
		return new JAXBElement<String>(pages_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "available")
	public JAXBElement<String> createAvailable(String value) {
		return new JAXBElement<String>(available_QNAME, String.class, null, value);

	}

	@XmlElementDecl(namespace = "", name = "thumbnail")
	public JAXBElement<String> createThumbnail(String value) {
		return new JAXBElement<String>(thumbnail_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "description")
	public JAXBElement<String> createDescription(String value) {
		return new JAXBElement<String>(description_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "categoryName")
	public JAXBElement<String> createCategoryName(String value) {
		return new JAXBElement<String>(categoryName_QNAME, String.class, null, value);

	}
}
