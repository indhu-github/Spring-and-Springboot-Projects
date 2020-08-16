package com.example.demo;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("home")
	public ModelAndView home(Alien alien) {
		ModelAndView mv=new ModelAndView();
		//System.out.println("Hello "+myName);
		mv.addObject("obj",alien);
		mv.setViewName("home");
		return mv;
	}
}
