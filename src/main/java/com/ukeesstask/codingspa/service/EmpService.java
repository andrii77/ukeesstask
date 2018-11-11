package com.ukeesstask.codingspa.service;

import org.springframework.data.domain.Page;
import com.ukeesstask.codingspa.domain.Employee;

public interface EmpService {
	
	Iterable<Employee> getAllEmployees(int pageNumber);
	
	Page<Employee> findByempNameStartingWith(String startWith, int pageNumber);
	
	void storeOrUpdateEmployee(Employee employee);
	
	void removeEmployeeById(int employeeId);

}
