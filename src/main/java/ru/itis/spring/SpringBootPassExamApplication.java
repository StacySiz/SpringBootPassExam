package ru.itis.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "ru.itis")
@EnableJpaRepositories(basePackages = "ru.itis.repository")
@EntityScan(basePackages = "ru/itis/models")

public class SpringBootPassExamApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootPassExamApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPassExamApplication.class, args);
	}
}


