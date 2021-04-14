package com.example.demo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.QuestionDto;

@Repository
public class QuestionDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String MAPPER_NM = "com.example.demo.mapper.question";
	
	public List<QuestionDto> selectAll(QuestionDto dto){
		return sqlSessionTemplate.selectList(MAPPER_NM+".selectAll",dto);
	}
	public List<QuestionDto> search(QuestionDto dto,String type){
		return sqlSessionTemplate.selectList(MAPPER_NM+".search_"+type,dto);
	}
	public void insert(QuestionDto dto){
		sqlSessionTemplate.insert(MAPPER_NM+".insert",dto);
	}
	public void update(QuestionDto dto) {
		System.out.println(dto.getBno());
		sqlSessionTemplate.update(MAPPER_NM+".update",dto);
	}
	
}
