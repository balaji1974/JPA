package aero.alsalam.jpacachingsamples;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import aero.alsalam.jpacachingsamples.entities.Course;

// Run this application as Junit Test
@ExtendWith(SpringExtension.class)
@SpringBootTest
class JpaCachingSamplesApplicationTests {
	
	@Autowired
	EntityManager em;
	 

	@Test
	void contextLoads() {
	}

	// This is the first level cache and will work outside of the Application startup program
	@Test
	@Disabled
	@Transactional
	public void retrieve() {
		//Optional<Course> result1 = courseRepository.findById(1L);
		//System.out.println("Result is :"+result1.get().getCourseName());
		//Optional<Course> result2 = courseRepository.findById(1L);
		//System.out.println("Result is :"+result2.get().getCourseName());
		Course course1 = em.find(Course.class, 1L);
		assertEquals("Spring JPA",course1.getCourseName());
		Course course2 = em.find(Course.class, 1L);
		assertEquals("Spring JPA",course2.getCourseName());
	}
	
	// This is the second level cache and no hits to the DB as data is cached during its insert into the database
	@Test
	@Transactional
	public void tesingCachableRetrieve1() {
		Course course1 = em.find(Course.class, 1L);
		assertEquals("Spring JPA",course1.getCourseName());
	}
	
	// This is the second level cache and no hits to the DB as data is cached during its insert into the database
	@Test
	@Transactional
	public void tesingCachableRetrieve2() {
		Course course1 = em.find(Course.class, 1L);
		assertEquals("Spring JPA",course1.getCourseName());
	}
	
	// This is the second level cache and this will hit the DB as data is not cached during its insert into the database since this data is not present
	@Test
	@Transactional
	public void tesingCachableRetrieve3() {
		Course course1 = em.find(Course.class, 3L);
		assertNotEquals("Spring JPA",course1.getCourseName());
	}
	
}
