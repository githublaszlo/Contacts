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

    // pl.: PUT http://localhost:8080/api/v2/person/1?name=Béla
    // változtatja meg az 1-es id-val rendelkező személy nevét
    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable("personId") Long personId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long permanentAddressId,
            @RequestParam(required = false) Long temporaryAddressId){
        personService.updatePerson(personId, name, permanentAddressId, temporaryAddressId);
    }

}
