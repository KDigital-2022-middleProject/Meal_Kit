package service;

import java.util.List;

import dto.Cart;
import dto.Item;
import dto.Review;

public interface ItemService {
	
	public List<Item> getItem();
	public List<Item> getItem(String category);
	public List<Item> getItem(String category, String Order);
	public List<Item> getItemByOrder(String order);
	public List<Item> getItemByKeyword(String keyword);
	public Item getItem(Integer item);
	public List<Review> getReview(Integer item);
	public void setCart(Cart cart);
}
