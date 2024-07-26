package com.examen_java.city.application;

import java.util.List;

import com.examen_java.city.domain.entity.City;
import com.examen_java.city.domain.service.CityService;

public class ListAllCities {
    private final CityService cityService;

    public ListAllCities(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> execute(){
        return cityService.listAll();
    }
}
