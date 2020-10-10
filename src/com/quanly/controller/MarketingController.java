package com.quanly.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quanly.entity.Marketing;
import com.quanly.service.MarketingService;

@Controller
public class MarketingController {

	@Autowired
	private MarketingService marketingservice;

	@RequestMapping("/")
	public String Marketing(Model model) {
		List<Marketing> listMarketings = marketingservice.listAll();
		model.addAttribute("listMarketings", listMarketings);
		return "marketing";
	}
	@RequestMapping("insertmarketing")
	public String newDsdkkcbForm(Map<String, Object> model) {
		Marketing marketing = new Marketing();
		model.put("marketing", marketing);
		return "insertMarketing";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBacsi(@ModelAttribute("marketing") Marketing marketing) {
		marketingservice.save(marketing);
		return "redirect:/";
	}
	@RequestMapping("/edit")
	public ModelAndView editmarketing(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("editMarketing");
		Marketing marketing = marketingservice.get(id);
		mav.addObject("marketing", marketing);
		
		return mav;
	}
	
}
