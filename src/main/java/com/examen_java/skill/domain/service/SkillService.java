package com.examen_java.skill.domain.service;

import java.util.List;

import com.examen_java.skill.domain.entity.Skill;

public interface SkillService {
    List<Skill> listAll();
    Skill create(Skill skill);
}
