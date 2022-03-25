package com.prx.project.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.prx.project.library.dao.BookDAO;
import com.prx.project.library.dao.BorrowedDAO;
import com.prx.project.library.dao.MemberDAO;
import com.prx.project.library.model.Book;
import com.prx.project.library.model.BookList;
import com.prx.project.library.model.Borrowed;

@Controller
public class BorrowedController {

	@Autowired
	private BorrowedDAO borrowedDAO;

	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private MemberDAO memberDAO;

	@GetMapping("/borrows")
	public String main(Model model) {
		List<Borrowed> listBorrow = borrowedDAO.getAllBorrowed();
		model.addAttribute("listBorrow", listBorrow);
		return "borrowlist";
	}

	@GetMapping("/borrows/{id}")
	public String viewBorrow(@PathVariable("id") String id, Model model) {
		Borrowed borrowed = borrowedDAO.get(id);
		model.addAttribute("borrowed", borrowed);
		return "borrow";
	}

	@GetMapping("/borrows/new")
	public String newBorrow(Model model) {
		Borrowed borrowed = new Borrowed();
		model.addAttribute("borrowed", borrowed);
		return "newborrow";
	}

	@PostMapping("/borrows/new")
	public RedirectView postBorrow(@RequestParam("memberid") String memberid, @RequestParam("borrowdate") String borrowdate,
			@RequestParam("returndate") String returndate, @RequestParam("bookid1") String bookid1,
			@RequestParam("bookid2") String bookid2, @RequestParam("bookid3") String bookid3,
			@RequestParam("bookid4") String bookid4, @RequestParam("bookid5") String bookid5,
			@RequestParam("totalFee") String totalFee) {

		Borrowed borrowed = new Borrowed();
		
		int idMax = 0;
		for (Borrowed b : borrowedDAO.getAllBorrowed()) {
			if (Integer.valueOf(b.getId()) > idMax) {
				idMax = Integer.valueOf(b.getId());
			}
		}
		
		idMax++;
		
		borrowed.setId(String.valueOf(idMax));
		borrowed.setMember(memberDAO.getMemeber(memberid));
		borrowed.setBorrowedTime(borrowdate);
		borrowed.setTotalPrice(Float.valueOf(totalFee));
		borrowed.setReturnDeadline(returndate);
		BookList bookList = new BookList();
		List<Book> listBook = new ArrayList<Book>();
		if (bookid1 != null || !"".equals(bookid1)) {
			listBook.add(bookDAO.getBook(bookid1));
		}
		if (bookid2 != null || !"".equals(bookid2)) {
			listBook.add(bookDAO.getBook(bookid2));
		}
		if (bookid3 != null || !"".equals(bookid3)) {
			listBook.add(bookDAO.getBook(bookid3));
		}
		if (bookid4 != null || !"".equals(bookid4)) {
			listBook.add(bookDAO.getBook(bookid4));
		}
		if (bookid5 != null || !"".equals(bookid5)) {
			listBook.add(bookDAO.getBook(bookid5));
		}
		bookList.setBook(listBook);
		borrowed.setBooks(bookList);

		borrowedDAO.insert(borrowed);
		
		return new RedirectView("/borrows");
	}
	
	@GetMapping("/borrows/delete/{id}")
	public String deleteBook(@PathVariable("id") String id, Model model) {
		borrowedDAO.delete(id);
		return "redirect:/borrows";
	}
}
