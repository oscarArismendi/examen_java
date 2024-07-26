package com.examen_java.persons.application;

import com.examen_java.persons.domain.entity.Persons;
import com.examen_java.persons.domain.service.PersonsService;

public class CreatePerson {
    private final PersonsService personsService;

    public CreatePerson(PersonsService personsService) {
        this.personsService = personsService;
    }

    public Persons execute(Persons person){
        return personsService.create(person);
    }
}
