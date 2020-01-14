package com.lti.service;

import java.util.List;

import com.lti.dao.EmployeeDao;
import com.lti.dao.EmployeeDaoImpl;
import com.lti.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> result=employeeDao.readAllEmployee();
		return result;
	}

	@Override
	public List<Employee> findAllEmployeeBySalary(double salary) {
		return employeeDao.readEmployeeBySalary(salary);
	}

	@Override
	public List<Employee> findEmployeesByDeptId(int deptId) {
		
		return employeeDao.readEmployeeBydeptId(deptId);
	}

	@Override
	public List<Employee> findEmployeesByDeptName(String deptName) {
		return employeeDao.readEmployeeByDeptName(deptName);
	}

	@Override
	public List<Employee> findEmployeesByEmpSal(String empName) {
		return employeeDao.readEmployeeByEmpSalary(empName);
	}

}
