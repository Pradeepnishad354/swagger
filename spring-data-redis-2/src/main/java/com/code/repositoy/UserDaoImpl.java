package com.code.repositoy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.code.model.User;


@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
private RedisTemplate redisTemplate;
	
	private static final String  KEY= "User";
	
	@Override
	public boolean saveUser(User user) {
		
		try {
			redisTemplate.opsForHash().put(KEY,user.getId(),user);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public List<User> fetchAllUser() {
		List<User> users;
		
		users=redisTemplate.opsForHash().values(KEY);
		return users;
	}

	@Override
	public User fetchUserById(Long id) {
		User user;
	user=(User) redisTemplate.opsForHash().get(KEY,id);
		return user;
	}

	@Override
	public boolean deleteUser(Long id) {
	try {
		
		redisTemplate.opsForHash().delete(KEY,id);;
		return true;
	}catch(Exception e) {
		e.printStackTrace();
		return false;
	}
		
	}

	@Override
	public boolean updateUser(Long id, User user) {
		try {
			redisTemplate.opsForHash().put(KEY, id, user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

}
