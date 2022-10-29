package com.example.demo.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
            Person alex = new Person(
                    "Alex",
                    1L,
                    2L
            );
            Person maria = new Person(
                    "Maria",
                    1L,
                    2L
            );

            repository.saveAll(
                    List.of(alex, maria)
            );

        };
    }
}
