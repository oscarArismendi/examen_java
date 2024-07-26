package com.examen_java.gender.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examen_java.gender.domain.entity.Gender;
import com.examen_java.gender.domain.service.GenderService;
import com.examen_java.resorces.DatabaseConfig;

public class GenderRepository implements GenderService {

    @Override
    public List<Gender> listAll() {
        String sql = "SELECT id,name FROM gender";
        List<Gender> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Gender gender = new Gender(resultSet.getInt("id"),resultSet.getString("name"));
                objects.add(gender);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

}
