package aero.alsalam.jparelationshipsamples.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "course_seq")
	private Long id;
	
	private String courseName;
	
	@OneToMany(mappedBy="course")
	private List<Review> reviews=new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students=new ArrayList<>();
	
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		reviews.add(review); 
	}
	
	public void removeReview(Review review) {
		reviews.remove(review); 
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		students.add(student);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}
}
