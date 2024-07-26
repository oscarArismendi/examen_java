package com.examen_java.personsSkills.application;

import java.util.List;

import com.examen_java.personsSkills.domain.entity.PersonSkill;
import com.examen_java.personsSkills.domain.service.PersonSkillService;

public class ListAllPersonSkills {
    private final PersonSkillService personSkillService;

    public ListAllPersonSkills(PersonSkillService personSkillService) {
        this.personSkillService = personSkillService;
    }

    public List<PersonSkill> execute(){
        return personSkillService.listAll();
    }
}
