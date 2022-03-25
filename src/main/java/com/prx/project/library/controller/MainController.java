package com.prx.project.library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prx.project.library.dao.StaffDAO;
import com.prx.project.library.model.Staff;

@Controller
public class MainController {

	@Autowired
	private StaffDAO staffDAO;

	@GetMapping({ "/", "/home" })
	public String main(HttpSession session) {
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

		return "index";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {

		return "login";
	}

}
