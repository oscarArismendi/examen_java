package com.examen_java.personsSkills.domain.entity;

import java.sql.Date;

public class PersonSkill {
    Integer id;
    Date registration_date;
    Integer iperson;
    Integer idskill;

    public PersonSkill() {
    }

    
    public PersonSkill(Integer id, Date registration_date, Integer iperson, Integer idskill) {
        this.id = id;
        this.registration_date = registration_date;
        this.iperson = iperson;
        this.idskill = idskill;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Integer getIperson() {
        return iperson;
    }

    public void setIperson(Integer iperson) {
        this.iperson = iperson;
    }

    public Integer getIdskill() {
        return idskill;
    }

    public void setIdskill(Integer idskill) {
        this.idskill = idskill;
    }

    @Override
    public String toString() {
        return " id: " + id + " | registration date: " + registration_date;
    }

}
