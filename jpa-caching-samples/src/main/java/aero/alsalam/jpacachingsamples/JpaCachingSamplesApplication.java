package aero.alsalam.jpacachingsamples;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import aero.alsalam.jpacachingsamples.entities.Course;
import aero.alsalam.jpacachingsamples.repository.CourseRepository;



@SpringBootApplication
public class JpaCachingSamplesApplication implements CommandLineRunner{
	
	@Autowired 
	CourseRepository courseRepository;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(JpaCachingSamplesApplication.class, args);
	}

	@Override
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		insert();
	}
	
	@Transactional
	public void insert() {
		Course course1=new Course("Spring JPA");
		courseRepository.save(course1);
		Course course2=new Course("Spring Data Persistance");
		courseRepository.save(course2);
	}
	
	

}
