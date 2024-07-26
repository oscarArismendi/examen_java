package com.examen_java.personsSkills.domain.service;

import java.util.List;

import com.examen_java.personsSkills.domain.entity.PersonSkill;

public interface PersonSkillService {
    List<PersonSkill> listAll();
    PersonSkill create(PersonSkill personSkill);
}
