package com.example.dao.mysql;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {
	public User findByEmail( String email );

}
