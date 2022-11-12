package dao;

import java.util.List;

import dto.Cart;
import dto.Item;
//import dto.Cart;
import dto.Review;

public interface ItemDao {
	public Item getItem(Integer item);
	public List<Review> getReview(Integer item);
	public void setCart(Cart cart);
	public List<Item> selectItem();
	public List<Item> selectItemByCategory(String category);
	public List<Item> selectItemByOrder(String order);
	public List<Item> selectItemByCategoryAndOrder(String category, String order);
	public List<Item> selectItemByKeyword(String keyword);
}
