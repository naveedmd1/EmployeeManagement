package net.mspiders.Springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.mspiders.Springboot.model.Employee;
import net.mspiders.Springboot.repository.EmployeeRepository;
import net.mspiders.Springboot.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController 
{
	
	@Autowired
	private EmployeeService emps;
	
	
	//get all employees
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getallEmployees()
	{
		List<Employee> allemp=emps.GetAllEmp();
		return new ResponseEntity<List<Employee>>(allemp,HttpStatus.OK);
	}
	
	//create employee
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee employeeSaved = emps.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}
	
	//getby id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeebyid(@PathVariable ("id") Long id)
	{
		Employee getemp=emps.getEmpbyid(id);
		return new ResponseEntity<Employee>(getemp,HttpStatus.OK);
	}
	
	//update emp by id
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") Long id,@RequestBody Employee emp)
	{
		Employee newemp=emps.update(id,emp);
		return new ResponseEntity<Employee>(newemp,HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable("id") Long id)
	{
		emps.deletebyid(id);
		Map<String, Boolean> response=new HashMap<String, Boolean>();
		response.put("deleted",Boolean.TRUE);
		return new ResponseEntity<Map<String,Boolean>>(response,HttpStatus.ACCEPTED);
	}
	
}
