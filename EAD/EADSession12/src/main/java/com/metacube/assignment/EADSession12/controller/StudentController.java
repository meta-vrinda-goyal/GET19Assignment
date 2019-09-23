package com.metacube.assignment.EADSession12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.assignment.EADSession12.dto.Name;
import com.metacube.assignment.EADSession12.dto.Std;
import com.metacube.assignment.EADSession12.dto.StudentForm;
import com.metacube.assignment.EADSession12.model.Student;
import com.metacube.assignment.EADSession12.repository.StudentRepository;
import com.metacube.assignment.EADSession12.util.DTOUtil;

@Controller
public class StudentController {

	StudentRepository repository;
	List<Student> listOfStudents = new ArrayList<>();

	@Autowired
	public StudentController(StudentRepository repository) {
		this.repository = repository;
	}

	@Value("${welcome.message}")
	private String welcomeMessage;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("studentForm", new StudentForm());

		return "addStudent";
	}

	@PostMapping("/addStudent")
	public String studentAdded(@Validated StudentForm student,
			BindingResult result, Model model, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			return "addStudent";
		} else {

			if (repository.findByEmailContainingIgnoreCase(student.getEmail())
					.size() != 0) {
				attribute.addFlashAttribute("msg", "Student already exist");
			} else {
				repository.save(DTOUtil.map(student, Student.class));
				attribute.addFlashAttribute("msg", "Student added");
			}
			return "redirect:/home";
		}
	}

	@GetMapping("/showStudent")
	public String showStudent(Model model) {
		List<Student> studentList = new ArrayList<Student>();
		studentList = repository.findAll();
		model.addAttribute("studentList", studentList);
		return "showStudent";
	}

	@GetMapping("/searchStudent")
	public String searchStudent(Model model) {
		model.addAttribute("std", new Std());
		model.addAttribute("name", new Name());
		return "searchStudent";
	}

	@PostMapping("/studentByClass")
	public String showStudentByClass(@Validated Std std, BindingResult result,
			Model model, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			return "searchStudent";
		} else {
			List<Student> studentList = new ArrayList<Student>();
			studentList = repository.findByStdContaining(std.getStd());
			if (studentList.size() != 0) {
				model.addAttribute("studentList", studentList);
				return "searchResult";
			} else {
				attribute.addFlashAttribute("msg", "Student added");
				result.addError(new ObjectError("msg", "No student Found"));
				return "searchStudent";
			}
		}
	}

	@PostMapping("/studentByName")
	public String showStudentByName(@Validated Name name, BindingResult result,
			Model model, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			return "searchStudent";
		} else {
			List<Student> studentList = new ArrayList<Student>();
			studentList = repository.findByFirstNameContainingIgnoreCase(name
					.getFirstName());
			if (studentList.size() != 0) {
				model.addAttribute("studentList", studentList);
				return "searchResult";
			} else {
				attribute.addFlashAttribute("msg", "Student added");
				result.addError(new ObjectError("msg", "No student Found"));
				return "searchStudent";
			}
		}
	}

}
