package org.example.repository;

import org.example.unit.Phones;

import java.util.List;

public interface PhonesRepository {
    void save(Phones phones);

    Phones getById(Long id);

    void deleteById(Long id);

    List<Phones> findAll();

    void deleteAll();
}