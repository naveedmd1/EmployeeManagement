package net.mspiders.Springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mspiders.Springboot.exception.ResourceNotFoundException;
import net.mspiders.Springboot.model.Employee;
import net.mspiders.Springboot.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> GetAllEmp() 
	{
		return repo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) 
	{
		Employee savedEmployee = repo.save(employee);
		return savedEmployee;
	}

	@Override
	public Employee getEmpbyid(Long id) 
	{
		Employee emp=repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exits with id:"+id));
		return emp;
	}

	@Override
	public Employee update(Long id, Employee emp) 
	{
		return repo.findById(id).map(record ->{record.setFirstName(emp.getFirstName());
			record.setLastName(emp.getLastName());
			record.setEmailid(emp.getEmailid());
			Employee update=repo.save(record);
			return update;
		}).orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with id:"+id));
	}

	@Override
	public void deletebyid(Long id) 
	{
		Employee emp=repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exits with id:"+id));
		repo.delete(emp);
		
	}

	
	
	
}
