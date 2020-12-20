package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "isbn", length = 50, nullable = false, unique = true)
	private String isbn;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "price", length = 8)
	private int price;

	@Column(name = "pages", length = 4)
	private int pages;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "books_authors", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	private Author authors;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "books_categories", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	private Category categories;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "books_publishers", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "publisher_id") })
	private Publisher publishers;

	public Book(String isbn, String name, int price, int pages) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.pages = pages;
	}

	public void addAuthors(Author author) {
		this.authors = author;
		author.getBooks().add(this);
	}

	public void removeAuthors(Author author) {
		this.authors = null;
		author.getBooks().remove(this);
	}

	public void addCategories(Category category) {
		this.categories = category;
		category.getBooks().add(this);
	}

	public void removeCategories(Category category) {
		this.categories = category;
		category.getBooks().remove(this);
	}

	public void addPublishers(Publisher publisher) {
		this.publishers = publisher;
		publisher.getBooks().add(this);
	}

	public void removePublishers(Publisher publisher) {
		this.publishers = publisher;
		publisher.getBooks().remove(this);
	}
}
