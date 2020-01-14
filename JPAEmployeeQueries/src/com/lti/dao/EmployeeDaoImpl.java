package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lti.model.Employee;
import com.lti.utils.JpaUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	private EntityManager entityManager;
	private final static String GET_ALL_EMPLOYEES = "Select e from Employee e";
	private final static String GET_EMPLOYEES_BY_SALARY = "Select e from Employee e where e.employeeSalary > :salary";
	private final static String GET_EMPLOYEES_BY_ID="Select e from Employee e join e.department dept where dept.departmentId = :deptId";
	private final static String GET_EMPLOYEES_BY_NAME="Select e from Employee e join e.department dept where dept.departmentName = :deptName";
	private final static String EMPLOYEE_SAL_GT_EMP="Select e from Employee e where e.employeeSalary >ALL (Select e1.employeeSalary from Employee e1 where e1.employeeName = :empName)";
	public EmployeeDaoImpl() {
		entityManager = JpaUtils.getEntityManager();
	}

	@Override
	public List<Employee> readAllEmployee() {
		TypedQuery<Employee> typedQuery = entityManager.createQuery(GET_ALL_EMPLOYEES, Employee.class);
		List<Employee> result = typedQuery.getResultList();
		return result;
	}

	@Override
	public List<Employee> readEmployeeBySalary(double salary) {
		TypedQuery<Employee> typedQuery = entityManager.createQuery(GET_EMPLOYEES_BY_SALARY, Employee.class);
		typedQuery.setParameter("salary", salary);
		List<Employee> result = typedQuery.getResultList();
		return result;
	}

	@Override
	public List<Employee> readEmployeeBydeptId(int deptId) {
	TypedQuery<Employee> tQuery=entityManager.createQuery(GET_EMPLOYEES_BY_ID,Employee.class);
	tQuery.setParameter("deptId", deptId);
	List<Employee> result=tQuery.getResultList();
		return result;
	}

	@Override
	public List<Employee> readEmployeeByDeptName(String deptName) {
		TypedQuery<Employee> tquery=entityManager.createQuery(GET_EMPLOYEES_BY_NAME,Employee.class);
		tquery.setParameter("deptName", deptName);
		List<Employee> result=tquery.getResultList();
		return result;
	}

	@Override
	public List<Employee> readEmployeeByEmpSalary(String empName) {
		TypedQuery<Employee> tquery=entityManager.createQuery(EMPLOYEE_SAL_GT_EMP,Employee.class);
		tquery.setParameter("empName", empName);
		List<Employee> result=tquery.getResultList();
		return result;
	}

}
