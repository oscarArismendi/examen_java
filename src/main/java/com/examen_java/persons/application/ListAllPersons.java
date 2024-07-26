package com.examen_java.persons.application;

import java.util.List;

import com.examen_java.persons.domain.entity.Persons;
import com.examen_java.persons.domain.service.PersonsService;

public class ListAllPersons {
    private final PersonsService personsService;

    public ListAllPersons(PersonsService personsService) {
        this.personsService = personsService;
    }

    public List<Persons> execute(){
        return personsService.listAll();
    }
}
