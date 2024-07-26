package com.examen_java.skill.domain.entity;

public class Skill {
    Integer id;
    String name;
    public Skill() {
    }
    public Skill(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    @Override
    public String toString() {
        return " id: " + id + " | name: " + name;
    }
}
