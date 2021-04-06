package aero.alsalam.jparelationshipsamples.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "review_seq")
	private Long id;
	
	private Integer ratings;
	
	private String description;
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	private Student student;
	
	public Review(Integer ratings, String description) {
		super();
		this.ratings = ratings;
		this.description = description;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getRatings() {
		return ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	@Override
	public String toString() {
		return "Review [id=" + id + ", ratings=" + ratings + ", description=" + description + "]";
	}

	
}
