package com.example.demo.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mail {

    @Autowired
    private JavaMailSender emailSender;

    public String sendSimpleMessage(String to) {
    	String key=key();
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("ejrtn153@gamil.com");
        message.setTo(to); 
        message.setSubject("제목"); 
        message.setText("내용");
        emailSender.send(message);
        return key;
    }
    
    public String key() {
    	Random ran = new Random();
    	ArrayList<String> arr = new ArrayList<String>();
    	String[] a = "qwertyuiopasdfghjklzxcvbnm".split("");
    	String r="";
    	for(int i=0;i<10+a.length;i++) {
    		if(i<10) {
    			arr.add(String.valueOf(i));
    		}else {
    			arr.add(a[i-10]);
    		}
    	}
    	for(int i=0;i<8;i++) {
    		
    		r+=arr.get(ran.nextInt(10+a.length));
    	}
    	return r;
    }
}