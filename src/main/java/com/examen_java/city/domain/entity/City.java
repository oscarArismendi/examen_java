package com.examen_java.city.domain.entity;

public class City {
    Integer id;
    String name;
    Integer idregion;
    public City() {
    }
    public City(Integer id, String name, Integer idregion) {
        this.id = id;
        this.name = name;
        this.idregion = idregion;
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
    public Integer getIdregion() {
        return idregion;
    }
    public void setIdregion(Integer idregion) {
        this.idregion = idregion;
    }
    
    @Override
    public String toString() {
        return " id: " + id + " | name: " + name;
    }
}
