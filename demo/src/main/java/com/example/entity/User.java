package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "users")
public class User implements UserInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -507606192667894785L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String email;
	
	@NotNull
	private String name;
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public long setId(long value) {
		// TODO Auto-generated method stub
		return id = value;
	}

	@Override
	public String getEMail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public void setEmail(String value) {
		// TODO Auto-generated method stub
		email = value;

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String value) {
		// TODO Auto-generated method stub
		name = value;

	}

}
