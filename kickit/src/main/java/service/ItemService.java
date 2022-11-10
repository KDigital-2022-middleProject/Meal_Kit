package service;

import java.util.List;

import dto.Item;

public interface ItemService {
	
	public List<Item> getItemAll();
	public List<Item> getItemByCategory(String category);
}
