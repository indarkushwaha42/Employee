package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepo EmployeeRepo;
	

	public EmployeeServiceImpl(com.example.demo.Repo.EmployeeRepo employeeRepo) {
		super();
		EmployeeRepo = employeeRepo;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return EmployeeRepo.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return EmployeeRepo.findAll();
	}


	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return EmployeeRepo.findById(id).orElseThrow();
	}


	@Override
	public Employee updatEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		Employee existingEmployee = EmployeeRepo.findById(id).orElseThrow();
				existingEmployee.setDesi(employee.getDesi());
		existingEmployee.setName(employee.getName());
		existingEmployee.setSal(employee.getSal());
		EmployeeRepo.save(existingEmployee);
		
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		EmployeeRepo.findById(id).orElseThrow();
		EmployeeRepo.deleteById(id);
		
	}
	

}
