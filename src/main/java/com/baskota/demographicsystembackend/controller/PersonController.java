package com.baskota.demographicsystembackend.controller;

import com.baskota.demographicsystembackend.model.Person;
import com.baskota.demographicsystembackend.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/search/all")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/search")
    public List<Person> findById(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name
    ) {
        if (id != null) {
            Optional<Person> person = personService.findById(id);
            if (person.isPresent()) {
                return List.of(person.get());
            }
        } else if (name != null) {
            return personService.findByFirstNameOrLastName(name);
        }

        return new ArrayList<>();
    }

    @PostMapping("/save")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        if (person.getId() == null || personService.findById(person.getId()).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(personService.update(person));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (personService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        personService.deleteById(id);

        return ResponseEntity.ok("Deleted person with id " + id);
    }
}
