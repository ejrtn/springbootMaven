package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MemorizationService;

@Controller
public class MemorizationController {
	
	@Autowired
	private MemorizationService memorization;
	
	@RequestMapping("memorization")
	public String memorization() {
		return "memorization";
	}
	
	@RequestMapping(value = "bring", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String memorization_bring(@RequestParam int cnt, @RequestParam int x, HttpServletRequest request, HttpServletResponse response) {
		return memorization.Memorization_ran(x, cnt);
	}
}
