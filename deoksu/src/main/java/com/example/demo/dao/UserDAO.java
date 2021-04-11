package com.example.demo.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public String getUserInfo(String id) {
        return sqlSessionTemplate.selectOne("UserMapper.getUserInfo",id);
	}
	public void setUser(UserDTO dto) {
		sqlSessionTemplate.insert("UserMapper.setUser",dto);
	}
	
}
