package com.prx.project.library.OjFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.prx.project.library.model.Category;
import com.prx.project.library.model.CategoryList;

@XmlRegistry
public class CategoryFactory {
	private final static QName name_QNAME = new QName("", "name");

	public CategoryFactory() {
	}

	public CategoryList createCategoryList() {
		return new CategoryList();
	}

	public Category createCategory() {
		return new Category();
	}

	@XmlElementDecl(namespace = "", name = "name")
	public JAXBElement<String> createName(String value) {
		return new JAXBElement<String>(name_QNAME, String.class, null, value);
	}

}
