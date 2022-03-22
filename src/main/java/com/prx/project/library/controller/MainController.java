package com.prx.project.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list() {
		return "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

}
