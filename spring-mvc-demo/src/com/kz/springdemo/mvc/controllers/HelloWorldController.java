package com.kz.springdemo.mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// controller method to process form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
	
	// add a controller to read form data
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the html form
		String theName = request.getParameter("studentName").toUpperCase();
		
		// convert to uppercase (^in first line)
		
		// create the msg
		String message = "Yo! " + theName;
		// add message to the model
		model.addAttribute("message", message);
		
		return "helloWorld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
			
		// convert to uppercase (^in first line)
		theName = theName.toUpperCase();
		// create the msg
		String message = "Hey dude v3! " + theName;
		// add message to the model
		model.addAttribute("message", message);
		
		return "helloWorld";
	}

}
