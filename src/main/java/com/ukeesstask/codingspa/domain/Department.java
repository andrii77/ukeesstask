package com.ukeesstask.codingspa.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbldepartments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dptID;
	
	private String dpName;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	@JsonIgnore
	Set<Employee> employees;
	

	public Department(){}
	
	public Department(String dpName, Set<Employee> employees) {
		this.dpName = dpName;
		this.employees = employees;
	}

	public int getDptID() {
		return dptID;
	}

	public void setDptID(int dptID) {
		this.dptID = dptID;
	}

	public String getDpName() {
		return dpName;
	}

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}
