package aero.alsalam.jparelationshipsamples.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "passport_seq")
	private Long id;
	
	private String passportNumber;
	
	@OneToOne(mappedBy="passport")
	Student student;

	public Passport(String passportNumber) {
		super();
		this.passportNumber = passportNumber;
	}

	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + "]";
	}
	
	
}
