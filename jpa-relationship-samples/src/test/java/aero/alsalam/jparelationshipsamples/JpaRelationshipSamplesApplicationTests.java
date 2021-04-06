package aero.alsalam.jparelationshipsamples;



import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import aero.alsalam.jparelationshipsamples.entities.Student;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JpaRelationshipSamplesApplicationTests {
	
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	void contextLoads() {
		Student student=em.find(Student.class, 1L);
		System.out.println(student);
		System.out.println(student.getPassport());
	}

}
