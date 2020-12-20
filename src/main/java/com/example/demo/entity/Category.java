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
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categories", orphanRemoval = true)
	private Set<Book> books = new HashSet<>();

	public Category(String name) {
		this.name = name;
	}

}
