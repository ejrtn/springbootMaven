package com.example.demo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class MemorizationService {
	public String Memorization_ran(int x, int cnt) {
		Random random = new Random();
		String r="";
		for(int i=0;i<cnt;i++) {
			r+=random.nextInt(x);
			r+=",";
		}
		return r;
	}
}
