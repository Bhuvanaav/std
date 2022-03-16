package com.spring.std.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.std.model.Student;
import com.spring.std.service.StudentService;

@Controller
@RequestMapping
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Student> listStudent = service.listAll();
		model.addAttribute("listStudent", listStudent);
		System.out.println("Get /");
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("student",new Student());
		return "new";
	}
	
	@PostMapping("/save") 
	public String saveStudent(@ModelAttribute("student") Student std) {
		service.save(std);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("new");
		Student std = service.get(id);
		mav.addObject("student", std);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name ="id") int id) {
		service.delete(id);
		return "redirect:/";
		
	}
	
	
	
	
	
	
	
	
	
	

}
