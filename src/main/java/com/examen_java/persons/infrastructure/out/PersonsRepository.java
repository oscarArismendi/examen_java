package com.examen_java.persons.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examen_java.persons.domain.entity.Persons;
import com.examen_java.persons.domain.service.PersonsService;
import com.examen_java.resorces.DatabaseConfig;

public class PersonsRepository implements PersonsService {

    @Override
    public List<Persons> listAll() {
         String sql = "SELECT id,name,lastname,idcity,address,age,email,idgender FROM persons";
        List<Persons> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Persons person = new Persons(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("lastname"),
                resultSet.getInt("idcity"),
                resultSet.getString("address"),
                resultSet.getInt("age"),
                resultSet.getString("email"),
                resultSet.getInt("idgender"));
                objects.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    @Override
    public Persons create(Persons person) {
        String sql = "INSERT INTO persons (name,lastname,idcity,address,age,email,idgender) VALUES (?, ?, ?, ? , ? ,? , ?)";

        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,
        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getIdcity());
            statement.setString(4, person.getAddress());
            statement.setInt(5, person.getAge());
            statement.setString(6, person.getEmail());
            statement.setInt(7, person.getIdgender());

            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    person.setId(generatedKeys.getInt(1));
                }
                System.out.println("Person created successfully!");
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at creating a person: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean update(String updateColumns, Persons person) {
        String query = "UPDATE persons SET " + updateColumns + " WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, person.getId());
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Person updated successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at updating the person: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM persons WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Person deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at deleting the person: " + e.getMessage());
        }
        return false;
    }

}
