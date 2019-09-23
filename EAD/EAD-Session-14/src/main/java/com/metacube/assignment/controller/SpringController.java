package com.metacube.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SpringController {

	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		return "welcome";
	}

	@GetMapping("/login")
	public String loginPage(Model model,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null)
			model.addAttribute("errorMsg",
					"Your username and password are invalid.");
		return "login";
	}

	@GetMapping("/getUser")
	public String getUser() {
		return "getUser";
	}

	@GetMapping("/updateUser")
	public String updateUser() {
		return "updateUser";
	}

	@GetMapping("/getAdmin")
	public String getAdmin() {
		return "getAdmin";
	}

	@GetMapping("/updateAdmin")
	public String updateAdmin() {
		return "updateAdmin";
	}
}
