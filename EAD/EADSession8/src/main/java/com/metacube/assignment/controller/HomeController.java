package com.metacube.assignment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.assignment.model.Student;

@Controller
public class HomeController {
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	 @GetMapping("/home")
	 public String home(Model model){
	 model.addAttribute("welcomeMessage",welcomeMessage);
	 return "home";
	 }
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}
	@GetMapping("/showStudent")
	public String showStudent() {
		
		return "showStudent";
	}

	@PostMapping("/addStudent")
	public String studentAdded(@Validated Student student, BindingResult result) {

		if (result.hasErrors()) {
			return "addStudent";
		} else {
			System.out.print(student);
			return "redirect:/home";
		}

	}

	

//	 @GetMapping("/home")
//	 public String home(@RequestParam(value = "name") String welcomeMessage, Model model) {
//	 model.addAttribute("name", welcomeMessage);
//	 return "home";
//	 }

	// @GetMapping("/home/{id}/abc/{test}")
	// public String home(@RequestParam(value ="name",required = false) String
	// name , @PathVariable ("id") int id,@PathVariable ("test") String test ) {
	// System.out.println(name);
	// System.out.println(id);
	// System.out.println(test);
	// return "home";
	// }

}
