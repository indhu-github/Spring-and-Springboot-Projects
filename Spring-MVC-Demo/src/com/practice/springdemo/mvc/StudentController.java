package com.practice.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		//create a student object
		Student student=new Student();
		
		//add student obj to the model
		model.addAttribute("student",student);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String process(@ModelAttribute("student") Student theStudent) {
		System.out.println("theStudent "+theStudent.getFirstName()+" "+theStudent.getLastName());
		return "student-confirmation";
	}
}
