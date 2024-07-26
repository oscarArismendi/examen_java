package com.examen_java.personsSkills.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examen_java.persons.domain.entity.Persons;
import com.examen_java.personsSkills.domain.entity.PersonSkill;
import com.examen_java.personsSkills.domain.service.PersonSkillService;
import com.examen_java.resorces.DatabaseConfig;

public class PersonSkillRepository implements PersonSkillService {

    @Override
    public List<PersonSkill> listAll() {
        String sql = "SELECT id,registration_date,iperson,idskill FROM persons_skill";
        List<PersonSkill> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PersonSkill personSkill = new PersonSkill(resultSet.getInt("id"),
                resultSet.getDate("registration_date"),
                resultSet.getInt("iperson"),
                resultSet.getInt("idskill"));
                objects.add(personSkill);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    @Override
    public PersonSkill create(PersonSkill personSkill) {
        String sql = "INSERT INTO persons_skill (registration_date,iperson,idskill) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,
        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, personSkill.getRegistration_date());
            statement.setInt(2, personSkill.getIperson());
            statement.setInt(3, personSkill.getIdskill());


            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    personSkill.setId(generatedKeys.getInt(1));
                }
                System.out.println("Person Skill successfully created!");
                return personSkill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at creating person skill: " + e.getMessage());
        }
        return null;
    }

}
