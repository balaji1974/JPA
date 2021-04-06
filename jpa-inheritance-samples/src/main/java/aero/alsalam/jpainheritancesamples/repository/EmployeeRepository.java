package aero.alsalam.jpainheritancesamples.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aero.alsalam.jpainheritancesamples.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {
	
	@Autowired
	EntityManager em; 
	
	public Employee findById(Long id) {
		return em.find(Employee.class, id);
	}
	
	
	public void insert (Employee employee) {
		em.persist(employee);
	}
	
	
	public List<Employee> retrieveAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
		
		
	}
	
}
