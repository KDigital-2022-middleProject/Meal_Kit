package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dto.Cart;
import dto.Item;
import dto.Review;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao itemDao;

	@Override
	public List<Item> getItem() {
		// TODO Auto-generated method stub
		return itemDao.selectItem();
	}

	@Override
	public List<Item> getItem(String category) {
		// TODO Auto-generated method stub
		return itemDao.selectItemByCategory(category);
	}
	
	@Override
	public List<Item> getItem(String category, String Order) {
		// TODO Auto-generated method stub
		return itemDao.selectItemByCategoryAndOrder(category, Order);
	}

	@Override
	public List<Item> getItemByOrder(String order) {
		// TODO Auto-generated method stub
		return itemDao.selectItemByOrder(order);
	}

	@Override
	public List<Item> getItemByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return itemDao.selectItemByKeyword(keyword);
	}

	public Item getItem(Integer item) {
		// TODO Auto-generated method stub
		return itemDao.getItem(item);
	}

	@Override
	public List<Review> getReview(Integer item) {
		// TODO Auto-generated method stub
		return itemDao.getReview(item);
	}

	public void setCart(Cart cart) {
		// TODO Auto-generated method stub
	itemDao.setCart(cart);
	}



}
