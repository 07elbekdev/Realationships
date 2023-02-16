package org.example.repository;

import org.example.unit.Person;

import java.util.List;

public interface PersonRepository {
    void save(Person person);
    Person getById(Long id);
    void deleteById(Long id);
    List<Person> findAll();
    void deleteAll();
}