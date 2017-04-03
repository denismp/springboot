package com.example.entity;

import java.io.Serializable;

public interface BookInterface extends Serializable{
	/**
	 * @return the id
	 */
	public Long getId();

	/**
	 * @param id the id to set
	 */
	public void setId(Long id);
	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name the name to set
	 */
	public void setName(String name);

	/**
	 * @return the authorId
	 */
	public Long getAuthorId();

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Long authorId);
}
