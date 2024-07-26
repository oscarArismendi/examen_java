package com.examen_java.skill.infrastructure.in;


import java.util.List;

import com.examen_java.skill.application.CreateSkill;
import com.examen_java.skill.application.ListAllSkills;
import com.examen_java.skill.domain.entity.Skill;

import com.examen_java.utils.MyScanner;

public class SkillController {
    private ListAllSkills listAllSkills;
    private CreateSkill createSkill;
    public SkillController(ListAllSkills listAllSkills, CreateSkill createSkill) {
        this.listAllSkills = listAllSkills;
        this.createSkill = createSkill;
    }
    
    public void createSkillLogic(){
        try {
            
            System.out.print("Type the name: ");
            String name = MyScanner.scanLine();
            if(name.isEmpty()){
                throw new Exception("You didn't put a name");
            }
            List<Skill> listSkills = listAllSkills.execute();
            for(Skill skill : listSkills){
                if(skill.getName().toLowerCase().equals(name.toLowerCase())){
                    throw new Exception("There is already in the database as: "+ skill.toString());
                }
            }
            Skill skill = new Skill(0, name);
            if(createSkill.execute(skill) == null){
                throw new Exception("The skill couldn't be insert in the database.");
            }
            
        } catch (Exception e) {
            System.out.println("Error at creating a skill: " + e.getMessage());
        }
    }
}
