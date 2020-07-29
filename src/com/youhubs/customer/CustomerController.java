package com.youhubs.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		List<Customer> customers = service.listCustomer();
		mv.addObject("customers", customers);

		return mv;
	}

	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		model.put("customer", new Customer());
		return "customer_form";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.save(customer);
		
		return "redirect:/";
	}
}
