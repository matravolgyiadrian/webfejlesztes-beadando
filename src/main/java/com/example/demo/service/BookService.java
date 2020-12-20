package com.example.demo.service;


import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {

	public List<Book> findAllBooks();
	
	public Book findBookById(Long id);

	public void createBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(Long id);

}
