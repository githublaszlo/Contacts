package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByName(person.getName());
        if (personOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        boolean exists = personRepository.existsById(personId);
        if (!exists) {
            throw new IllegalStateException(
                    "person with id " + personId + " does not exists");
        }
        personRepository.deleteById(personId);
    }

    @Transactional
    public void updatePerson(Long personId,
                             String name,
                             Long permanentAddressId,
                             Long temporaryAddressId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalStateException(
                        "person with id " + personId + " does not exist"));

        if (name != null &&
        name.length() > 0 &&
        !Objects.equals(person.getName(), name)) {
            Optional<Person> personOptional = personRepository.findPersonByName(name);
            if (personOptional.isPresent()){
                throw new IllegalStateException("name taken");
            }
            person.setName(name);
        }

        // megnézni, hogy van-e adott id-val cím.
        boolean permAddressExist = true;
        if (permanentAddressId != null && permAddressExist &&
        !Objects.equals(person.getPermanentAddressId(), permanentAddressId)) {
            person.setPermanentAddressId(permanentAddressId);
        }

        // megnézni, hogy van-e adott id-val cím.
        boolean tempAddressExist = true;
        if (temporaryAddressId != null && tempAddressExist &&
                !Objects.equals(person.getTemporaryAddressId(), temporaryAddressId)) {
            person.setTemporaryAddressId(temporaryAddressId);
        }

    }
}
