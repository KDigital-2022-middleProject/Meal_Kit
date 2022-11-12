package service;

import dto.User;

public interface UserService {
	public void userInsert(User user);
	public User getUser(String email);
}
