package com.prx.project.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prx.project.library.dao.BookDAO;
import com.prx.project.library.dao.MemberDAO;
import com.prx.project.library.model.Book;
import com.prx.project.library.model.Member;

@RestController
public class BookRestController {

	@Autowired
	BookDAO bookDAO;
	
	@GetMapping("/book/rest/{id}")
	public Book getBook(@PathVariable("id") String id) {
		Book book = bookDAO.getBook(id);
		return book;
	}
}
