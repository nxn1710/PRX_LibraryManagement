package com.prx.project.library.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.prx.project.library.OjFactory.AuthorFactory;
import com.prx.project.library.model.Author;
import com.prx.project.library.model.AuthorList;

@Service
public class AuthorDAO {

	public AuthorList unmarshalling() {

		AuthorList authors = null;
		try {
			JAXBContext context = JAXBContext.newInstance(AuthorFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("FileXml/authors.xml");
			authors = (AuthorList) unmarshaller.unmarshal(file);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return authors;
	}

	public List<Author> getAllAuthor() {
		return this.unmarshalling().getAuthor();
	}

}
