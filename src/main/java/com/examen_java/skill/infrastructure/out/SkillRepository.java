package com.examen_java.skill.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examen_java.resorces.DatabaseConfig;
import com.examen_java.skill.domain.entity.Skill;
import com.examen_java.skill.domain.service.SkillService;

public class SkillRepository implements SkillService{

    @Override
    public List<Skill> listAll() {
        String sql = "SELECT id,name FROM skill";
        List<Skill> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Skill skill = new Skill(resultSet.getInt("id"),
                resultSet.getString("name"));
                objects.add(skill);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    @Override
    public Skill create(Skill skill) {
        String sql = "INSERT INTO skill (name) VALUES (?)";

        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,
        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, skill.getName());

            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    skill.setId(generatedKeys.getInt(1));
                }
                System.out.println("Skill created successfully!");
                return skill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at creating a skill: " + e.getMessage());
        }
        return null;
    }

}
