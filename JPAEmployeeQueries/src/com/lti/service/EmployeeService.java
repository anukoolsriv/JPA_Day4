package com.lti.service;

import java.util.List;

import com.lti.model.Employee;

public interface EmployeeService {
	public List<Employee> findAllEmployees();
	public List<Employee> findAllEmployeeBySalary(double salary);
	public List<Employee> findEmployeesByDeptId(int deptId);
	public List<Employee> findEmployeesByDeptName(String deptName);
	public List<Employee> findEmployeesByEmpSal(String empName);
}
