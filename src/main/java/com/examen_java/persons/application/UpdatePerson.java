package com.examen_java.persons.application;

import com.examen_java.persons.domain.entity.Persons;
import com.examen_java.persons.domain.service.PersonsService;

public class UpdatePerson {
    private final PersonsService personsService;

    public UpdatePerson(PersonsService personsService) {
        this.personsService = personsService;
    }

    public Boolean execute(String updatedColumns, Persons person){
        return personsService.update(updatedColumns,person);
    }
}
