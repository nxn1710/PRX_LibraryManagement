package com.prx.project.library.dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.prx.project.library.OjFactory.BookFactory;
import com.prx.project.library.OjFactory.MemberFactory;
import com.prx.project.library.model.BookList;
import com.prx.project.library.model.MemberList;

public class BookDAO {

	public BookList unmarshalling() {

		BookList books = null;
		try {
			JAXBContext context = JAXBContext.newInstance(BookFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("/Users/sonit/Documents/workspace-spring-tool-suite-4-4.14.0.RELEASE/PRX_LibraryManagement/FileXml/books.xml");
			books = (BookList) unmarshaller.unmarshal(file);		
			System.out.println("Books: " + books);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return books;
	}
}
