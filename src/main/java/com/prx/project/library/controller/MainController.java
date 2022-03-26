package com.prx.project.library.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prx.project.library.dao.BookDAO;
import com.prx.project.library.dao.BorrowedDAO;
import com.prx.project.library.dao.MemberDAO;
import com.prx.project.library.dao.StaffDAO;
import com.prx.project.library.model.Staff;

@Controller
public class MainController {

	@Autowired
	private StaffDAO staffDAO;
	
	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private BorrowedDAO borrowedDAO;

	@GetMapping({"/", "/home" })
	public String main(HttpSession session, Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		Staff user = staffDAO.getStaffByUser(username);

		session.setAttribute("username", user.getFullName());

		session.setAttribute("email", user.getEmail());
		
		// get count of data
		int bookCount = bookDAO.getAllBook().size();
		
		BigDecimal borrowedCount = borrowedDAO.getTotalMoney();
		
		int staffCount = staffDAO.getAllStaff().size();
		
		int memberCount = memberDAO.getAllMember().size();

		model.addAttribute("staffCount", String.valueOf(staffCount) );
		model.addAttribute("bookCount", String.valueOf(bookCount));
		model.addAttribute("memberCount", String.valueOf(memberCount));
		model.addAttribute("borrowedCount", NumberFormat.getCurrencyInstance().format(borrowedCount));

		return "index";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {

		return "login";
	}

}
