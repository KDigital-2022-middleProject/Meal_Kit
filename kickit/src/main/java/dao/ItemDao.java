package dao;

import java.util.List;

import dao.mapper.ItemMapper;
import dto.Item;

public interface ItemDao {
	public List<Item> selectAll();
	public List<Item> selectByCategory(String category);
}
