package com.prx.project.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books/")
public class BookController {

	@GetMapping("/")
	public String getBookList() {
		return "bookList";
	}

	@GetMapping("/{id}")
	public String getBookById() {
		return "bookList";
	}

	@GetMapping("/new")
	public String newBook() {
		return "bookForm";
	}
}
