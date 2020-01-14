package com.lti.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Department;
import com.lti.model.Employee;

public class Main_1 {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	static {
		factory = Persistence.createEntityManagerFactory("JPA_PU");
		entityManager = factory.createEntityManager();
	}

	public static void main(String[] args) {

		loadData();	

		String name = "Harry";
		String jpql = "SELECT e from Employee e where e.employeeName = :name";
		TypedQuery<Employee> typedQuery = entityManager.createQuery(jpql,Employee.class);
		typedQuery.setParameter("name",name);
		List<Employee> employees = typedQuery.getResultList();
		
		System.out.println("List All Employees with given name");
		for(Employee e: employees) {
			System.out.println("EmployeeId: " + e.getEmployeeId());
			System.out.println("EmployeeName: " + e.getEmployeeName());
			System.out.println("EmployeeSalary: " + e.getEmployeeSalary());
			System.out.println("DepartmentId: " + e.getDepartment().getDepartmentId());
			System.out.println("Department Name: " + e.getDepartment().getDepartmentName());
//			System.out.println("Department City: " + e.getDepartment().getCity());
			System.out.println("-----------------------------");
		}
	}

	public static void loadData() {

		
		entityManager.getTransaction().begin();

		Department dept1 = new Department(10, "Development");
		Employee emp1 = new Employee(121, "Harry", 2300);
		Employee emp2 = new Employee(145, "Richie", 234577);
		emp1.setDepartment(dept1);
		emp2.setDepartment(dept1);
		Set<Employee> emps = new HashSet<>();
		emps.add(emp1);
		emps.add(emp2);
		dept1.setEmployees(emps);

		Department dept2 = new Department(13, "Manager");
		Employee emp3 = new Employee(102, "Harry", 23455);
		Employee emp4 = new Employee(134, "Scoobie", 45678);
		emp3.setDepartment(dept2);
		emp4.setDepartment(dept2);
		Set<Employee> emps1 = new HashSet<>();
		emps1.add(emp3);
		emps1.add(emp4);
		dept2.setEmployees(emps1);

		entityManager.persist(dept1);
		entityManager.persist(dept2);

		entityManager.getTransaction().commit();

//		entityManager.close();
//		factory.close();

	}
}
