package com.examen_java.skill.application;

import java.util.List;

import com.examen_java.skill.domain.entity.Skill;
import com.examen_java.skill.domain.service.SkillService;

public class ListAllSkills {
    private final SkillService skillService;

    public ListAllSkills(SkillService skillService) {
        this.skillService = skillService;
    }

    public List<Skill> execute(){
        return skillService.listAll();
    }
}
