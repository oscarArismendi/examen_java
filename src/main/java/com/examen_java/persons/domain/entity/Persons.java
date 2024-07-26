package com.examen_java.persons.domain.entity;

public class Persons {
    Integer id;
    String name;
    String lastName;
    Integer idcity;
    String address;
    Integer age;
    String email;
    Integer idgender;
    public Persons() {
    }

    
    public Persons(Integer id, String name, String lastName, Integer idcity, String address, Integer age, String email,
            Integer idgender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.idcity = idcity;
        this.address = address;
        this.age = age;
        this.email = email;
        this.idgender = idgender;
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
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getIdcity() {
        return idcity;
    }
    public void setIdcity(Integer idcity) {
        this.idcity = idcity;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getIdgender() {
        return idgender;
    }
    public void setIdgender(Integer idgender) {
        this.idgender = idgender;
    }
    @Override
    public String toString() {
        return " id: " + id + " | name: " + name + " | lastName: " + lastName;
    }

    
}
