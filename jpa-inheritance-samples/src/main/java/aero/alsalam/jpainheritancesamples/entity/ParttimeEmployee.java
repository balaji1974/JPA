package aero.alsalam.jpainheritancesamples.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class ParttimeEmployee extends Employee{

	private BigDecimal hourlyRate;

	
	public ParttimeEmployee(String name, BigDecimal hourlyRate) {
		super(name);
		this.hourlyRate = hourlyRate;
	}

	protected ParttimeEmployee() {
		
	}

	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	
	
	
	
}
