package com.example.demo.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.SudokuService;

@Controller
public class SudokuController {
	
	@Autowired
	private SudokuService sudokuservice;

	@RequestMapping(value = "Allreset", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String Allreset(@RequestParam int count, HttpServletRequest request, HttpServletResponse response) {
		return sudokuservice.Allreset(count,request,response);
	}
	
	@RequestMapping(value = "number_click", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public void number_click(@RequestParam String pad, HttpServletRequest request, HttpServletResponse response) {
		sudokuservice.number_click(pad, request, response);
	}
	
	@RequestMapping(value = "sudoku")
	public String sudoku(Locale locale, Model model, HttpServletRequest request) {
		sudokuservice.start(locale, model, request);
		return "sudoku";
	}
}
