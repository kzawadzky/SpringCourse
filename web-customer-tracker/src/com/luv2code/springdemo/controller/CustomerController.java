package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// injecting customerService 
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers (Model theModel) {
		
		// get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customers to MVC Model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

}
