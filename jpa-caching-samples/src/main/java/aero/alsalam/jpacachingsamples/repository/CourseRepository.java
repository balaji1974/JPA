package aero.alsalam.jpacachingsamples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aero.alsalam.jpacachingsamples.entities.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{
	
}
