package aero.alsalam.jpainheritancesamples;

import java.math.BigDecimal;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import aero.alsalam.jpainheritancesamples.entity.FulltimeEmployee;
import aero.alsalam.jpainheritancesamples.entity.ParttimeEmployee;
import aero.alsalam.jpainheritancesamples.repository.EmployeeRepository;

@SpringBootApplication
public class JpaInheritanceSamplesApplication  implements CommandLineRunner{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	Logger logger=Logger.getLogger(JpaInheritanceSamplesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaInheritanceSamplesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		employeeRepository.insert(new FulltimeEmployee("Balaji",BigDecimal.valueOf(7500.0)));
		employeeRepository.insert(new ParttimeEmployee("David",BigDecimal.valueOf(75.0)));
		
		
		logger.info("Employee -> "+employeeRepository.retrieveAllEmployees());
		
	}

}
