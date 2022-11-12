package dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.UserMapper;
import dto.User;

@Repository
public class UserDaoImpl {
	
	@Autowired
	private SqlSessionTemplate template;
	private Map<String,Object> param = new HashMap<>();
	public void insert(User user) {
	    template.getMapper(UserMapper.class).insert(user);	
	}
	public User selectOne(String email) {
		param.clear();
		param.put("email", email);
		return template.getMapper(UserMapper.class).selectOne(param);
	}
}
