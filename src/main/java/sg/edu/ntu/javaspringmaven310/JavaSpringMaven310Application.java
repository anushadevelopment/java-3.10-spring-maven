package sg.edu.ntu.javaspringmaven310;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class JavaSpringMaven310Application {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(JavaSpringMaven310Application.class);

	public static void main(String[] args) {
		logger.info("Java Spring Maven Application started");
		
		SpringApplication.run(JavaSpringMaven310Application.class, args);

	}

}
