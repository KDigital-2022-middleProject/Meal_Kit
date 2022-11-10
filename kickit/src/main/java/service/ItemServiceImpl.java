package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dto.Item;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> getItemAll() {
		return itemDao.selectAll();
	}
	
	@Override
	public List<Item> getItemByCategory(String category){
		return itemDao.selectByCategory(category);
	}
	
}
