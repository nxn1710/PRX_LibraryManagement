package com.prx.project.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prx.project.library.dao.MemberDAO;
import com.prx.project.library.model.Member;

@RestController
public class MemberRestController {
	
	@Autowired
	MemberDAO memberDao;
	
	@GetMapping("/member/rest/{id}")
	public Member getMember(@PathVariable("id") String id) {
		Member member = memberDao.getMemeber(id);
		
		return member;
	}

}
