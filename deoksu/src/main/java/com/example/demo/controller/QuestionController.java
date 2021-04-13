package com.example.demo.controller;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.QuestionDto;
import com.example.demo.service.QuestionService;
import com.google.gson.Gson;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	@RequestMapping(value ="question")
	public String qa() {
		return "question";
	}
	
	@RequestMapping(value = "qalistall", method = RequestMethod.POST)
	@ResponseBody
	public String qalistall(QuestionDto dto,@RequestParam(required = false)String type,HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		return gson.toJson(service.listAll(dto,type));
	}
	
	@RequestMapping("question_insert")
	public String question_insert(QuestionDto dto,HttpSession session) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		String currentDate = dateFormat.format(new Date());
		dto.setDay(currentDate);
		dto.setUserid(String.valueOf(session.getAttribute("id")));
		service.insert(dto);
		return "redirect:question";
	}
}
