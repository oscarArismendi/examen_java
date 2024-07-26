package com.examen_java.gender.domain.entity;

public class Gender {
    Integer id;
    String name;
    public Gender() {
    }
    public Gender(Integer id, String name) {
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
