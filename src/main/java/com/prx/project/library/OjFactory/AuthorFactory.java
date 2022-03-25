package com.prx.project.library.OjFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.prx.project.library.model.Author;
import com.prx.project.library.model.AuthorList;

@XmlRegistry
public class AuthorFactory {
	private final static QName name_QNAME = new QName("", "name");

	public AuthorFactory() {
	}

	public AuthorList createAuthorList() {
		return new AuthorList();
	}

	public Author createAuthor() {
		return new Author();
	}

	@XmlElementDecl(namespace = "", name = "name")
	public JAXBElement<String> createName(String value) {
		return new JAXBElement<String>(name_QNAME, String.class, null, value);
	}

}
