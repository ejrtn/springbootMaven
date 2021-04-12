package com.example.demo.utils;

import java.util.ArrayList;
import java.util.Random;

public class EmailKey {
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
