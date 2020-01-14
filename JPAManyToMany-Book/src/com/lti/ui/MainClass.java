package com.lti.ui;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Authors;
import com.lti.model.Books;

public class MainClass {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	static {
		factory = Persistence.createEntityManagerFactory("JPA_PU");
		entityManager = factory.createEntityManager();
	}

	public static void main(String[] args) {

		loadData();	
	}

	public static void loadData() {
		Books book1 = new Books(1, "Wings Of Fire", 299.78);
		Books book2 = new Books(3, "Goblet of Fire", 450.34);

		Authors author1 = new Authors(10, "A.P.J Abdul Kalam");
		Authors author2 = new Authors(15, "J.K.Rowling");
		Authors author3 = new Authors(34, "Simran Gupta");
		Authors author4 = new Authors(46, "James Gosling");

		Set<Authors> list1 = new HashSet<>();
		list1.add(author1);
		list1.add(author2);
		list1.add(author3);
		book1.setAuthors(list1);

		Set<Authors> list2 = new HashSet<>();
		list2.add(author3);
		list2.add(author4);
		book2.setAuthors(list2);

		entityManager.getTransaction().begin();
		entityManager.persist(book1);
		entityManager.persist(book2);

		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();

	}
}
