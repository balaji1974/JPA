package aero.alsalam.jpainheritancesamples.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FulltimeEmployee extends Employee{

	private BigDecimal salary;

	public FulltimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	protected FulltimeEmployee() {
		
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	
	
}
