package com.prx.project.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@GetMapping({ "/", "" })
	public String getAllStaffs(Model model) {
		List<Staff> staffList = staffDAO.getAllStaff();
		model.addAttribute("staffList", staffList);
		return "staffList";
	}

	@GetMapping("/staff-add-edit/{id}")
	public String getStaff(@PathVariable("id") String id, Model model) {
		Staff staff = new Staff();
		if (!"0".equals(id)) {
			staff = staffDAO.getStaff(id);
		} else {
			staff.setId("0");
		}

		model.addAttribute("staff", staff);
		return "staffForm";
	}

	@PostMapping("/staff-add-edit")
	public String newStaff(@ModelAttribute("staff") Staff staff, Model model) {
		model.addAttribute("staff", staff);

 		if ("0".equals(staff.getId())) {
			staffDAO.insertStaff(staff);
		} else {
			staffDAO.updateStaff(staff);
		}

		return "redirect:/staffs";
	}

	@GetMapping("/delete/{id}")
	public String deleteStaff(@PathVariable("id") String id, Model model) {
		staffDAO.deleteStaff(id);
		return "redirect:/staffs";
	}
}
