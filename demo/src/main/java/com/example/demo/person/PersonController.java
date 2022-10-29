package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);
    }

    //pl.: DELETE http://localhost:8080/api/v2/person/1 törli ki az 1-es id-val rendelkező személyt
    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long id){
        personService.deletePerson(id);

    }
}
