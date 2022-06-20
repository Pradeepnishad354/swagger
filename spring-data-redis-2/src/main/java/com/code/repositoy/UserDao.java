package com.code.repositoy;

import java.util.List;

import com.code.model.User;

public interface UserDao {

	boolean saveUser(User user);

	List<User> fetchAllUser();

	User fetchUserById(Long id);

	boolean deleteUser(Long id);

	boolean updateUser(Long id, User user);

}
