/**
 * 
 */
package com.example.service;

import static org.junit.Assert.*;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.entity.User;

/**
 * @author denisputnam
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@SuppressWarnings("unused")
	private final Logger log = Logger.getLogger (this.getClass());
	
	@Autowired
	private UserService userService;
	
	private User user;

	/**
	 * Test method for {@link com.example.service.UserService#findAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAll() throws Exception {
		this.user = this.userService.create("bogus@bogus.com", "bogus");
		final List<User> users = (List<User>) this.userService.findAll();
		this.userService.delete(this.user.getId());
		Assert.notEmpty(users, "Found no users.");	
	}

	/**
	 * Test method for {@link com.example.service.UserService#findOne(long)}.
	 */
	@Test
	public void testFindOne() {
		try{
			this.user = this.userService.create("bogus@bogus.com", "bogus");
			User user  = this.userService.findOne(this.user.getId());
			if( user == null ){
				user = this.userService.delete(this.user.getId());
				fail("findOne(): failed.");
			}else{
				user = this.userService.delete(this.user.getId());	
			}
		}catch( Exception e ){
			e.printStackTrace();
			fail("testFindOne(): failed.");
		}
	}

	/**
	 * Test method for {@link com.example.service.UserService#getByEmail(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetByEmail() {		
		try {
			this.user = this.userService.create("bogus@bogus.com", "bogus");
			User user = this.userService.getByEmail("bogus@bogus.com");
			user = this.userService.delete(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getByMail(): failed.");
		}
	}

	/**
	 * Test method for {@link com.example.service.UserService#create(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreate() {
		try {
			User user = this.userService.create("bogus2@bogus.com", "bogus2");
			this.userService.delete(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("create(): failed.");
		}
	}

	/**
	 * Test method for {@link com.example.service.UserService#updateUser(long, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUpdateUser() {
		try {
			this.user = this.userService.create("bogus@bogus.com", "bogus");
			User user = this.userService.updateUser(this.user.getId(), this.user.getName(), "updated-email-" + this.user.getEMail());
			user = this.userService.delete(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail( "updateUser(): failed");
		}
	}

	/**
	 * Test method for {@link com.example.service.UserService#delete(long)}.
	 */
	@Test
	public void testDelete() {
		//fail("NOT now.");
		try {
			User user = this.userService.create("delete@me.com", "delete");
			user = this.userService.delete(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("delete() failed.");
		}
	}

}
