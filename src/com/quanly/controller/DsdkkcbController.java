package com.quanly.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quanly.entity.Dsdkkcb;
import com.quanly.service.DsdkkcbService;

@Controller

public class DsdkkcbController {

	@Autowired
	private DsdkkcbService DsdkkcbService;

//	@RequestMapping("/")
//	public ModelAndView home() {
//		List<Dsdkkcb> listDsdkkcb = DsdkkcbService.listAll();
//		ModelAndView mav = new ModelAndView("index");
//		mav.addObject("listDsdkkcb", listDsdkkcb);
//		return mav;
//	}
	
	@RequestMapping("/dsdkkcb")
	public String home(Model model) {
		List<Dsdkkcb> listDsdkkcb = DsdkkcbService.listAll();
		model.addAttribute("listDsdkkcb", listDsdkkcb);
		
		return "dsdkkcb/index";
	}
	@RequestMapping("/newdsdkkcb")
	public String newDsdkkcbForm(Map<String, Object> model) {
		Dsdkkcb dsdkkcb = new Dsdkkcb();
		model.put("dsdkkcb", dsdkkcb);
		return "dsdkkcb/new_dsdkkcb";
	}

//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String saveBacsi(@ModelAttribute("dsdkkcb") Dsdkkcb dsdkkcb) {
//		DsdkkcbService.save(dsdkkcb);
//		return "redirect:/";
//	}
//	
//	@RequestMapping("/edit")
//	public ModelAndView editCustomerForm(@RequestParam long id) {
//		ModelAndView mav = new ModelAndView("edit_customer");
//		Customer customer = customerService.get(id);
//		mav.addObject("customer", customer);
//		
//		return mav;
//	}
//	
//	@RequestMapping("/delete")
//	public String deleteCustomerForm(@RequestParam long id) {
//		customerService.delete(id);
//		return "redirect:/";		
//	}
//	
//	@RequestMapping("/search")
//	public ModelAndView search(@RequestParam String keyword) {
//		List<Customer> result = customerService.search(keyword);
//		ModelAndView mav = new ModelAndView("search");
//		mav.addObject("result", result);
//		
//		return mav;		
//	}	

}
