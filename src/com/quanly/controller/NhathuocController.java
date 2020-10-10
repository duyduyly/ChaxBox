package com.quanly.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quanly.entity.Nhathuoc;
import com.quanly.service.NhathuocService;

@Controller
public class NhathuocController {

	@Autowired
	private NhathuocService nhathuocService;

	@RequestMapping("/nhathuoc")
	public ModelAndView home() {
		List<Nhathuoc> listNhathuoc = nhathuocService.listAll();
		ModelAndView mav = new ModelAndView("nhathuoc/DSNhathuoc");
		mav.addObject("listNhathuoc", listNhathuoc);
		return mav;
	}
	@RequestMapping("nhathuoc/save_nhathuoc")
	public String InsertForm( @ModelAttribute("nhathuoc") Nhathuoc nhathuoc) {
		nhathuocService.save(nhathuoc);
		return "redirect:/nhathuoc";		
	}
	
	@RequestMapping("nhathuoc/new_nhathuoc")
	public String New_NhaThuoc(Map<String, Object> model) {
		Nhathuoc nhathuoc = new Nhathuoc();
		model.put("nhathuoc", nhathuoc);
		return "nhathuoc/New_NhaThuoc";
	}
	
	@RequestMapping("/edit_nhathuoc")
	public ModelAndView editCustomerForm(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("nhathuoc/edit_nhathuoc");
		Nhathuoc nhathuoc = nhathuocService.get(id);
		mav.addObject("nhathuocr", nhathuoc);
		
		return mav;
	}
	
	@RequestMapping("/delete_nhathuoc")
	public String deleteCustomerForm(@RequestParam String id) {
		nhathuocService.delete(id);
		return "redirect:/nhathuoc";		
	}
}
