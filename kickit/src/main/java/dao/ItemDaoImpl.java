package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.ItemMapper;
import dao.mapper.UserMapper;
import dto.Item;
import dto.User;

@Repository
public class ItemDaoImpl implements ItemDao{
	@Autowired
	private SqlSessionTemplate template;
	private Map<String,Object> param = new HashMap<>();
	
	@Override
	public List<Item> selectAll() {
		return template.getMapper(ItemMapper.class).selectAll();
	}
	
	@Override
	public List<Item> selectByCategory(String category) {
		param.clear();
		param.put("category",category);
		return template.getMapper(ItemMapper.class).selectByCategory(param);
	}
}
