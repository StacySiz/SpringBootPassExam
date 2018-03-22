package springbootpassexam.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("java")
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "models")

public class SpringBootPassExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPassExamApplication.class, args);
	}
}


