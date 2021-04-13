package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "idcheck", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idcheck(UserDto dto, HttpServletRequest request, HttpServletResponse response) {
		if(userService.getUserInfo(dto.getId()).size()==0)
			return "";
		else
			return dto.getId(); 
	}
	
	@RequestMapping(value = "joinok", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public void joinok(UserDto dto,  HttpServletRequest request, HttpServletResponse response) {
		userService.setUser(dto);
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String login(UserDto dto, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		String result = userService.getUserInfo(dto);
		session.setAttribute("id", result);
		return result;
	}
	
	@RequestMapping(value = "myinfo", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String myinfo(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		List<UserDto> r = userService.getUserInfo(String.valueOf(session.getAttribute("id")));
		return r.get(0).getName()+"/"+r.get(0).getId()+"/"+r.get(0).getEmail();
	}
	
	@RequestMapping(value = "myinfochange", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String myinfochange(UserDto dto,@RequestParam String repw, HttpServletRequest request, HttpServletResponse response) {
		return userService.updateUser(dto,repw);
	}
	
	@RequestMapping(value = "email", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String email(@RequestParam String email, HttpServletRequest request, HttpServletResponse response) {
		return userService.email(email,"key");
	}
	
	@RequestMapping(value = "find", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String find(UserDto dto, @RequestParam String type, HttpServletRequest request, HttpServletResponse response) {
		if(type.equals("id")) {
			return userService.id_find(dto);
		}else {
			return userService.pw_find(dto);
		}
	}
}
