package com.prx.project.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prx.project.library.dao.AuthorDAO;
import com.prx.project.library.dao.BookDAO;
import com.prx.project.library.dao.CategoryDAO;
import com.prx.project.library.model.Author;
import com.prx.project.library.model.Book;
import com.prx.project.library.model.Category;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private AuthorDAO authorDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@GetMapping({ "/", "" })
	public String getAllBooks(Model model) {
		List<Book> bookList = bookDAO.getAllBook();
		model.addAttribute("bookList", bookList);
		return "bookList";
	}

	@GetMapping("/book-add-edit/{id}")
	public String getBook(@PathVariable("id") String id, Model model) {
		List<Category> categoryList = categoryDAO.getAllCategory();
		List<Author> authorList = authorDAO.getAllAuthor();
		Book book = new Book();

		if (!"0".equals(id)) {
			book = bookDAO.getBook(id);
		} else {
			book.setId("0");
		}

		model.addAttribute("book", book);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("authorList", authorList);

		return "bookForm";
	}

	@PostMapping("/book-add-edit")
	public String newBook(@ModelAttribute("book") Book book, Model model) {
		model.addAttribute("book", book);

		if ("0".equals(book.getId())) {
			bookDAO.insertBook(book);
		} else {
			bookDAO.updateBook(book);
		}

		return "redirect:/books";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") String id, Model model) {
		bookDAO.deleteBook(id);
		return "redirect:/books";
	}
}
