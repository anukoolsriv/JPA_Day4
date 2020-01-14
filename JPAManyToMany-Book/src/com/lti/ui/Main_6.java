package com.lti.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Authors;
import com.lti.model.Books;

public class Main_6 {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	static {
		factory = Persistence.createEntityManagerFactory("JPA_PU");
		entityManager = factory.createEntityManager();
	}

	public static void main(String[] args) {

		loadData();
		int num = 10;
		String jpql = "select a from Authors a join a.books b where b.isbn =" + num;
//		String tq1 = "select distinct b from Books b join Authors auth where auth.name = :name";
		TypedQuery<Authors> typedQuery = entityManager.createQuery(jpql, Authors.class);
		//typedQuery.setParameter("nu", arg1)
		List<Authors> authors = typedQuery.getResultList();
		
		System.out.println("Query All Books written by given author name");
//		for(Books b: books){
//			System.out.println("Books Id: "+ b.getIsbn());
//			System.out.println("Book Title: " + b.getTitle());
//			System.out.println("Book Price: " + b.getPrice());
//			Set<Authors> authors = b.getAuthors();
			
			for(Authors a: authors){
				System.out.println("Author Id: " + a.getId());
				System.out.println("Author Name: " + a.getName());
			}
			System.out.println("----------------------------------");
		
		entityManager.close();
		factory.close();
	}

	public static void loadData() {
		Books book1 = new Books(1, "Wings Of Fire", 299.78);
		Books book2 = new Books(3, "Goblet of Fire", 750.34);

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

	}
}
