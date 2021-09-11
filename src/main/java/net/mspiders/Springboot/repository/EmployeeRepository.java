package net.mspiders.Springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.mspiders.Springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
	
}
