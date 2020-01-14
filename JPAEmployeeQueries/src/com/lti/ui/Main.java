package com.lti.ui;

import java.util.List;
import java.util.Scanner;

import com.lti.model.Employee;
import com.lti.service.EmployeeService;
import com.lti.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();

		Scanner scan = new Scanner(System.in);

		System.out.println("1.Find All Employees");
		System.out.println("2.find Employee By Salary");
		System.out.println("3. Find Employee By DeptID");
		System.out.println("4. Find Employee By DepartmenttName");
		System.out.println("5. Get Employees with salary greater than someone");
		System.out.println("0. Exit");
		

		int ch = scan.nextInt();
		List<Employee> employees;
		boolean flag = true;
//		do{
			switch (ch) {
			case 1:
				employees = employeeService.findAllEmployees();
				displayEmployees(employees);
				break;
			case 2:
				System.out.println("Enter Salary: ");
				double sal=scan.nextDouble();
				employees=employeeService.findAllEmployeeBySalary(sal);
				displayEmployees(employees);
				break;
			case 3:
				System.out.println("Enter deptId");
				int id=scan.nextInt();
				employees=employeeService.findEmployeesByDeptId(id);
				displayEmployees(employees);
				break;
			case 4:
				System.out.println("Enter department Name");
				String name=scan.next();
				employees=employeeService.findEmployeesByDeptName(name);
				displayEmployees(employees);
				break;
				
			case 5:
				System.out.println("Enter EmpName");
				String empName=scan.next();
				employees=employeeService.findEmployeesByEmpSal(empName);
				displayEmployees(employees);
				break;
			case 0:
				flag = false;
			}
//		}while(flag);
		System.out.println("------------This is the end-----------");
		System.out.println("---------Hold your breath and count to 10-------");
		scan.close();
	}

	public static void displayEmployees(List<Employee> employees) {
		System.out.println(employees.size());
		for (Employee e : employees) {
			System.out.println("Employee Id " + e.getEmployeeId());
			System.out.println("Employee Name " + e.getEmployeeName());
			System.out.println("Employee Salary " + e.getEmployeeSalary());
			if(e.getDepartment() != null){
				System.out.println("Department Id " + e.getDepartment().getDepartmentId());
				System.out.println("Department Name " + e.getDepartment().getDepartmentName());
			}
			System.out.println("--------------------");
		}

	}

}
