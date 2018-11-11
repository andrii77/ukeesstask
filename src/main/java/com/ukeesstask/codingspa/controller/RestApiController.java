package com.ukeesstask.codingspa.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.ukeesstask.codingspa.service.EmpService;
import com.ukeesstask.codingspa.domain.*;

@RestController
public class RestApiController {

	@Autowired
	EmpService empService;
	
	/**
	 * Returns employees located on specified page.
	 * @param page - page number
	 * @return set of employees on specified page.
	 */
	@RequestMapping(value = "/employee/{page}", method = RequestMethod.GET)
	public Iterable<Employee> getAllEmployees(@PathVariable("page") Integer page) {
		return empService.getAllEmployees(page);
	}
	
	/**
	 * Returns all employees with name which starts on "startWith" and
	 * located on specified page.
	 * @param startWith - 
	 *        employee's name should corresponds to 
	 *        the pattren: "startWith*". For example: 
	 *        if startWith = "Tom", then names like: "Tom", "Tomson", 
	 *        "Tommy" will be included into result set. Names like:
	 *        "Greattom" or "Supertom" will be not included into result set.
	 * @param page - page number of result set.
	 * @return set of emloyees which names correspond to the startWith pattern
	 *         and located on specified page.
	 */
	
	@RequestMapping(value = "/employee/search/{startWith}/{page}", method = RequestMethod.GET)
	public Iterable<Employee> findEmployee(@PathVariable("startWith") String startWith,
									       @PathVariable("page") Integer page) {
		
		return empService.findByempNameStartingWith(startWith, page);

	}
	
	/**
	 * Stores updated employee.
	 * @param employee - employee object with updated fields.
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public void updateEmployee(@RequestBody Employee employee) {
		empService.storeOrUpdateEmployee(employee);
	}
	
	/**
	 * Removes employee from the table based on its ID.
	 * @param id - ID of employee to be removed
	 */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public void removeEmployee(@PathVariable("id") Integer id) {		
		empService.removeEmployeeById(id);
	}
	
}
