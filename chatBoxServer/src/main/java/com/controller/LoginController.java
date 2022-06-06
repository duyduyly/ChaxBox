package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.Customer;
import com.entity.Users;
import com.form.registerForm;
import com.service.IAccountService;
import com.service.ICustomerService;
import com.util.SessionService;

@Controller
public class LoginController {

	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	SessionService sessionService;
	
	@GetMapping(value = {"login","/"})
	public String loginViews(Model model) {
		model.addAttribute("account", new Users());
		return "login";
	}
	
	private final String MESSAGE = "MESSAGE";
	
	@PostMapping("login")
	public String login(@ModelAttribute("account") Users user,Model model) {
		
		String message = "";
		
		try {
			Users userDB = accountService.findByUsername(user.getUsername());
			
			if(userDB.getPassword().equals(user.getPassword())) {
				
				sessionService.set(contant.USER_SESSION, userDB);
				sessionService.set(contant.CUSTOMER_SESSION, customerService.findByAccount(userDB));
				System.out.println("Customer: "+ customerService.findByAccount(userDB).toString());
				return "redirect:/user/index";
			}else {
				message = "Password or Username Not Match";
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			message = "Password or Username Not Match";
		}
		model.addAttribute("message", message);
		return "login";
	}
	
	
	//registration
	@GetMapping("/register")
	public String registration(Model model) {
		model.addAttribute("registerForm", new registerForm());
		
		return "register";
	}
	
	
	//register
		@PostMapping("/register")
		public String register(@ModelAttribute("registerForm")registerForm registerForm,Model model) {
			
			String messsage = "";
			
			System.out.println(registerForm.toString());
			
			if(registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
				Optional<Users> user = Optional.ofNullable(accountService.findByUsername(registerForm.getUsername()));
				System.out.println();
				if(user.isEmpty() == true) {
					Users userSave = new Users();
					userSave.setUsername(registerForm.getUsername());
					userSave.setPassword(registerForm.getPassword());
					
					Customer customer = new Customer();
					customer.setAccount(userSave);
					customer.setName(registerForm.getName());
					
					accountService.save(userSave);
					customerService.save(customer);
					return "redirect:/";
					
				}else {
					messsage = "Account illegal";
				}
				
			}else {
				messsage = "Password and confirm Password not match";
			}
			
			model.addAttribute(this.MESSAGE, messsage);
			return "register";
		}
	
	
}
