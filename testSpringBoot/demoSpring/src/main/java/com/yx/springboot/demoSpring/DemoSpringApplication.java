package com.yx.springboot.demoSpring;

import com.yx.springboot.demoSpring.bean.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoSpringApplication {

	@Value("${book.author}")
	private String author;
	@Value("${book.name}")
	private String bookName;
	@Autowired
	private Author authors;

	@RequestMapping(value = "/")
	public String sayHi(){
		return authors.getName() + ":" + authors.getAge();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}
}
