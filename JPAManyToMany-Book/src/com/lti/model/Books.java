package com.lti.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {
	@Id
	@Column(name="book_id")
	private int isbn;
	@Column(name="book_title")
	private String title;
	@Column(name="book_price")
	private double price;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="book_author",
				joinColumns={@JoinColumn(name="book_isbn")},
				inverseJoinColumns={@JoinColumn(name="author_id")}
			)
	private Set<Authors> authors;

	public Books() {
		super();
	}

	public Books(int isbn, String title, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Authors> authors) {
		this.authors = authors;
	}

}
