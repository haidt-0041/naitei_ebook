package app.service;

import java.util.List;

import app.model.User;

public interface UserService extends BaseService<Integer, User> {
	boolean deleteUser(Integer id);

	List<User> searchUsers(String query);

	List<User> loadUsers();

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);
}