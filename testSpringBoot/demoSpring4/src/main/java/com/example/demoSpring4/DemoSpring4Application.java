package com.example.demoSpring4;

import com.example.demoSpring4.repository.PersonRepository;
import com.example.demoSpring4.spec.CustomRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class DemoSpring4Application {

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpring4Application.class, args);
	}
}
