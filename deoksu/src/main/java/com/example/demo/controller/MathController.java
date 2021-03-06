package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MathService;

@Controller
public class MathController {
	
	@Autowired
	private MathService random_number;
	
	@RequestMapping(value = "math")
	public String math() {
		return "math";
	}
	
	@RequestMapping(value = "number", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String number(@RequestParam int cnt, HttpServletRequest request, HttpServletResponse response) {
		String r =  random_number.Random_number(cnt);
		return r;
	}
}
