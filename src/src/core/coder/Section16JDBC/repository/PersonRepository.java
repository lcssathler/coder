package core.coder.Section16JDBC.repository;

import core.coder.Section16JDBC.domain.ConnectionJDBC;
import core.coder.Section16JDBC.domain.Person;
import core.coder.Section16JDBC.domain.PersonBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    public static void insertPerson(String name) {
        String sql = "INSERT INTO person (name) VALUES (?);";

        try (Connection conn = ConnectionJDBC.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            preparedStatement.execute();
            System.out.println("Person inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Person> findAllPerson() {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM person;";
        try (Connection conn = ConnectionJDBC.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int codeDB = resultSet.getInt("code");
                String nameDB = resultSet.getString("name");
                Person personDB = PersonBuilder.builder()
                        .code(codeDB)
                        .name(nameDB)
                        .build();
                personList.add(personDB);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }
}