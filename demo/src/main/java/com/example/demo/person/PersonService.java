package com.example.demo.person;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PersonService {


    public List<Person> getPersons() {
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
