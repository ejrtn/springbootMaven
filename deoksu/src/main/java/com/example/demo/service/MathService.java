package com.example.demo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class MathService {
	
	public String Random_number(int cnt) {
		Random ran = new Random();
		String num1="";
		String num2="";
		for(int i=0;i<cnt*2;i++) {
			if(i%2==0) {
				num1+=ran.nextInt(9)+1;
			}
			else {
				num2+=ran.nextInt(9)+1;
			}
		}
		return num1+","+num2;
	}
}
