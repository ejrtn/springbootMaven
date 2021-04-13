package com.example.demo.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;

@Repository
public class UserDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String MAPPER_NM = "com.example.demo.mapper.user";

	public List<UserDto> getUserInfo(String id) {
        return sqlSessionTemplate.selectList(MAPPER_NM+".getUserInfo",id);
	}
	public List<UserDto> getUserInfo(UserDto dto) {
        return sqlSessionTemplate.selectList(MAPPER_NM+".login",dto);
	}
	public void setUser(UserDto dto) {
		sqlSessionTemplate.insert(MAPPER_NM+".setUser",dto);
	}
	public void updateUser(UserDto dto) {
		sqlSessionTemplate.update(MAPPER_NM+".updateUser",dto);
	}
	public List<UserDto> id_find(UserDto dto){
		return sqlSessionTemplate.selectList(MAPPER_NM+".id_find",dto);
	}
	public List<UserDto> pw_find(UserDto dto){
		return sqlSessionTemplate.selectList(MAPPER_NM+".pw_find",dto);
	}
	public void pwupdate(UserDto dto) {
		sqlSessionTemplate.update(MAPPER_NM+".pwupdate",dto);
	}
}
