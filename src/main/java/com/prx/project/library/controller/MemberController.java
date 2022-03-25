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

import com.prx.project.library.dao.MemberDAO;
import com.prx.project.library.model.Member;

@Controller
@RequestMapping("/members")
public class MemberController {
	@Autowired
	private MemberDAO memberDAO;

	@GetMapping({ "/", "" })
	public String getAllMembers(Model model) {
		List<Member> memberList = memberDAO.getAllMember();
		model.addAttribute("memberList", memberList);
		return "memberList";
	}

	@GetMapping("/member-add-edit/{id}")
	public String getMember(@PathVariable("id") String id, Model model) {
		Member member = new Member();
		if (!"0".equals(id)) {
			member = memberDAO.getMemeber(id);
		} else {
			member.setId("0");
		}

		model.addAttribute("member", member);
		return "memberForm";
	}

	@PostMapping("/member-add-edit")
	public String newMember(@ModelAttribute("member") Member member, Model model) {
		model.addAttribute("member", member);

		if ("0".equals(member.getId())) {
			memberDAO.insertMemeber(member);
		} else {
			memberDAO.updateMember(member);
		}

		return "redirect:/members";
	}

	@GetMapping("/delete/{id}")
	public String deleteMember(@PathVariable("id") String id, Model model) {
		memberDAO.deleteMember(id);
		return "redirect:/members";
	}
}
