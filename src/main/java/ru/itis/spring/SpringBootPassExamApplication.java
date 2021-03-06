package ru.itis.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("ru.itis")
@EnableJpaRepositories(basePackages = "ru.itis.repository")
@EntityScan(basePackages = "ru/itis/models")

public class SpringBootPassExamApplication {
	private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SpringBootPassExamApplication.class);
//	}
	public static void main(String[] args) throws Exception  {
		SpringApplication.run(SpringBootPassExamApplication.class, args);

	}
}


