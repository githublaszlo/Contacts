package com.example.demo.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/person")
public class PersonController {

    @GetMapping
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
