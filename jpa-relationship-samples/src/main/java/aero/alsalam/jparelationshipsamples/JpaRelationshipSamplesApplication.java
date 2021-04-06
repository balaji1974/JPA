package aero.alsalam.jparelationshipsamples;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import aero.alsalam.jparelationshipsamples.entities.Course;
import aero.alsalam.jparelationshipsamples.entities.Passport;
import aero.alsalam.jparelationshipsamples.entities.Review;
import aero.alsalam.jparelationshipsamples.entities.Student;

@SpringBootApplication
public class JpaRelationshipSamplesApplication implements CommandLineRunner{
	
	@Autowired 
	EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationshipSamplesApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		// One to One
		Passport passport=new Passport("F1389678");
		em.persist(passport);
		
		Student student=new Student("Balaji");
		student.setPassport(passport);
		em.persist(student);
		
		// One to Many - Many to One
		Course course1=new Course("Spring JPA");
		em.persist(course1);
		Course course2=new Course("Spring Data Persistance");
		em.persist(course2);
		
		Review review1=new Review(5,"Great Book");
		review1.setCourse(course1);
		Review review2=new Review(5,"Wonderful Book");
		review2.setCourse(course2);
		review1.setStudent(student);
		review2.setStudent(student);
		em.persist(review1);
		em.persist(review2);
		
		// Many to Many 
		student.addCourse(course1); // associate both sides
		student.addCourse(course2);
		course1.addStudent(student); // associate both sides
		course1.addStudent(student);
		em.persist(student); // Owning side must be persisted
		
		
		
	}

}
