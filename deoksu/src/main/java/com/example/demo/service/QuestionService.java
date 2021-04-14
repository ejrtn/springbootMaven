package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.dto.QuestionDto;

@Service
public class QuestionService {

	@Autowired
	QuestionDao dao;
	
	public HashMap<Integer, Object> listAll(QuestionDto dto,String type) {
		HashMap<Integer, Object> map = new HashMap<Integer, Object>();
		List<QuestionDto> arr=null;
		if(type != null)
			arr = dao.search(dto,type);
		else
			arr = dao.selectAll(dto);
		for(int i=0;i<arr.size();i++) {
			map.put(i, arr.get(i));
		}
		return map;
	}
	public void insert(QuestionDto dto) {
		dao.insert(dto);
	}
	public void update(QuestionDto dto) {
		dao.update(dto);
	}
}
