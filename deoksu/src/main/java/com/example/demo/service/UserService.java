package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.utils.EmailKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;
	
	@Autowired
    private JavaMailSender JavaMailSender;
	
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
	
	public String email(String email,String ty) {
    	String key=new EmailKey().key();
    	MimeMessage message = JavaMailSender.createMimeMessage();
    	String title;
    	String text;
    	try {
    		if(!ty.equals("pw")) {
    			title="spring boot Maven project 인증키";
    			text="이메일 인증키 : ";
    		}else {
    			title="spring boot Maven project 임시 비밀번호";
    			text="임시 비밀번호";
    		}
			message.setSubject("spring boot Maven project 인증키");
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
	    	message.setText("이메일 인증키 : "+key);
	    	JavaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return key;
	}
	
	public String id_find(UserDto dto){
		List<UserDto> s = userdao.id_find(dto);
		if(s.size()!=0) {
			return s.get(0).getId();
		}else {
			return "존재하지 않습니다.";
		}
		
	}
	
	public String pw_find(UserDto dto){
		List<UserDto> s = userdao.pw_find(dto);
		if(s.size()!=0) {
			dto.setPw(sha256(email(dto.getEmail(),"pw")));
			userdao.pwupdate(dto);
			return "임시비밀번호 발송";
		}else {
			return "존재하지 않습니다.";
		}
	}
    
}