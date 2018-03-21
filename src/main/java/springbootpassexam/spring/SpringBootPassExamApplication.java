package springbootpassexam.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("controllers")
@EntityScan(basePackages = "models")

@SpringBootApplication
public class SpringBootPassExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPassExamApplication.class, args);
	}
}
