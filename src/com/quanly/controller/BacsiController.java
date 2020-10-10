package com.quanly.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quanly.entity.Bacsi;
import com.quanly.service.BacsiService;

@Controller
public class BacsiController {

	@Autowired
	private BacsiService BacsiService;
	
	@RequestMapping("/bacsi")
	public ModelAndView home() {
		List<Bacsi> listBacsi = BacsiService.listAll();
		ModelAndView mav = new ModelAndView("bacsi/index");
		mav.addObject("listBacsi", listBacsi);
		return mav;
	}
	
	@RequestMapping("/newbacsi")
	public String newBacsiForm(Map<String, Object> model) {
		Bacsi bacsi = new Bacsi();
		model.put("bacsi", bacsi);
		return "bacsi/new_bacsi";
	}
	
	@RequestMapping(value = "/save_bacsi", method = RequestMethod.POST)
	public String saveBacsi(@ModelAttribute("bacsi") Bacsi bacsi) {
		BacsiService.save(bacsi);
		return "redirect:/bacsi";
	}
//	
	@RequestMapping("/edit_bacsi")
	public ModelAndView editBacsiCustomerForm(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("bacsi/edit_bacsi");
		Bacsi bacsi =BacsiService.get(id);
		mav.addObject("editbacsi", bacsi);
		
		return mav;
	}
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
