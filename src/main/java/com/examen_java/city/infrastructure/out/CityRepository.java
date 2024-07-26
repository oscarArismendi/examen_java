package com.examen_java.city.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examen_java.city.domain.entity.City;
import com.examen_java.city.domain.service.CityService;
import com.examen_java.resorces.DatabaseConfig;

public class CityRepository implements CityService {

    @Override
    public List<City> listAll() {
        String sql = "SELECT id,name,idregion FROM city";
        List<City> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                City city = new City(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("idregion"));
                objects.add(city);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

}
