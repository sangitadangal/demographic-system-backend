package com.baskota.demographicsystembackend.repository;

import com.baskota.demographicsystembackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByFirstNameOrLastName(String firstName, String lastName);
}
