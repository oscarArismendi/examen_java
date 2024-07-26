package com.examen_java.gender.application;

import java.util.List;

import com.examen_java.gender.domain.entity.Gender;
import com.examen_java.gender.domain.service.GenderService;

public class ListAllGenders {
    private final GenderService genderService;

    public ListAllGenders(GenderService genderService) {
        this.genderService = genderService;
    }

    public List<Gender> execute(){
        return genderService.listAll();
    }
}
