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
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "authors", orphanRemoval = true)
	private Set<Book> books = new HashSet<>();

	public Author(String name) {
		this.name = name;
	}

}
