package com.practice.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read form data and
	//add data to the model
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request,Model model) {
		
		//read the req parameter from html form
		String theName=request.getParameter("studentName");
		
		//convert the data to all caps
		theName=theName.toUpperCase();
		
		//create the message
		String result="Yo! "+theName;
		
		//add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
		
	}
	
	@RequestMapping("/processFormThree")
	public String letsShoutDude(@RequestParam("studentName") String theName,Model model) {
		
		//convert the data to all caps
		theName=theName.toUpperCase();
		
		//create the message
		String result="Yo my kiddo "+theName;
		
		//add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
		
	}

}
