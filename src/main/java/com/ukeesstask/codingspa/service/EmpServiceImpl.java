package com.ukeesstask.codingspa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ukeesstask.codingspa.domain.Employee;
import com.ukeesstask.codingspa.repo.EmpRepository;


@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpRepository empRepository;
	
	public static int numberOfEmployeesPerPage = 5; 	
		
	@Override
	public Iterable<Employee> getAllEmployees(int pageNumber) {		
		Pageable page = PageRequest.of(pageNumber, numberOfEmployeesPerPage);		
		return empRepository.findAll(page);
	
	}
		
	@Override
	public Page<Employee> findByempNameStartingWith(String startWith, int pageNumber) {		
		Pageable pageable = PageRequest.of(pageNumber, numberOfEmployeesPerPage);		
		return empRepository.findByempNameStartingWith(startWith, pageable);
	}

	@Override
	public void storeOrUpdateEmployee(Employee employee) {
		empRepository.save(employee);		
	}
	

	@Override
	public void removeEmployeeById(int employeeId) {
		empRepository.deleteById(employeeId);
		
	}
	
	

}
