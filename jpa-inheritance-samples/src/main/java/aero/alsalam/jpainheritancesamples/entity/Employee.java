package aero.alsalam.jpainheritancesamples.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity

//This will make all subclasses into a single table 
// It has a field called DType which tells what type of employee is being stored
//@Inheritance 
// This will give a name to the DType column that is being created in the single table configuration 
//@DiscriminatorColumn(name="EmployeeType")


// Not advisable as common columns is repeated in each table as this duplicates in all the inheritance tables 
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

// This is my ideal way as it created common table for super class data and individual tables for subclass data 
@Inheritance(strategy=InheritanceType.JOINED)

// @Mappedsuperclass is the final way which is inefficient and I am not even considering asit is the same as the first type 
// that was used with single table per class but I cannot refer my queries with the super class but only sub class queries are possible
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long id;
	
	
	private String name;


	public Employee(String name) {
		super();
		this.name = name;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
	
}
