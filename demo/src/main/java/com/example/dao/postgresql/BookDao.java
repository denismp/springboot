package com.example.dao.postgresql;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Book;

@Transactional
public interface BookDao extends CrudRepository<Book, Long> {
	public Book findByName( String email );
}
