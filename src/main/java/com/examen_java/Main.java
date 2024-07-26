package com.examen_java;

import java.util.ArrayList;
import java.util.List;

import com.examen_java.city.application.ListAllCities;
import com.examen_java.city.domain.service.CityService;
import com.examen_java.city.infrastructure.out.CityRepository;
import com.examen_java.gender.application.ListAllGenders;
import com.examen_java.gender.domain.service.GenderService;
import com.examen_java.gender.infrastructure.out.GenderRepository;
import com.examen_java.persons.application.CreatePerson;
import com.examen_java.persons.application.DeletePerson;
import com.examen_java.persons.application.ListAllPersons;
import com.examen_java.persons.application.UpdatePerson;
import com.examen_java.persons.domain.service.PersonsService;
import com.examen_java.persons.infrastructure.in.PersonsControllers;
import com.examen_java.persons.infrastructure.out.PersonsRepository;
import com.examen_java.utils.ConsoleUtils;
import com.examen_java.utils.Menus;

public class Main {
    public static void main(String[] args) {
        // services
        PersonsService personsService = new PersonsRepository();
        CityService cityService = new CityRepository();
        GenderService genderService = new GenderRepository();
        //city use cases
        ListAllCities listAllCities = new ListAllCities(cityService);
        //gender use cases
        ListAllGenders listAllGenders = new ListAllGenders(genderService);
        // person use cases
        ListAllPersons listAllPersons = new ListAllPersons(personsService);
        CreatePerson createPerson = new CreatePerson(personsService);
        DeletePerson deletePerson = new DeletePerson(personsService);
        UpdatePerson updatePerson = new UpdatePerson(personsService);
        //Controllers
        PersonsControllers personsControllers = new PersonsControllers(createPerson, updatePerson, deletePerson, listAllPersons, listAllCities, listAllGenders);
        Boolean isRunning = true;
        List<String> listMainMenu = new ArrayList<>();
        listMainMenu.add("Register person");
        listMainMenu.add("Asign person skill");
        listMainMenu.add("Create skill");
        listMainMenu.add("Consult person for skill");
        listMainMenu.add("Update person");
        listMainMenu.add("Delete person");
        listMainMenu.add("Exit");



        while (isRunning) {
            ConsoleUtils.cleanScreen();
            System.out.println("---------------------MAIN PERSON MENU----------------------------------");
            String strOp = Menus.mainMenu(listMainMenu,"What do you want to do?");
            switch (strOp) {
                case "Register person":
                    ConsoleUtils.cleanScreen();
                    System.out.println("-------------------CREATE PERSON MENU----------------------------------");
                    personsControllers.createPersonLogic();
                    ConsoleUtils.pause();
                    break;
                case "Update person":
                    ConsoleUtils.cleanScreen();
                    System.out.println("--------------------UPDATE PERSON MENU----------------------------------");
                    personsControllers.updatePersonLogic();
                    ConsoleUtils.pause();
                    break;
                case "Delete person":
                    ConsoleUtils.cleanScreen();
                    System.out.println("---------------------DELETE PERSON MENU----------------------------------");
                    personsControllers.deletePersonLogic();
                    ConsoleUtils.pause();
                    break;
                case "Exit":
                    System.out.println("Good bye!");
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}