package com.lti.dao;

import java.util.List;

import com.lti.model.Employee;

public interface EmployeeDao {
	public List<Employee> readAllEmployee();
	public List<Employee> readEmployeeBySalary(double salary);
	public List<Employee> readEmployeeBydeptId(int deptId);
	public List<Employee> readEmployeeByDeptName(String deptName);
	public List<Employee> readEmployeeByEmpSalary(String empName);

}
