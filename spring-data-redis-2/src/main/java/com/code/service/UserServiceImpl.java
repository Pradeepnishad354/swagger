package com.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.model.User;
import com.code.repositoy.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean saveUser(User user) {
		
		return userDao.saveUser(user);
	}
	
	@Override
	public List<User> fetchAllUser() {
		// TODO Auto-generated method stub
		return userDao.fetchAllUser();
				
	}
	
	@Override
	public User fetchUserById(Long id) {
		
		return userDao.fetchUserById(id);
	}
	
	@Override
	public boolean deleteUser(Long id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}
	
	
	@Override
	public boolean updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(id,user);
	}

}
