package com.ukeesstask.codingspa.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tblemployees")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empID;
	private String empName;
	
	private String empActive;
	
	@ManyToOne
    @JoinColumn(name = "emp_dptID", nullable = false)
	private Department department;
	
	public Employee(){}	
		
	public Employee(String empName, String empActive,
			Department department) {

		this.empName = empName;
		this.empActive = empActive;
		this.department = department;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpActive() {
		return empActive;
	}

	public void setEmpActive(String empActive) {
		this.empActive = empActive;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}	

}
