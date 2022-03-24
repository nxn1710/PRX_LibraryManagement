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

import com.prx.project.library.dao.StaffDAO;
import com.prx.project.library.model.Staff;

@Controller
@RequestMapping("/staffs")
public class StaffControler {

	@Autowired
	private StaffDAO staffDAO;

	@GetMapping("/")
	public String getAllStaffs(Model model) {
		List<Staff> staffList = staffDAO.getAllStaff();
		model.addAttribute("staffList", staffList);
		return "staffList";
	}
	
	@GetMapping("/{id}")
	public String getStaff(@PathVariable("id") String  id, Model model) {
		Staff staff = staffDAO.getStaff(id);
		model.addAttribute("staff", staff);
		return "staffForm";
	}

	@GetMapping("/new")
	public String redirectStaffForm(Model model) {
		model.addAttribute("staff", new Staff());
		return "staffForm";
	}

	@PostMapping("/new")
	public String newStaff(@ModelAttribute Staff staff,Model model) {
		model.addAttribute("staff", staff);
		staffDAO.insertStaff(staff);
		return "staffList";
	}
	
	@PostMapping("/update")
	public String updateStaff(@ModelAttribute Staff staff,Model model) {
		model.addAttribute("staff", staff);
		staffDAO.updateStaff(staff);
		return "staffList";
	}
	
	@PostMapping("/delete")
	public String deleteStaff(@ModelAttribute Staff staff, Model model) {
		model.addAttribute("staff", staff);
		staffDAO.deleteStaff(staff.getId());
		return "staffList";
	}
}
