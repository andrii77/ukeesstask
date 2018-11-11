package com.ukeesstask.codingspa.repo;

import com.ukeesstask.codingspa.domain.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer>{
		
	public Page<Employee> findByempNameStartingWith(String searchTerm, Pageable p);
	
	
}
