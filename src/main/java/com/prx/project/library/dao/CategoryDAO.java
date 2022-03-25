package com.prx.project.library.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.prx.project.library.OjFactory.CategoryFactory;
import com.prx.project.library.model.Category;
import com.prx.project.library.model.CategoryList;

@Service
public class CategoryDAO {

	public CategoryList unmarshalling() {

		CategoryList categories = null;
		try {
			JAXBContext context = JAXBContext.newInstance(CategoryFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("FileXml/categories.xml");
			categories = (CategoryList) unmarshaller.unmarshal(file);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return categories;
	}

	public List<Category> getAllCategory() {
		return this.unmarshalling().getCategory();
	}

}
