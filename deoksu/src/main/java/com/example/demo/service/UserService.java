package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public String getUserInfo(String i) {
		return userDAO.getUserInfo(i);
	}
	
	public void setUser(UserDTO dto) {
		userDAO.setUser(dto);
	}
}