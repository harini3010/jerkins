package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import com.example.demo.entity.BloodDonar;
import com.example.demo.services.BloodDonarService;

@Controller

public class BloodBankController {
	
	@Autowired
	private BloodDonar donar;
	
	@Autowired
	private BloodDonarService service;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String init(Model model) {
		
		model.addAttribute("heading", "Jeevan Blood Bank");
		
		return "index";
	}
	@ModelAttribute(name="groups")
	public String[] getGroup() {
	return new String[] {"ove","bve","ave"};

	}
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String addDonar(Model model) {
		
		model.addAttribute("command", donar);
		
		return "addDonar";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String onSubmit(@Valid @ModelAttribute("command") BloodDonar donar, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addDonar";
		}
		else {
			//this.service.add(donar);
		return "success";
		}
	}
	
	@RequestMapping(value = "/findAll")
	public String getAllDonar(Model model) {
		
		List<BloodDonar> list = this.service.findAll();
		model.addAttribute("list",list);
		return "showAll";
		
	}
	
	@RequestMapping(value = "/findByGroup")
	public String getAllDonarByBloodGroup(@RequestParam("group") String bloodGroup ,Model model) {
		
		List<BloodDonar> list = this.service.findByBloodGroup(bloodGroup);
		model.addAttribute("list",list);
		return "showAll";
		
	}

	@RequestMapping("/srchByGroup")
	public String initSerchForm() {
		return "srchByGroup";
	}
	@RequestMapping("/findName")
	public String initSearchForm() {
		return "findName";
	}
	@RequestMapping(value = "/findByFirstName")
		public String  getFirstName(@RequestParam("firstName") String firstName, Model model) {
		List<BloodDonar> list = this.service.findByFirstName(firstName);
		model.addAttribute("list",list);
		return "showAll";
		
	}
	
	
	
}
