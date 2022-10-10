package com.greatlearning.CustomerRelationshipManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.greatlearning.CustomerRelationshipManagement.Service.customerService;
import com.greatlearning.CustomerRelationshipManagement.Entity.customerEntity;

@Controller
@RequestMapping("/customer")
public class customerController {

	@Autowired
	private customerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		System.out.println("Request Recieved");

		List<customerEntity> theCustomers = customerService.findAll();

		theModel.addAttribute("Customers", theCustomers);

		return "list-Customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		customerEntity theCustomer = new customerEntity();

		theModel.addAttribute("customerEntity", theCustomer);

		return "Customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		customerEntity theCustomer = customerService.findById(theId);

		theModel.addAttribute("customerEntity", theCustomer);

		return "Customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println(id);
		customerEntity theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);

		} else
			theCustomer = new customerEntity(firstName, lastName, email);

		customerService.save(theCustomer);

		return "redirect:/customer/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		customerService.deleteById(theId);

		return "redirect:/customer/list";

	}

}