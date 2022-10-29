package com.example.demo;

import com.example.demo.person.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@GetMapping
	public List<Person> hello() {
			return List.of(
					new Person(
							1L,
							"Alex",
							1L,
							2L
					)
			);


	}
}
