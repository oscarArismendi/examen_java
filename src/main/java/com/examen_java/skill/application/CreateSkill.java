package com.examen_java.skill.application;

import com.examen_java.skill.domain.entity.Skill;
import com.examen_java.skill.domain.service.SkillService;

public class CreateSkill {
    private final SkillService skillService;

    public CreateSkill(SkillService skillService) {
        this.skillService = skillService;
    }

    public Skill execute(Skill skill){
        return skillService.create(skill);
    }
}
