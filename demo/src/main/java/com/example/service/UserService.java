package com.example.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;

@Service("userService")
public class UserService {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@Autowired UserDao userDao;
	
	public List<User> findAll(){
		return (List<User>) userDao.findAll();
	}
	
	public User findOne( long id ){
		return userDao.findOne(id);
	}
	
	public User getByEmail(String email) throws Exception{
		
		String userId = null;
		User user = null;
		try{
			user = userDao.findByEmail(email);
			userId = String.valueOf(user.getId());
		}catch(Exception e){
			log.error("User not found");
			e.printStackTrace();
			throw new Exception(e);
		}
		log.info("The user id is: " + userId);
		return user;		
	}
	
	public User create( String email, String name ){
		User user = null;
		try{
			user = new User();
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		}catch( Exception e ){
			log.error("Error creating the user: " + e.getMessage());
		}
		log.info("User id: " + user.getId() + " saved.");
		return user;
	}
	
	public User updateUser(long id, String email, String name ){
		User user = null;
		try{
			user = userDao.findOne(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		}catch( Exception e ){
			log.error("Error updating the user: " + e.getMessage());
		}
		return user;
	}
	
	public User delete( long id ) throws Exception{
		User user = null;

		user = userDao.findOne(id);
		userDao.delete(user);
		return user;
	}
}
