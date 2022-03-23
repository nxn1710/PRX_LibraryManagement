package com.prx.project.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.prx.project.library.dao.MemberDAO;
import com.prx.project.library.model.Member;
import com.prx.project.library.model.MemberList;

@Controller
public class MainController {

	@Autowired
	private MemberDAO memberDao;
	
	@GetMapping("/")
	public String main() {
		MemberList m = memberDao.unmarshalling();
		
		for(Member n : m.getMember()) {
			System.out.println(n.getName());
		}
		
		
		return "index";
	}

}
