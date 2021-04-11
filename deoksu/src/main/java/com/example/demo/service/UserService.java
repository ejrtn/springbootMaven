package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	public List<UserDto> getUserInfo(String i) {
		return userdao.getUserInfo(i);
	}
	public String getUserInfo(UserDto dto) {
		dto.setPw(sha256(dto.getPw()));
		if(userdao.getUserInfo(dto)!=null)
			return dto.getId();
		else
			return "";
	}
	
	public void setUser(UserDto dto){
        dto.setPw(sha256(dto.getPw()));
		userdao.setUser(dto);
	}
	
	public String updateUser(UserDto dto,String repw){
        dto.setPw(sha256(dto.getPw()));
		List<UserDto> r = userdao.getUserInfo(dto);
		if(r!=null) {
			dto.setPw(sha256(repw));
			userdao.updateUser(dto);
			return "성공";
		}else {
			return "실패";
		}
	}
	
	public String sha256(String text) {
//		sha-256 해시
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes());
	        
//	      바이트 >> 헥스 변환
	        StringBuilder builder = new StringBuilder();
	        for (byte b: md.digest()) {
	        	builder.append(String.format("%02x", b));
	        }
	        return builder.toString().toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	
	public String email(String email) {
		Mail mail = new Mail();
		return mail.sendSimpleMessage(email);
	}
}