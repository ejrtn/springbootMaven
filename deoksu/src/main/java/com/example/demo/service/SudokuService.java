package com.example.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.utils.CookieUtils;
import com.example.demo.utils.Numbergeneration;

@Service
public class SudokuService {
	
	Numbergeneration numbergeneration = new Numbergeneration();
	
	CookieUtils cookieutils = new CookieUtils();
	
	public String Allreset(int count, HttpServletRequest request, HttpServletResponse response) {
		String num=numbergeneration.SudokuPrint(count);
		try {
			cookieutils.createNewCookie("text1", num, 7, request, response);
			cookieutils.createNewCookie("text1_reset", num, 7, request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	public void number_click(@RequestParam String pad, HttpServletRequest request, HttpServletResponse response) {
		try {
			cookieutils.createNewCookie("text1", pad, 7, request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String start(HttpServletRequest request) {
		try {
			String number = cookieutils.getValue("text1", request);
			cookieutils.getValue("text1_reset", request);
			if (number!=null) {
				return number;
			}else {
				return "000000000/000000000/000000000/000000000/000000000/000000000/000000000/000000000/000000000";
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
