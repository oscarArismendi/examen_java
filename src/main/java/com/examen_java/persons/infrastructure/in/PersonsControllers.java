package com.examen_java.persons.infrastructure.in;

import java.util.List;

import com.examen_java.city.application.ListAllCities;
import com.examen_java.city.domain.entity.City;
import com.examen_java.gender.application.ListAllGenders;
import com.examen_java.gender.domain.entity.Gender;
import com.examen_java.persons.application.CreatePerson;
import com.examen_java.persons.application.DeletePerson;
import com.examen_java.persons.application.ListAllPersons;
import com.examen_java.persons.application.UpdatePerson;
import com.examen_java.persons.domain.entity.Persons;
import com.examen_java.utils.ConsoleUtils;
import com.examen_java.utils.Menus;
import com.examen_java.utils.MyScanner;

public class PersonsControllers {
    private CreatePerson createPerson;
    private UpdatePerson updatePerson;
    private DeletePerson deletePerson;
    private ListAllPersons listAllPersons;
    private ListAllCities listAllCities;
    private ListAllGenders listAllGenders;
    public PersonsControllers(CreatePerson createPerson, UpdatePerson updatePerson, DeletePerson deletePerson,
            ListAllPersons listAllPersons, ListAllCities listAllCities, ListAllGenders listAllGenders) {
        this.createPerson = createPerson;
        this.updatePerson = updatePerson;
        this.deletePerson = deletePerson;
        this.listAllPersons = listAllPersons;
        this.listAllCities = listAllCities;
        this.listAllGenders = listAllGenders;
    }

    public void createPersonLogic(){
        try {
            
            System.out.print("Type the name: ");
            String name = MyScanner.scanLine();
            if(name.isEmpty()){
                throw new Exception("You didn't put a name");
            }
            //lastname
            System.out.print("Type the lastname: ");
            String lastname = MyScanner.scanLine();
            if(lastname.isEmpty()){
                throw new Exception("You didn't put the lastname");
            }
            // city
            List<City> listCities = listAllCities.execute();
            if(listCities.isEmpty()){
                throw new Exception("There aren't cities in the database. Contact service.");
            }
            int cityPos = Menus.listMenu(listCities, "Choose a city: ");
            City city = listCities.get(cityPos);
            //address
            System.out.print("Type the address: ");
            String address = MyScanner.scanLine();
            if(address.isEmpty()){
                throw new Exception("You didn't put the address");
            }
            //age
            System.out.print("Type the age: ");
            Integer age = MyScanner.scanInt();
            if(age < 0){
                throw new Exception("There can't be person with less than 0 years");
            }
            if(age > 110){
                throw new Exception("We doubt that there is a person with "+ age + " years");
            }
            //email
            System.out.print("Type the email: ");
            String email = MyScanner.scanLine();
            if(email.isEmpty()){
                throw new Exception("You didn't put the email");
            }
            //gender              
            List<Gender> listGenders = listAllGenders.execute();
            if(listGenders.isEmpty()){
                throw new Exception("There aren't genders in the database. Contact service.");
            }
            int genderPos = Menus.listMenu(listGenders, "Choose a gender: ");
            Gender gender = listGenders.get(genderPos);
            Persons person = new Persons(0, name, lastname, city.getId(), address, age, email, gender.getId());
            if(createPerson.execute(person) == null){
                throw new Exception("The person couldn't be insert in the database.");
            }
            
        } catch (Exception e) {
            System.out.println("Error at creating a person: " + e.getMessage());
        }
    }

    public void updatePersonLogic(){
        try {
            //persons              
            List<Persons> listPersons = listAllPersons.execute();
            if(listPersons.isEmpty()){
                throw new Exception("There aren't persons in the database. Contact service.");
            }
            int personPos = Menus.listMenu(listPersons, "Choose a person: ");
            Persons person = listPersons.get(personPos);
            System.out.print("Type the new name(actual: " + person.getName() + "): ");
            String name = MyScanner.scanLine();
            if(name.isEmpty()){
                throw new Exception("You didn't put a name");
            }
            //lastname
            System.out.print("Type the new lastname(actual: " + person.getLastName() + "): ");
            String lastname = MyScanner.scanLine();
            if(lastname.isEmpty()){
                throw new Exception("You didn't put the lastname");
            }
            // city
            List<City> listCities = listAllCities.execute();
            if(listCities.isEmpty()){
                throw new Exception("There aren't cities in the database. Contact service.");
            }
            int cityPos = Menus.listMenu(listCities, "Choose a city(actual: " + person.getIdcity() + "): ");
            City city = listCities.get(cityPos);
            //address
            System.out.print("Type the new address(actual: " + person.getAddress() + "): ");
            String address = MyScanner.scanLine();
            if(address.isEmpty()){
                throw new Exception("You didn't put the address");
            }
            //age
            System.out.print("Type the new age(actual: " + person.getAge() + "): ");
            Integer age = MyScanner.scanInt();
            if(age < 0){
                throw new Exception("There can't be person with less than 0 years");
            }
            if(age > 110){
                throw new Exception("We doubt that there is a person with "+ age + " years");
            }
            //email
            System.out.print("Type the new email(actual: " + person.getEmail() + "): ");
            String email = MyScanner.scanLine();
            if(email.isEmpty()){
                throw new Exception("You didn't put the email");
            }
            //gender              
            List<Gender> listGenders = listAllGenders.execute();
            if(listGenders.isEmpty()){
                throw new Exception("There aren't genders in the database. Contact service.");
            }
            int genderPos = Menus.listMenu(listGenders, "Choose a gender(actual: " + person.getIdgender() + "): ");
            Gender gender = listGenders.get(genderPos);
            String updatedColumns = "name = '" + name +"' , ";
            updatedColumns += "lastname = '" + lastname +"' , ";
            updatedColumns += "idcity = '" + city.getId() +"' , ";
            updatedColumns += "address = '" + address +"' , ";
            updatedColumns += "age = '" + age +"' , ";
            updatedColumns += "email = '" + email +"' , ";
            updatedColumns += "idgender = '" + gender.getId() +"' ";

            if(updatePerson.execute(updatedColumns,person) == false){
                throw new Exception("The person couldn't be update in the database.");
            }
            
        } catch (Exception e) {
            System.out.println("Error at updating a person: " + e.getMessage());
        }
    }

    public void deletePersonLogic(){
        try {
            //persons              
            List<Persons> listPersons = listAllPersons.execute();
            if(listPersons.isEmpty()){
                throw new Exception("There aren't persons in the database. Contact service.");
            }
            int personPos = Menus.listMenu(listPersons, "Choose a person: ");
            Persons person = listPersons.get(personPos);
            int op = ConsoleUtils.yesOrNo("Are you sure you want to delete the person : "+ person.toString() + " ?");
            if(op == 2){
                System.out.println("You choose against doing it.");
            }else{
                if(deletePerson.execute(person.getId()) == false){
                    throw new Exception("Couldn't delete the person from the database.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error at deleting a person: " + e.getMessage());
        }
    }

}
