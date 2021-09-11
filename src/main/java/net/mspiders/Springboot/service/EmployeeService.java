package net.mspiders.Springboot.service;
import java.util.List;

import net.mspiders.Springboot.model.Employee;
public interface EmployeeService 
{

	public List<Employee> GetAllEmp();

	public Employee addEmployee(Employee employee);

	public Employee getEmpbyid(Long id);

	public Employee update(Long id, Employee emp);
	
	public void deletebyid(Long id);

	
	
}
