package com.dwatkins.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dwatkins.studentroster.models.Contact;
import com.dwatkins.studentroster.models.Student;
import com.dwatkins.studentroster.services.StudentService;

@Controller
public class StudentsController {
	private final StudentService studentService;
	
	public StudentsController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Object[]> allStudents = studentService.allStudents();
		model.addAttribute("students", allStudents);
		return "students/home.jsp";
	}
	
	@RequestMapping("/students")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "students/newStudent.jsp";
	}
	
	@RequestMapping(value="/students", method=RequestMethod.POST)
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "students/newStudent.jsp";
		}
		else {
			studentService.createStudent(student);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/contacts")
	public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
		List<Student> eligibles = studentService.studentsWithoutContact();
		model.addAttribute("eligibles", eligibles);
		return "students/newContact.jsp";
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Student> eligibles = studentService.studentsWithoutContact();
			model.addAttribute("eligibles", eligibles);
			return "students/newContact.jsp";
		}
		else {
			studentService.createContact(contact);
			return "redirect:/";
		}
	}
}
