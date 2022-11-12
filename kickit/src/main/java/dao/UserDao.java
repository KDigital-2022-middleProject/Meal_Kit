package dao;

import dto.User;

public interface UserDao {
	
	public void insert(User user);
	public User selectOne(String email);
}
