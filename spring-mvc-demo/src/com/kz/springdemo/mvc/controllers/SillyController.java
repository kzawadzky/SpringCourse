package com.kz.springdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "helloWorld-form";
	}

}
