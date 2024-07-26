package com.examen_java.personsSkills.application;

import com.examen_java.personsSkills.domain.entity.PersonSkill;
import com.examen_java.personsSkills.domain.service.PersonSkillService;

public class CreatePersonSkill {
    private final PersonSkillService personSkillService;

    public CreatePersonSkill(PersonSkillService personSkillService) {
        this.personSkillService = personSkillService;
    }

    public PersonSkill execute(PersonSkill personSkill){
        return personSkillService.create(personSkill);
    }
}
