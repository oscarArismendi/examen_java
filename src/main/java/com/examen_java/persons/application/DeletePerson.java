package com.examen_java.persons.application;

import com.examen_java.persons.domain.service.PersonsService;

public class DeletePerson {
    private final PersonsService personsService;

    public DeletePerson(PersonsService personsService) {
        this.personsService = personsService;
    }

    public Boolean execute(Integer id){
        return personsService.delete(id);
    }
}
