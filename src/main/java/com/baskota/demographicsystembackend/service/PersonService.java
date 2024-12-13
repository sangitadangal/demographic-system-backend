package com.baskota.demographicsystembackend.service;

import com.baskota.demographicsystembackend.model.Person;
import com.baskota.demographicsystembackend.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> findByFirstNameOrLastName(String name) {
        return personRepository.findByFirstNameOrLastName(name, name);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public Person update(Person person) {
        return personRepository.save(person);
    }
}
