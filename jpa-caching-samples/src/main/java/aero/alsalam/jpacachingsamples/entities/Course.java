package aero.alsalam.jpacachingsamples.entities;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Cacheable
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "course_seq")
	private Long id;
	
	private String courseName;

	
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getId() {
		return id;
	}

	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}
}
