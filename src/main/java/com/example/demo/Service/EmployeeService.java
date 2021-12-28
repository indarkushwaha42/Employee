package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee updatEmployee(Employee employee,int id);
	void deleteEmployee(int id);

}
