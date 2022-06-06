package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/user/index")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/user/makeFriend")
	public String viewsFriend() {
		
		return "make-friend";
	}
}
