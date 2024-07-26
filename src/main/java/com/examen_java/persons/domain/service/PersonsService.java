package com.examen_java.persons.domain.service;

import java.util.List;

import com.examen_java.persons.domain.entity.Persons;

public interface PersonsService {
    List<Persons> listAll();
    Persons create(Persons person);
    Persons update(Persons person);
    Boolean delete(Integer id);
}
