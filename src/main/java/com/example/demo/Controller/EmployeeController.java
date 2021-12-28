package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
//	create api to save employee
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
//		create api to get employee
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
//	create api to get employee by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
		
//	create api for update
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updatEmployee(employee, id),HttpStatus.OK);
	}
	
//	create api for delete employee
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!",HttpStatus.OK);
	}
	
	
	

}
