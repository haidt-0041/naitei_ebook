package app.service;

import java.util.List;


import app.model.User;

public interface UserService extends BaseService<Integer, User> {

	List<User> searchUsers(String query);

	List<User> loadUsers();
}