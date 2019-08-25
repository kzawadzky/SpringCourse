package com.kz.springdemo.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kz.springdemo.mvc.classes.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//add initbinder to trim strings
	
	//resolve leading and trailing whitespace
	
	//resolve validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); 
		// true -> trim to null if whitespace only
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());

		return "customer-form";
	}

	@RequestMapping("/processForm")

	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

		System.out.println("Last name: " + theCustomer.getLastName());
		if (theBindingResult.hasErrors()) {
			return "customer-form";

		} else {
			return "customer-confirmation";
		}
	}

}
